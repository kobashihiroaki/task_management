package task_management;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet(name = "main", urlPatterns = "/main")
public class MainServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		//セッションオブジェクトの獲得確認
	    if (session == null || session.getAttribute("loginId") == null) {
	      //セッションが取得できなければログイン画面に遷移
	    	response.sendRedirect("login");
	    } else {
	      //セッションが取得できた場合はカウンタを取り出す
//	      String loginId = (String) session.getAttribute("loginId");
	      response.sendRedirect("main.jsp");
	    }
	}

}
