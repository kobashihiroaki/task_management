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
 * Servlet implementation class SignUpServlet
 */
@WebServlet(name = "sign_up", urlPatterns = "/sign_up")
public class SignUpServlet extends HttpServlet {
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
		//送信されたJSONの取得
		BufferedReader buffer = new BufferedReader(request.getReader());
		String reqJson = buffer.readLine();

		// JSONをオブジェクトに変更
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> reqMap = mapper.readValue(reqJson, new TypeReference<Map<String, String>>() {});

		String login_id = reqMap.get("login_id");
		String login_password = reqMap.get("login_password");
		UserDAO udao = new UserDAO();
		Map<String, Integer> resMap = new HashMap<>();

		//会員登録に成功した場合
		if (udao.insertUser(login_id, login_password) == true) {
			resMap.put("success", 0);
		//会員登録に失敗した場合
		} else {
			resMap.put("success",  1);
		}

		// オブジェクトをJson文字列に変更
		String json = mapper.writeValueAsString(resMap);

		response.setContentType("application/json; charset=utf-8");
		request.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        out.print(json);
	}

}
