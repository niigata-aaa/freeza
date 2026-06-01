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

import model.dao.FoodDao;
import model.entity.FoodBean;

/**
 * Servlet implementation class FoodListServlet
 */
@WebServlet("/food-list-servlet")
public class FoodListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<FoodBean> foodList = null;
		
		// DAOの生成
	    FoodDao dao = new FoodDao();
	    
	    try {
	    	// DAOの利用
	    	foodList = dao.selectAllFood();
	    } catch (SQLException | ClassNotFoundException e) {
	    	e.printStackTrace();
	    }
	    
	 // リクエストスコープへの属性の設定
	 		request.setAttribute("foodList", foodList);
	 		request.getSession().setAttribute("foodList", foodList);
	 		
	 	// リクエストの転送
			RequestDispatcher rd = request.getRequestDispatcher("food-list.jsp");
			rd.forward(request, response);
	}

}