package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.RecipePersonalDAO;
import model.entity.RecipeBean;

/**
 * Servlet implementation class RecipeAlterServlet
 */
@WebServlet("/recipe-alter-servlet")
public class RecipeAlterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeAlterServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    request.setCharacterEncoding("UTF-8");

	    try {

	        int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
	        String ingredients = request.getParameter("ingredients");
	        String howto = request.getParameter("howto");
	        int servings = Integer.parseInt(request.getParameter("servings"));

	        RecipeBean bean = new RecipeBean();
	        bean.setRecipeId(id);
	        bean.setRecipeName(name);
	        bean.setRecipeIngredients(ingredients);
	        bean.setRecipeHowto(howto);
	        bean.setRecipeServings(servings);

	        RecipePersonalDAO dao = new RecipePersonalDAO();
	        int result = dao.recipeupdate(bean);

	        request.setAttribute("processingNumber", result);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    request.getRequestDispatcher("recipealterresult.jsp")
	           .forward(request, response);
	}
}