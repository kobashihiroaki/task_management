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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UserDTO userSession = (UserDTO) session.getAttribute("user_data");
		//セッションオブジェクトの獲得確認
	    if (userSession != null) {
	    	//セッションが取得できたらメイン画面に遷移
	    	response.sendRedirect("main.jsp");
	    } else {
	      //セッションが取得できなければログイン画面に遷移
//	      String login_id = userSession.getLogin_id();
	      response.sendRedirect("login");
	    }
	}

}
