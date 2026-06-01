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

import model.dao.FoodLostDAO;
import model.entity.FoodLostBean;

/**
 * Servlet implementation class FoodLostServlet
 */
@WebServlet("/food-lost-servlet")
public class FoodLostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodLostServlet() {
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
		
		List<FoodLostBean> foodlostList = null;
		
		FoodLostDAO dao = new FoodLostDAO();
		
		try {
			// DAOの利用
			foodlostList = dao.selectAll();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		// リクエストスコープへの属性の設定
		request.setAttribute("foodlostList", foodlostList);
		// リクエストの転送
			RequestDispatcher rd = request.getRequestDispatcher("food-lost.jsp");
			rd.forward(request, response);
	}

}