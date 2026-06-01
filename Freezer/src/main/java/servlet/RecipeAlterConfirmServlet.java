package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.RecipeBean;

/**
 * Servlet implementation class RecipeAlterConfirmServlet
 */
@WebServlet("/recipe-alter-confirm-servlet")
public class RecipeAlterConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeAlterConfirmServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		RecipeBean employee = new RecipeBean();
		employee.setRecipeId(Integer.parseInt(request.getParameter("id")));
		employee.setRecipeName(request.getParameter("name"));
		employee.setRecipeIngredients(request.getParameter("ingredients"));
		employee.setRecipeHowto(request.getParameter("howto"));
		employee.setRecipeServings(Integer.parseInt(request.getParameter("servings")));
		/*Part filePart = request.getPart("foodPhoto");
		    String fileName = "";
		    
		    if (filePart != null && filePart.getSize() > 0) {
		        // ユーザーが選んだ実際のファイル名（例: "apple.png"）を取得
		        java.nio.file.Path path = java.nio.file.Paths.get(filePart.getSubmittedFileName());
		        fileName = path.getFileName().toString();
		       
		        //webapp直下の実際のパスを調べて画像を保存
		        String uploadPath = getServletContext().getRealPath("/");
		        filePart.write(uploadPath + java.io.File.separator + fileName);
		    }
		    
		    if (fileName == null || fileName.isEmpty()) {
		        fileName = "default.png";
		    }
		    
		    HttpSession session = request.getSession();
		    session.setAttribute("foodImage", fileName); */
		request.setAttribute("employee", employee);

		request.getRequestDispatcher("recipealterconfirm.jsp")
		       .forward(request, response);
	}

}
