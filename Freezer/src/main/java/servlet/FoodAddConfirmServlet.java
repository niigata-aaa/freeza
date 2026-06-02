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
	    
	    String foodName = request.getParameter("foodName");
	    String number = request.getParameter("number");
	    String unit = request.getParameter("単位");
	    String dateStr = request.getParameter("data");  
	    
	    // 【修正】画像をバイト配列として読み込む
	    Part filePart = request.getPart("foodPhoto");
	    byte[] imgData = null;
	    String base64Str = ""; // 確認画面で表示するためのBase64文字列
	    
	    if (filePart != null && filePart.getSize() > 0) {
	        imgData = filePart.getInputStream().readAllBytes();
	        // 確認画面で画像を表示するためにBase64に変換
	        base64Str = java.util.Base64.getEncoder().encodeToString(imgData);
	    }
	    
	    // java.sql.Date型作成
	    java.sql.Date foodLostDay = null;
	    try {
	        if (dateStr != null && !dateStr.isEmpty()) {
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            foodLostDay = new java.sql.Date(sdf.parse(dateStr).getTime());
	        }
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    
	    // セッションの取得
	    HttpSession session = request.getSession();
	    session.setAttribute("foodName", foodName);
	    session.setAttribute("number", number);
	    session.setAttribute("unit", unit);
	    session.setAttribute("date", dateStr);          
	    session.setAttribute("foodLostDay", foodLostDay); 
	    
	    // 【修正】ファイル名ではなく、画像データそのものとBase64文字列をセッションに保存
	    session.setAttribute("foodImageBytes", imgData); 
	    session.setAttribute("foodImageBase64", base64Str); 
	    
	    request.getRequestDispatcher("food-add-confirm.jsp").forward(request, response);
	}
}