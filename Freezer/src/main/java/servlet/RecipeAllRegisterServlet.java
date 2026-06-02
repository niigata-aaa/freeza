package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		HttpSession session = request.getSession();

		//		int RecipeId = (Int) session.getAttribute("recipeid");
		String RecipeName = (String) session.getAttribute("recipename");
		//		Blob RecipeImg = res.getBlob("recipe_img");
		String RecipeIngredients = (String) session.getAttribute("recipeingredients");
		String RecipeHowto = (String) session.getAttribute("recipehowto");
		String RecipeServingsstr = (String) session.getAttribute("recipeservings");
		int RecipeServings = Integer.parseInt(RecipeServingsstr);
		String PostingDatetimestr = (String) session.getAttribute("posting");

				//		Date UpdateDatetime = res.getDate("update_datetime");

				// 入力チェック
				if (RecipeName == null) {
					System.out.println("【警告】レシピ名が追加されていません。入力画面に戻ります。");
					response.sendRedirect("recipe-all-regist-form.jsp");
					return;
				}

		RecipeBean recipe = new RecipeBean();
		//		recipe.setRecipeId(RecipeId);
		recipe.setRecipeName(RecipeName);
		//		recipe.setRecipeImg(RecipeImg);
		recipe.setRecipeIngredients(RecipeIngredients);
		recipe.setRecipeHowto(RecipeHowto);
		recipe.setRecipeServings(RecipeServings);
		

//		if (RecipeServingsstr != null && !RecipeServingsstr.isEmpty() ) {
//
//			LocalDate localDate = LocalDate.parse(RecipeServingsstr);
//
//			Integer finalDate = java.sql.Integer.valueOf(localDate);
//			recipe.setRecipeServings(finalDate);
//		}
//		recipe.setRecipeServings(RecipeServings);
//		if (PostingDatetimestr != null && !PostingDatetimestr.isEmpty() ) {
//
//			LocalDate localDate = LocalDate.parse(PostingDatetimestr);
//
//			Date finalDate = java.sql.Date.valueOf(localDate);
//			recipe.setPostingDatetime(finalDate);
//		}
//		System.out.println(recipe.getPostingDatetime());
//		if (recipe.getPostingDatetime() != null) {
////            pstmt.setDate(5, recipe.getPostingDatetime());
//        } else {
//            // 現在のシステム日付（java.sql.Date）を生成してセット
            long now = System.currentTimeMillis();
            recipe.setPostingDatetime(new java.sql.Date(now));
            System.out.println(recipe.getPostingDatetime());
            
//            long now1 = System.currentTimeMillis();
            recipe.setUpdateDatetime(new java.sql.Date(now));
            System.out.println(recipe.getUpdateDatetime());
       
		//		recipe.setUpdateDatetime(UpdateDatetime);

		//		RecipeBean recipeBean = new RecipeBean();
		////		recipeBean.setRecipeId(Integer.parseInt(session.getAttribute("recipeid")));
		//		recipeBean.setRecipeName(session.getAttribute("recipename"));
		//		//		String recipeImgStr = session.getAttribute("recipename");
		//		//		
		//		//		if(recipeImgStr != null && !recipeImgStr.isEmpty()) {
		//		//			try {
		//		//				byte[] bytes = recipeImgStr.getBytes("UTF-8");
		//		//				Blob blobImg = new SerialBlob(bytes);
		//		//				
		//		//				recipeBean.setRecipeImg(blobImg);
		//		//			} catch (Exception e) {
		//		//				System.out.println("画像のBlob変換でエラーが発生しました。");
		//		//				e.printStackTrace();
		//		//			}
		//		//		}
		//
		//
		//		//		recipeBean.setRecipeImg(request.getParameter("recipename"));
		//		recipeBean.setRecipeIngredients(request.getParameter("recipeingredients"));
		//		recipeBean.setRecipeHowto(request.getParameter("recipehowto"));
		//		recipeBean.setRecipeServings(Integer.parseInt(request.getParameter("recipeservings")));
		//		String postingDateStr = request.getParameter("posting");
		//		if (postingDateStr != null && !postingDateStr.isEmpty() ) {
		//
		//			LocalDate localDate = LocalDate.parse(postingDateStr);
		//
		//			Date finalDate = java.sql.Date.valueOf(localDate);
		//			recipeBean.setPostingDatetime(finalDate);
		//		}

		//		String updateDateStr = request.getParameter("update");
		//		if (postingDateStr != null && !postingDateStr.isEmpty() ) {
		//
		//			LocalDate localDate = LocalDate.parse(updateDateStr);
		//
		//			Date finalDate = java.sql.Date.valueOf(localDate);
		//			recipeBean.setUpdateDatetime(finalDate);
		//		}
		//		recipeBean.setPostingDatetime(request.getParameter("recipename"));
		//		recipeBean.setUpdateDatetim(request.getParameter("recipename"));

		// DAOの生成


		RecipeDAO dao = new RecipeDAO();


		java.util.List<RecipeBean> recipeList = null;

		try {
			// DAOの利用（データベースへの登録）
			dao.insert(recipe);


			recipeList = dao.selectAll();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}


		request.setAttribute("recipeList", recipeList);

		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("recipe-all-list-servlet");
		rd.forward(request, response);
	}
}




