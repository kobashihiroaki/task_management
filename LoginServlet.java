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
		String id = request.getParameter("login-id");
		String password = request.getParameter("login-password");
		//IDとパスワードが合っていればメイン画面に遷移
		if (id.equals("kobashi") && password.equals("hogehoge")) {
			//セッション情報作成
			HttpSession session = request.getSession(true);
			//セッションオブジェクトに保存
			session.setAttribute("loginId", "kobashi");
			response.sendRedirect("main.jsp");
		//間違っていればログイン画面に遷移
		} else {
			response.sendRedirect("login");
		}
	}

}
