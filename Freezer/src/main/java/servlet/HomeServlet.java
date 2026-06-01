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

import model.dao.FoodLostDayDAO;
import model.entity.FoodBean;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home-servlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
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
		
		List<FoodBean> foodlostdayList = null;
		
		FoodLostDayDAO dao = new FoodLostDayDAO();
		
		
		try {
			// DAOの利用
			foodlostdayList = dao.selectFoodLostDay();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		// リクエストスコープへの属性の設定
		request.setAttribute("foodlostdayList", foodlostdayList);
		// リクエストの転送
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
	}

}
