package servlet;

import java.io.IOException;
import java.io.InputStream;
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
 * Servlet implementation class FoodAdd
 */
@WebServlet("/food-add-servlet")
public class FoodAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// セッションからデータ取り出し
        HttpSession session = request.getSession();
        
        String foodName = (String) session.getAttribute("foodName");
        String numberStr = (String) session.getAttribute("number");
        
        //java.sql.Dateをキャスト
        java.sql.Date foodLostDay = (java.sql.Date) session.getAttribute("foodLostDay");
        
        // 画像取り出し
        InputStream foodImageStream = (InputStream) session.getAttribute("foodImageStream");

        // 入力チェック
        if (foodName == null) {
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
        food.setFoodImage(foodImageStream);

        // データベースへ登録
        FoodDao dao = new FoodDao();
        try {
            dao.insert(food); 
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        //セッション削除
        session.removeAttribute("foodName");
        session.removeAttribute("number");
        session.removeAttribute("unit");
        session.removeAttribute("date");
        session.removeAttribute("foodLostDay");
        session.removeAttribute("foodImageStream");

        response.sendRedirect("food-list-servlet");
	}
}
