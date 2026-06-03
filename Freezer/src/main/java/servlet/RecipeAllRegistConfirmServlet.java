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

/**
 * Servlet implementation class RecipeAllRegistConfirmServlet
 */
@WebServlet("/recipe-all-regist-confirm-servlet")
@MultipartConfig 
public class RecipeAllRegistConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecipeAllRegistConfirmServlet() {
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
		
		request.setCharacterEncoding("UTF-8");

	
//		String recipeid = request.getParameter("recipeid");
		String recipename = request.getParameter("recipename");
		String recipeingredients = request.getParameter("recipeingredients");
		String recipehowto = request.getParameter("recipehowto");
		String recipeservings = request.getParameter("recipeservings");
		String posting = request.getParameter("posting");
//		String update = request.getParameter("update");
		
		Part filePart = request.getPart("recipePhoto"); 
		byte[] imgData = null;
		String base64Str = ""; 
		
		if (filePart != null && filePart.getSize() > 0) {
			imgData = filePart.getInputStream().readAllBytes();
			// 確認画面JSPで画像を表示するためにBase64に変換
			base64Str = java.util.Base64.getEncoder().encodeToString(imgData);
		}
		
	    HttpSession session = request.getSession();		
//		session.setAttribute("recipeid", recipeid);
	    session.setAttribute("recipename", recipename);
	    session.setAttribute("recipeingredients", recipeingredients);
	    session.setAttribute("recipehowto", recipehowto);
	    session.setAttribute("recipeservings", recipeservings);
	    session.setAttribute("posting", posting);
//		session.setAttribute("update", update);

	    session.setAttribute("recipeimg", imgData);        // 登録サーブレットが使う用
		session.setAttribute("recipeBase64", base64Str);  // 確認画面JSPが表示で使う用
		
	    request.getRequestDispatcher("recipe-all-register-confirm.jsp").forward(request, response);
    
//		RequestDispatcher rd = request.getRequestDispatcher("recipe-all-register-confirm.jsp");
//		rd.forward(request, response);
	}
}