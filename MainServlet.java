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
 * Servlet implementation class MainServlet
 */
@WebServlet(name = "main", urlPatterns = "/main")
public class MainServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doPost(request, response);
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
			Map<String, Map<String, Object>> reqMap = mapper.readValue(reqJson, new TypeReference<Map<String, Map<String, Object>>>() {});
//			Map<String, Object> obj = reqMap.get("obj");
//			int user_id = (int)obj.get("login_id");
//			String title = (String)obj.get("title");
//			String content = (String)obj.get("content");
//
//			TaskDAO tdao = new TaskDAO();
//			Map<String, Integer> resMap = new HashMap<>();

			//タスク登録に成功した場合
//			if (tdao.insertTask(user_id, title, content) == true) {
//				resMap.put("success", 0);
			//タスク登録に失敗した場合
//			} else {
//				resMap.put("success",  1);
//			}

			// オブジェクトをJson文字列に変更
			String json = mapper.writeValueAsString(reqMap);

			response.setContentType("application/json; charset=utf-8");
			request.setCharacterEncoding("utf-8");

	        PrintWriter out = response.getWriter();
	        out.print(json);
	}
}
