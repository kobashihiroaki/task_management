package task_management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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
		// 送信されたJSONの取得
		BufferedReader buffer = new BufferedReader(request.getReader());
		String reqJson = buffer.readLine();

		// JSONをオブジェクトに変更
//		JSONObject obj = new JSONObject(reqJson);
//
//        Map<String, String> map = new HashMap<>();
//        for(Object key : obj.keySet()) {
//            map.put((String) key, obj.get((String) key));
//        }
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> reqMap =
			mapper.readValue(reqJson, new TypeReference<Map<String, String>>() {});

        String login_id = reqMap.get("login_id");
		String login_password = reqMap.get("login_password");
		//IDとパスワードが合っていればメイン画面に遷移
		response.setContentType("application/json; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		UserDAO udao = new UserDAO();
        PrintWriter out = response.getWriter();
        out.print(udao.existsUser(login_id, login_password));
        out.flush();

//		String login_id = request.getParameter("login-id");
//		String login_password = request.getParameter("login-password");
//		//IDとパスワードが合っていればメイン画面に遷移
//		UserDAO udao = new UserDAO();
//		UserDTO udto = udao.selectUser(login_id, login_password);
//		if (udto.getLogin_id() != null) {
//			//セッション情報作成
//			HttpSession session = request.getSession();
//			//セッションオブジェクトに保存
//			session.setAttribute("user_data", udto);
//			response.sendRedirect("main");
//		//間違っていればログイン画面に遷移
//		} else {
//			response.sendRedirect("login");
//		}
	}
}
