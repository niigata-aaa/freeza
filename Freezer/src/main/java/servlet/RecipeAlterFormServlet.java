package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.RecipePersonalDAO;
import model.entity.RecipeBean;

@WebServlet("/recipe-alter-form-servlet")
public class RecipeAlterFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int recipeId =
            Integer.parseInt(request.getParameter("id"));

        RecipePersonalDAO dao = new RecipePersonalDAO();

        try {
            RecipeBean employee = dao.select(recipeId);

            request.setAttribute("employee", employee);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd =
            request.getRequestDispatcher("recipealterform.jsp");

        rd.forward(request, response);
    }
}