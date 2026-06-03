package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.RecipeDAO;
import model.entity.RecipeBean;

/**
 * Servlet implementation class RecipeAllSearch2Servlet
 */
@WebServlet("/recipe-all-search2-servlet")
public class RecipeAllSearch2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecipeAllSearch2Servlet() {
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
		// リクエストオブジェクトのエンコーディング方式の指定


		request.setCharacterEncoding("UTF-8");

		// 検索条件取得
		String RecipeName =
				request.getParameter("recipeName");

		// Beanへ格納
		RecipeBean recipe = new RecipeBean();
		recipe.setRecipeName(RecipeName);

		// DAO生成
		RecipeDAO dao = new RecipeDAO();

		try {

			// DAOの利用
			List<RecipeBean> recipeList =
					dao.searchRecipe(recipe);

			// リクエストスコープへ格納
			request.setAttribute("recipeList", recipeList);

		} catch (ClassNotFoundException
				| SQLException e) {

			e.printStackTrace();
		}

		// 検索画面へ戻る
		RequestDispatcher rd = request.getRequestDispatcher("recipe-all-search.jsp");

		rd.forward(request, response);
	}
}


