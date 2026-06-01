package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FoodAddConfirmServlet
 */
@WebServlet("/food-add-confirm-servlet")
@MultipartConfig
public class FoodAddConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodAddConfirmServlet() {
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
	    
	    //パラメータの取得
	    String foodName = request.getParameter("foodName");
	    String number = request.getParameter("number");
	    String unit = request.getParameter("単位");
	    String dateStr = request.getParameter("data");  
	    
	    //画像ファイルの取得と保存処理
	    Part filePart = request.getPart("foodPhoto");
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
	    
	    //java.sql.Date型作成
	    java.sql.Date foodLostDay = null;
	    try {
	        if (dateStr != null && !dateStr.isEmpty()) {
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            foodLostDay = new java.sql.Date(sdf.parse(dateStr).getTime());
	        }
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    
	    //セッションの取得
	    HttpSession session = request.getSession();
	    session.setAttribute("foodName", foodName);
	    session.setAttribute("number", number);
	    session.setAttribute("unit", unit);
	    session.setAttribute("date", dateStr);          
	    session.setAttribute("foodLostDay", foodLostDay); 
	    
	    session.setAttribute("foodImage", fileName); 
	    
	    request.getRequestDispatcher("food-add-confirm.jsp").forward(request, response);
	}
}