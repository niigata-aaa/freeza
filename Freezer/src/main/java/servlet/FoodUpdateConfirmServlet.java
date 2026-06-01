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
 * Servlet implementation class FoodUpdateConfirmServlet
 */
@WebServlet("/food-update-confirm-servlet")
public class FoodUpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FoodUpdateConfirmServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // フォームから値取得
        int foodId = Integer.parseInt(request.getParameter("foodId"));

        int foodQuantity = Integer.parseInt(request.getParameter("foodQuantity"));

        FoodBean food = new FoodBean();

        food.setFoodId(foodId);
        food.setFoodQuantity(foodQuantity);

        FoodDao dao = new FoodDao();

        try {

            List<FoodBean> foodList =
                    dao.selectAllFood();

            for (FoodBean f : foodList) {

                if (f.getFoodId() == foodId) {

                    food.setFoodName(f.getFoodName());
                    break;
                }
            }

        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();
        }

        // リクエストスコープへ
        request.setAttribute("updateFood", food);

        // 確認画面へ
        RequestDispatcher rd =
                request.getRequestDispatcher("food-update-confirm.jsp");

        rd.forward(request, response);
    }
}