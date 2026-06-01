package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.RecipePersonalDAO;
import model.entity.RecipeBean;

/**
 * Servlet implementation class recipeDatailServlet
 */
@WebServlet("/recipe-datail-servlet")
public class RecipeDatailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeDatailServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String recipe_iD = request.getParameter("code");
		int recipe_id = Integer.parseInt(recipe_iD);
		
		RecipePersonalDAO dao = new RecipePersonalDAO();
		
		try {
			RecipeBean employee  = dao.select(recipe_id);
			//HttpSession session = request.getSession();
			
			request.setAttribute("employee",employee);
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("recipeDetail.jsp");
		rd.forward(request,response);
	}

}
