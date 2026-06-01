package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.FoodDao;

/**
 * Servlet implementation class FoodUpdateServlet
 */
@WebServlet("/food-update-servlet")
public class FoodUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FoodUpdateServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // confirm画面から受け取り
        int foodId = Integer.parseInt(request.getParameter("foodId"));
        int foodQuantity = Integer.parseInt(request.getParameter("foodQuantity"));

        // DAO生成
        FoodDao dao = new FoodDao();

        try {
            // 在庫減少処理 DAOの利用
            dao.reduceQuantity(foodId, foodQuantity);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 一覧画面へ戻る（Servlet経由で再表示）
        RequestDispatcher rd =
                request.getRequestDispatcher("food-list-servlet");
        rd.forward(request, response);
    }
}