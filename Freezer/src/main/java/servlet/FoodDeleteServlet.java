package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.FoodDao;

/**
 * Servlet implementation class FoodDeleteServlet
 */
@WebServlet("/food-delete-servlet")
public class FoodDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FoodDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		
		String foodIdStr = request.getParameter("foodId");

		//データベースの削除
		if (foodIdStr != null && !foodIdStr.isEmpty()) {
			int foodId = Integer.parseInt(foodIdStr);

			FoodDao dao = new FoodDao();
			try {
				dao.delete(foodId); 
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("food-list-servlet");
	}
}