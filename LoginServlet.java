package task_management;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login_id = request.getParameter("login-id");
		String login_password = request.getParameter("login-password");
		//IDとパスワードが合っていればメイン画面に遷移
		UserDAO udao = new UserDAO();
		UserDTO udto = udao.selectUser(login_id, login_password);
		if (udto.getLogin_id() != null) {
			//セッション情報作成
			HttpSession session = request.getSession();
			//セッションオブジェクトに保存
			session.setAttribute("user_data", udto);
			response.sendRedirect("main");
		//間違っていればログイン画面に遷移
		} else {
			response.sendRedirect("login");
		}
	}

}
