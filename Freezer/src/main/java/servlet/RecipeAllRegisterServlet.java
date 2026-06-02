package servlet;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

import model.dao.RecipeDAO;
import model.entity.RecipeBean;



/**
 * Servlet implementation class RecipeAllRegisterServlet
 */
@WebServlet("/recipe-all-register-servlet")
public class RecipeAllRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeAllRegisterServlet() {
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
	   	// リクエストオブジェクトのエンコーディング方式の指定
    	request.setCharacterEncoding("UTF-8");

		RecipeBean recipeBean = new RecipeBean();
		recipeBean.setRecipeId(Integer.parseInt(request.getParameter("recipeid")));
		recipeBean.setRecipeName(request.getParameter("recipename"));
		String recipeImgStr = request.getParameter("recipename");
		
		if(recipeImgStr != null && !recipeImgStr.isEmpty()) {
			try {
				byte[] bytes = recipeImgStr.getBytes("UTF-8");
				Blob blobImg = new SerialBlob(bytes);
				
				recipeBean.setRecipeImg(blobImg);
			} catch (Exception e) {
				System.out.println("画像のBlob変換でエラーが発生しました。");
				e.printStackTrace();
			}
		}
//		recipeBean.setRecipeImg(request.getParameter("recipename"));
		recipeBean.setRecipeIngredients(request.getParameter("recipename"));
		recipeBean.setRecipeHowto(request.getParameter("recipename"));
		recipeBean.setRecipeServings(Integer.parseInt(request.getParameter("recipename")));
		String postingDateStr = request.getParameter("postingdate");
		if (postingDateStr != null && !postingDateStr.isEmpty() ) {
			
			LocalDate localDate = LocalDate.parse(postingDateStr);
			
			Date finalDate = java.sql.Date.valueOf(localDate);
			recipeBean.setPostingDatetime(finalDate);
		}
		
		String updateDateStr = request.getParameter("updatedate");
		if (postingDateStr != null && !postingDateStr.isEmpty() ) {
			
			LocalDate localDate = LocalDate.parse(updateDateStr);
			
			Date finalDate = java.sql.Date.valueOf(localDate);
			recipeBean.setUpdateDatetime(finalDate);
		}
//		recipeBean.setPostingDatetime(request.getParameter("recipename"));
//		recipeBean.setUpdateDatetim(request.getParameter("recipename"));

    	// DAOの生成
        RecipeDAO dao = new RecipeDAO();
        try {
        	// DAOの利用
			dao.insert(recipeBean);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

        // リクエストの転送
        RequestDispatcher rd = request.getRequestDispatcher("multi-all-recipe.jsp");
        rd.forward(request, response);
	}

	}



