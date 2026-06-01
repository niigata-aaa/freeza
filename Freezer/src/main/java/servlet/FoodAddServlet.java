package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.FoodDao;
import model.entity.FoodBean;

/**
 * Servlet implementation class FoodAddServlet
 */
@WebServlet("/food-add-servlet")
public class FoodAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FoodAddServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// セッションからデータ取り出し
		HttpSession session = request.getSession();

		String foodName = (String) session.getAttribute("foodName");
		String numberStr = (String) session.getAttribute("number");

		// 「java.sql.Date」のキャスト処理
		java.sql.Date foodLostDay = (java.sql.Date) session.getAttribute("foodLostDay");

		String foodImage = (String) session.getAttribute("foodImage");

		// 入力チェック
		if (foodName == null) {
			System.out.println("【警告】食材名が追加されていません。入力画面に戻ります。");
			response.sendRedirect("food-add.jsp");
			return;
		}

		// キャスト（数量の変換）
		int foodQuantity = 0;
		if (numberStr != null && !numberStr.isEmpty()) {
			foodQuantity = Integer.parseInt(numberStr);
		}

		// Beanに値をセット
		FoodBean food = new FoodBean();
		food.setFoodName(foodName);
		food.setFoodQuantity(foodQuantity); 
		food.setFoodLostDay(foodLostDay); 
		food.setFoodImage(foodImage);
		// データベースへ登録
		FoodDao dao = new FoodDao();
		try {
			dao.insert(food); 
			System.out.println("【成功】データベースに食材「" + foodName + "」を登録しました！");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("【失敗】登録中にエラーが発生しました。");
			e.printStackTrace();
		}

		// セッション削除
		session.removeAttribute("foodName");
		session.removeAttribute("number");
		session.removeAttribute("unit");
		session.removeAttribute("date");
		session.removeAttribute("foodLostDay");
		session.removeAttribute("foodImage");

		response.sendRedirect("food-list-servlet");
	}
}