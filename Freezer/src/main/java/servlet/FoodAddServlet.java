package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
@MultipartConfig(maxFileSize = 1024 * 1024 * 5) // 5MB
public class FoodAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FoodAddServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// セッションからデータ取り出し
		request.setCharacterEncoding("UTF-8");

	    // 【修正】リクエストからではなく、セッションからデータを取り出す
	    HttpSession session = request.getSession();
	    
	    String foodName = (String) session.getAttribute("foodName");
	    String numberStr = (String) session.getAttribute("number");
	    java.sql.Date foodLostDay = (java.sql.Date) session.getAttribute("foodLostDay");
	    byte[] imgData = (byte[]) session.getAttribute("foodImageBytes"); // セッションから取得

	    int foodQuantity = 0;
	    if (numberStr != null && !numberStr.isEmpty()) {
	        foodQuantity = Integer.parseInt(numberStr);
	    }

	    FoodBean food = new FoodBean();
	    food.setFoodName(foodName);
	    food.setFoodQuantity(foodQuantity);
	    food.setFoodLostDay(foodLostDay);
	    food.setFoodImage(imgData); // 取得した画像バイト配列をセット

	    try {
	        new FoodDao().insert(food);
	        
	        // 【重要】登録が終わったらセッションのゴミデータを消去する
	        session.removeAttribute("foodName");
	        session.removeAttribute("number");
	        session.removeAttribute("unit");
	        session.removeAttribute("date");
	        session.removeAttribute("foodLostDay");
	        session.removeAttribute("foodImageBytes");
	        session.removeAttribute("foodImageBase64");
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    response.sendRedirect("food-list-servlet");
	}
}