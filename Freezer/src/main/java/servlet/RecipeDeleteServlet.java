package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecipeDAO;

/**
 * Servlet implementation class RecipeDeleteServlet
 */
@WebServlet("/recipe-delete-servlet")
public class RecipeDeleteServlet extends HttpServlet {
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
	   	// リクエストオブジェクトのエンコーディング方式の指定
    	request.setCharacterEncoding("UTF-8");

        String[] ids = request.getParameterValues("delete");

        // DAOの生成
        RecipeDAO dao = new RecipeDAO();

        try {
        	// DAOの利用
			dao.delete(ids);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

        // リクエストの転送
        RequestDispatcher rd = request.getRequestDispatcher("search.jsp"); ///???あて先はどこに？
        rd.forward(request, response);
	}

}
