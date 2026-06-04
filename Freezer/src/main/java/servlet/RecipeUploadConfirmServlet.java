package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.RecipePersonalDAO;
import model.entity.RecipeBean;

@WebServlet("/recipe-upload-confirm-servlet")
public class RecipeUploadConfirmServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        String name = (String) session.getAttribute("Recipename");
        String ingredients = (String) session.getAttribute("Recipeingredients");
        String howto = (String) session.getAttribute("RecipeHowto");
        String servingsStr = (String) session.getAttribute("Recipeservings");
        byte[] imageBytes = (byte[]) session.getAttribute("recipeImageBytes");

        int servings = Integer.parseInt(servingsStr);

        RecipeBean recipe = new RecipeBean();
        recipe.setRecipeName(name);
        recipe.setRecipeIngredients(ingredients);
        recipe.setRecipeHowto(howto);
        recipe.setRecipeServings(servings);
        recipe.setRecipeImg(imageBytes);

        try {
            RecipePersonalDAO dao = new RecipePersonalDAO();
            dao.insertRecipe(recipe);

            // セッション掃除
            session.removeAttribute("Recipename");
            session.removeAttribute("Recipeingredients");
            session.removeAttribute("RecipeHowto");
            session.removeAttribute("Recipeservings");
            session.removeAttribute("recipeImageBytes");

            // ★安全にforward（URL変えない）
            request.getRequestDispatcher("recipe-list-servletX")
                    .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("recipeUploadConfirm.jsp")
                    .forward(request, response);
        }
    }
}