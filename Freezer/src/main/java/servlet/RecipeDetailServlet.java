package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.RecipeDAO;
import model.entity.RecipeBean;

/**
 * Servlet implementation class RecipeDetailServlet
 */
@WebServlet("/recipe-detail-servlet")
public class RecipeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeDetailServlet() {
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
		String RecipeId2 = request.getParameter("RecipeId2");
		// DAOの生成
		RecipeDAO dao = new RecipeDAO();
		try {
			RecipeBean recipe = dao.select(RecipeId2);
			// セッションオブジェクトの取得
			HttpSession session = request.getSession();
			// セッションスコープへの属性の設定
			session.setAttribute("recipe", recipe);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("recipe-detail.jsp");
		rd.forward(request, response);
	}

}


