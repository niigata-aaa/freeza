package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String url = null;

		request.setCharacterEncoding("UTF-8");

		String UserId = request.getParameter("name");
		String PassWord = request.getParameter("password");

		try {
			UserDAO userDao = new UserDAO();

			// ログイン認証
			if(userDao.loginCheck(UserId, PassWord)) {

				// ログイン成功時：ホーム画面へ
				url = "home-servlet"; 

				HttpSession session = request.getSession();
				
				// セッションにログインしたユーザーIDを保存
				session.setAttribute("UserId", UserId);

			} else {
				url = "login.jsp";
			}

		} catch(Exception e) {
			e.printStackTrace();
			url = "login.jsp"; 
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}