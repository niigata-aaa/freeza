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

import model.dao.AdminDAO;
import model.dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        
        HttpSession session = request.getSession();
        String nextPage = "login.jsp";
        boolean isLoginSuccess = false;
        
        try {
            // 普通の利用者(m_user)としてログインできるかチェック
            UserDAO userDao = new UserDAO();
            if (userDao.loginCheck(id, password)) {
                isLoginSuccess = true;
                session.setAttribute("userId", id);
                nextPage = "home-servlet"; // 利用者用トップへ
            } 
            // 管理者(m_admin)としてチェック
            else {
                AdminDAO adminDao = new AdminDAO();
                if (adminDao.loginCheck(id, password)) {
                    isLoginSuccess = true;
                    session.setAttribute("adminId", id);
                    nextPage = "recipe-list.jsp"; // 管理者用トップへ
                }
            }
            
            // 🚀 判定結果に基づいた画面転送
            if (isLoginSuccess) {
                RequestDispatcher rd = request.getRequestDispatcher(nextPage);
                rd.forward(request, response);
            } else {
                // どちらのテーブルにも存在しなかった場合
                request.setAttribute("errorMsg", "IDまたはパスワードが間違っています。");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", "サーバーエラーが発生しました。");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
}