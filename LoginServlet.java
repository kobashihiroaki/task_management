package task_management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		response.sendRedirect("login.jsp");
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//送信されたJSONの取得
		BufferedReader buffer = new BufferedReader(request.getReader());
		String reqJson = buffer.readLine();

		// JSONをオブジェクトに変更
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> reqMap = mapper.readValue(reqJson, new TypeReference<Map<String, String>>() {});
		Map<String, Object> resMap = new HashMap<>();

//		resMap.put("login_id", "kobashi");
//		resMap.put("login_password", "hogehoge");
		resMap.put("login_id", reqMap.get("login_id"));
		resMap.put("login_password", reqMap.get("login_password"));

		// オブジェクトをJson文字列に変更
		String json = mapper.writeValueAsString(resMap);
		response.setContentType("application/json; charset=utf-8");
		request.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        out.print(json);
//        out.flush();
	}
}
