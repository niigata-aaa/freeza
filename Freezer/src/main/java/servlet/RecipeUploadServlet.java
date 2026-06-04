package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/recipe-upload-servlet")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
public class RecipeUploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("recipeName");
        String ingredients = request.getParameter("recipeIngredients");
        String howto = request.getParameter("recipeHowto");
        int servings = Integer.parseInt(request.getParameter("recipeServings"));

        Part filePart = request.getPart("recipeImage");

        byte[] imgBytes = null;
        if (filePart != null && filePart.getSize() > 0) {
            imgBytes = filePart.getInputStream().readAllBytes();
        }

        HttpSession session = request.getSession();
        session.setAttribute("Recipename", name);
        session.setAttribute("Recipeingredients", ingredients);
        session.setAttribute("RecipeHowto", howto);
        session.setAttribute("Recipeservings", String.valueOf(servings));
        session.setAttribute("recipeImageBytes", imgBytes);

        // ★安全にforward（URL固定しない）
        request.getRequestDispatcher("recipeUploadConfirm.jsp")
                .forward(request, response);
    }
}