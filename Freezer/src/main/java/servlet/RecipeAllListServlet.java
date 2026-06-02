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
* Servlet implementation class RecipeAllListServlet
*/
@WebServlet("/recipe-all-list-servlet")
public class RecipeAllListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
   /**
    * @see HttpServlet#HttpServlet()
    */
   public RecipeAllListServlet() {
       super();
       // TODO Auto-generated constructor stub
   }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doPost(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<RecipeBean> recipeList = null;
		// DAOの生成
		RecipeDAO dao = new RecipeDAO();
		try {
			// DAOの利用
			recipeList = dao.selectAll();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		// リクエストスコープへの属性の設定
		request.setAttribute("recipeList", recipeList);
		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("multi-all-recipe.jsp");
		rd.forward(request, response);
	}
}


