package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.FoodLostDAO;
import model.dao.FoodLostDayDAO;
import model.dao.RecommendRecipeDAO;
import model.entity.FoodBean;
import model.entity.FoodLostBean;
import model.entity.RecipeBean;

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
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		List<FoodBean> foodlostdayList = null;
		List<FoodLostBean> foodlostList = null;
		List<RecipeBean> recipeList = null;
		
		FoodLostDayDAO dao = new FoodLostDayDAO();
		FoodLostDAO dao1 = new FoodLostDAO();
		RecommendRecipeDAO dao2 = new RecommendRecipeDAO();
		
		try {
			dao.moveExpiredFoods();
			// DAOの利用
			foodlostdayList = dao.selectFoodLostDay();
			foodlostList = dao1.selectAll();
			recipeList = dao2.selectIngredients();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// リクエストスコープへの属性の設定
		request.setAttribute("foodlostdayList", foodlostdayList);
		request.setAttribute("foodlostList", foodlostList);
		request.setAttribute("recipeList", recipeList);
		// リクエストの転送
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
	}

}