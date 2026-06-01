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
 * Servlet implementation class FoodSearchServlet
 */
@WebServlet("/food-search-servlet")
public class FoodSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public FoodSearchServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // 検索条件取得
        String foodName =
                request.getParameter("foodName");

        // Beanへ格納
        FoodBean food = new FoodBean();
        food.setFoodName(foodName);

        // DAO生成
        FoodDao dao = new FoodDao();

        try {

            // DAOの利用
            List<FoodBean> foodList =
                    dao.searchFood(food);

            // リクエストスコープへ格納
            request.setAttribute("foodList", foodList);

        } catch (ClassNotFoundException
                | SQLException e) {

            e.printStackTrace();
        }

        // 検索画面へ戻る
        RequestDispatcher rd = request.getRequestDispatcher("food-search.jsp");

        rd.forward(request, response);
    }
}