//package servlet;
//
//import java.io.IOException;
//import java.sql.Blob;
//import java.sql.Date;
//import java.sql.SQLException;
//import java.time.LocalDate;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.sql.rowset.serial.SerialBlob;
//
//import model.dao.RecipeDAO;
//import model.entity.RecipeBean;
//
//
//
///**
// * Servlet implementation class RecipeAllRegisterServlet
// */
//@WebServlet("/recipe-all-register-servlet")
//public class RecipeAllRegisterServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public RecipeAllRegisterServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	   	// リクエストオブジェクトのエンコーディング方式の指定
//    	request.setCharacterEncoding("UTF-8");
//
//		RecipeBean recipeBean = new RecipeBean();
//		recipeBean.setRecipeId(Integer.parseInt(request.getParameter("recipeid")));
//		recipeBean.setRecipeName(request.getParameter("recipename"));
//		String recipeImgStr = request.getParameter("recipename");
//		
//		if(recipeImgStr != null && !recipeImgStr.isEmpty()) {
//			try {
//				byte[] bytes = recipeImgStr.getBytes("UTF-8");
//				Blob blobImg = new SerialBlob(bytes);
//				
//				recipeBean.setRecipeImg(blobImg);
//			} catch (Exception e) {
//				System.out.println("画像のBlob変換でエラーが発生しました。");
//				e.printStackTrace();
//			}
//		}
////		recipeBean.setRecipeImg(request.getParameter("recipename"));
//		recipeBean.setRecipeIngredients(request.getParameter("recipename"));
//		recipeBean.setRecipeHowto(request.getParameter("recipename"));
//		recipeBean.setRecipeServings(Integer.parseInt(request.getParameter("recipename")));
//		String postingDateStr = request.getParameter("postingdate");
//		if (postingDateStr != null && !postingDateStr.isEmpty() ) {
//			
//			LocalDate localDate = LocalDate.parse(postingDateStr);
//			
//			Date finalDate = java.sql.Date.valueOf(localDate);
//			recipeBean.setPostingDatetime(finalDate);
//		}
//		
//		String updateDateStr = request.getParameter("updatedate");
//		if (postingDateStr != null && !postingDateStr.isEmpty() ) {
//			
//			LocalDate localDate = LocalDate.parse(updateDateStr);
//			
//			Date finalDate = java.sql.Date.valueOf(localDate);
//			recipeBean.setUpdateDatetime(finalDate);
//		}
////		recipeBean.setPostingDatetime(request.getParameter("recipename"));
////		recipeBean.setUpdateDatetim(request.getParameter("recipename"));
//
//    	// DAOの生成
//        RecipeDAO dao = new RecipeDAO();
//        try {
//        	// DAOの利用
//			dao.insert(recipeBean);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//
//        // リクエストの転送
//        RequestDispatcher rd = request.getRequestDispatcher("multi-all-recipe.jsp");
//        rd.forward(request, response);
//	}
//
//	}
//
//
//
