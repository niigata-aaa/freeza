package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RecipeAllRegistConfirmServlet
 */
@WebServlet("/recipe-all-regist-confirm-servlet")
public class RecipeAllRegistConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecipeAllRegistConfirmServlet() {
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
		
		request.setCharacterEncoding("UTF-8");

	
//		String recipeid = request.getParameter("recipeid");
		String recipename = request.getParameter("recipename");
		String recipeingredients = request.getParameter("recipeingredients");
		String recipehowto = request.getParameter("recipehowto");
		String recipeservings = request.getParameter("recipeservings");
		String posting = request.getParameter("posting");
//		String update = request.getParameter("update");

	    HttpSession session = request.getSession();		
//		session.setAttribute("recipeid", recipeid);
	    session.setAttribute("recipename", recipename);
	    session.setAttribute("recipeingredients", recipeingredients);
	    session.setAttribute("recipehowto", recipehowto);
	    session.setAttribute("recipeservings", recipeservings);
	    session.setAttribute("posting", posting);
//		session.setAttribute("update", update);

	
	    request.getRequestDispatcher("recipe-all-register-confirm.jsp").forward(request, response);
    
//		RequestDispatcher rd = request.getRequestDispatcher("recipe-all-register-confirm.jsp");
//		rd.forward(request, response);
	}
}






//package servlet;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class RecipeAllRegistConfirmServlet
// */
//@WebServlet("/recipe-all-regist-confirm-servlet")
//public class RecipeAllRegistConfirmServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public RecipeAllRegistConfirmServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RequestDispatcher rd = request.getRequestDispatcher("recipe-all-register-confirm.jsp");
//		rd.forward(request, response);
//	}
//
//}
//
//
