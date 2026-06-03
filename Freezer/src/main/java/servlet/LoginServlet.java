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

import model.dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// login.jsp のフォームから入力された値を取得
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 遷移先URLの初期化
		String url = null;
		
		HttpSession session = request.getSession();
		UserDAO dao = new UserDAO();

		try {
			// 入力されたIDとパスワードが正しいかチェック
			if (dao.loginCheck(id, password)) {
				
				// 認証成功：セッションに user_id を保存
				session.setAttribute("user_id", id);
				
				//ログインした人が会員か管理者か判定
				if (dao.admin_flg_Check(id)) {
					// アドミンフラグ成功はRecipeListServletへ
					url = "recipe-list-servlet";
				} else {
					// アドミンフラグ失敗はHomeNormalServletへ
					url = "home-servlet";
				}
				
			} else {
				// 認証失敗：ログイン画面に戻してエラーメッセージを表示
				request.setAttribute("errorMsg", "IDまたはパスワードが間違っています。");
				url = "login.jsp";
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", "サーバーエラーが発生しました。");
			url = "login.jsp";
		}

		// 決定したURLへフォワード
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}