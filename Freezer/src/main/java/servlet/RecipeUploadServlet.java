package servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.dao.RecipePersonalDAO;
import model.entity.RecipeBean;

@WebServlet("/recipe-upload-servlet")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5) // 最大5MBまで許可
public class RecipeUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        String name = request.getParameter("recipeName");
        String ingredients = request.getParameter("recipeIngredients");
        String howto = request.getParameter("recipeHowto");
        int servings = Integer.parseInt(request.getParameter("recipeServings"));
        
        // 画像ファイルをPartオブジェクトとして安全に取得
        Part filePart = request.getPart("recipeImage");
        byte[] imgData = null;

        if (filePart != null && filePart.getSize() > 0) {
            try (InputStream is = filePart.getInputStream()) {
                imgData = is.readAllBytes(); // ストリームをバイト配列化
            }
        }
        
        RecipeBean recipe = new RecipeBean();
        recipe.setRecipeName(name);
        recipe.setRecipeImg(imgData);
        recipe.setRecipeIngredients(ingredients);
        recipe.setRecipeHowto(howto);
        recipe.setRecipeServings(servings);
        
        try {
            RecipePersonalDAO dao = new RecipePersonalDAO();
            dao.insertRecipe(recipe); // DBへインサートを実行
            
            // 投稿が完了したら、一覧表示を司るサーブレットへリダイレクト
            response.sendRedirect("recipe-list-servletX");
            
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("投稿エラーが発生しました: " + e.getMessage());
        }
    }
}