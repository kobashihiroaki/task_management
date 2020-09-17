package task_management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

	public List<TaskDTO> selectTask (int user_id) {
		String sql = "SELECT id, title, content from tasks where user_id = " + user_id;
		List<TaskDTO> tasks = new ArrayList<TaskDTO>();

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;

		try {
			con = ConnectionManager.getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(sql);
			while (rs.next()) {
				TaskDTO tdto = new TaskDTO();
				tdto.setId(rs.getInt("id"));
				tdto.setTitle(rs.getString("title"));
				tdto.setContent(rs.getString("content"));
				tasks.add(tdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception ignore) {
				}
			}
			if (smt != null) {
				try {
					smt.close();
				} catch (Exception ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception ignore) {
				}
			}
		}
		return tasks;
	}

	public boolean insertTask(int user_id, String title, String content) {
		boolean success;
		String sql = "INSERT INTO tasks (user_id, title, content) VALUES ('" + user_id + "', '" + title + "', '" + content + "')";
		Connection con = null;
		Statement smt = null;
		try {
			con = ConnectionManager.getConnection();
			smt = con.createStatement();
			smt.executeUpdate(sql);
			success = true;
			return success;
		} catch (SQLException e) {
			e.printStackTrace();
			success = false;
			return success;
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (Exception ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception ignore) {
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		TaskDAO tdao = new TaskDAO();
//		int user_id = 1;
//		String title = "aaa";
//		String content = "bbb";
//		System.out.println(tdao.insertTask(user_id, title, content));

		int user_id = 2;
		List<TaskDTO> tasks = tdao.selectTask(user_id);
		System.out.println(tasks);
	}

}
