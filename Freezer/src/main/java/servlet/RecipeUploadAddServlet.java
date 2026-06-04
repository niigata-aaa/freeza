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
public class RecipeUploadAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecipeUploadAddServlet() {
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
		String RecipeName = (String) session.getAttribute("recipeName");
		byte[] imgData = (byte[]) session.getAttribute("recipeImage"); 
		String RecipeIngredients = (String) session.getAttribute("recipeIngredients");
		String RecipeHowto = (String) session.getAttribute("recipeHowto");
		String RecipeServingsstr = (String) session.getAttribute("recipeServings");
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
		recipe.setRecipeImg(imgData); // byte[]を保持するフィールド
		
		recipe.setRecipeIngredients(RecipeIngredients);
		recipe.setRecipeHowto(RecipeHowto);
		recipe.setRecipeServings(RecipeServings);
		


//            // 現在のシステム日付（java.sql.Date）を生成してセット
            long now = System.currentTimeMillis();
            recipe.setPostingDatetime(new java.sql.Date(now));
            System.out.println(recipe.getPostingDatetime());
            
//            long now1 = System.currentTimeMillis();
            recipe.setUpdateDatetime(new java.sql.Date(now));
            System.out.println(recipe.getUpdateDatetime());
       
		

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
		RequestDispatcher rd = request.getRequestDispatcher("recipe-upload-add.jsp");
		rd.forward(request, response);
	}
}



