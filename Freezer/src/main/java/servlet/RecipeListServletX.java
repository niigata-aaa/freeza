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

import model.dao.RecipePersonalDAO;
import model.entity.RecipeBean;

/**
 * Servlet implementation class RecipeAllServlet
 */
@WebServlet("/recipe-list-servletX")
public class RecipeListServletX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeListServletX() {
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
		// TODO Auto-generated method stub
				List<RecipeBean> RecipeParsonalList = null;
				
				RecipePersonalDAO dao = new RecipePersonalDAO();
				
				try {
					RecipeParsonalList  = dao.selectAll();
				}catch(SQLException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				request.setAttribute("RecipeParsonalList", RecipeParsonalList);
				
				RequestDispatcher rd = request.getRequestDispatcher("recipelist.jsp");
				rd.forward(request,response);
			}

}
