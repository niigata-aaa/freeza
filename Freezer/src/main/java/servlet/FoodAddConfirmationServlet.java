package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FoodAddConfirmationServlet
 */
@WebServlet("/food-add-confirmation-servlet")
public class FoodAddConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodAddConfirmationServlet() {
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
        
        //パラメータ取得
        String foodName = request.getParameter("foodName");
        String number = request.getParameter("number");
        String unit = request.getParameter("単位");
        String dateStr = request.getParameter("data");  
        
        // 画像（Blob:InputStream）の取得
        Part filePart = request.getPart("foodPhoto"); 
        InputStream foodImageStream = null;
        if (filePart != null && filePart.getSize() > 0) {
            foodImageStream = filePart.getInputStream(); 
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
        
        // 3. セッションの取得とデータの保存
        HttpSession session = request.getSession();
        session.setAttribute("foodName", foodName);
        session.setAttribute("number", number);
        session.setAttribute("unit", unit);
        session.setAttribute("date", dateStr);          
        session.setAttribute("foodLostDay", foodLostDay); 
        session.setAttribute("foodImageStream", foodImageStream); 
        
        request.getRequestDispatcher("foodaddconfirm.jsp").forward(request, response);
    }
}