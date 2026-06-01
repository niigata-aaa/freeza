package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RecipeDeleteServlet
 */
@WebServlet("/recipe-delete-servlet")
public class RecipeDeleteServlet extends HttpServlet {

	private static final String URL ="jdbc:mysql://localhost:3306/freezerdb";
	private static final String USER = "freezerU";
	private static final String PASSWORD = "freezerP";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecipeDeleteServlet() {
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

		String recipeId = request.getParameter("RecipeId");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn =
					DriverManager.getConnection(URL, USER, PASSWORD);

			String sql = "DELETE FROM t_recipe WHERE recipe_id = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(recipeId));

			int result = pstmt.executeUpdate();

			request.setAttribute("result", result);

			pstmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}

		request.getRequestDispatcher("/recipe-list-servlet")
		.forward(request, response);
	}
}
//		request.setCharacterEncoding("UTF-8");
//		String RecipeId = request.getParameter("RecipeId");
//		// DAOの生成
//		RecipeDAO dao = new RecipeDAO();
//		try {
//			dao.recipedelete(RecipeId);
//			//			// セッションオブジェクトの取得
//			//			HttpSession session = request.getSession();
//			//			// セッションスコープへの属性の設定
//			//			session.setAttribute("recipe", recipe);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		// リクエストの転送
//		RequestDispatcher rd = request.getRequestDispatcher("recipe-list-servlet");
//		rd.forward(request, response);
//	}




