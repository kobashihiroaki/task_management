package task_management;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskDAO {

	public boolean insertTask(int user_id, String title, String content) {
		boolean success;
		String sql = "INSERT INTO tasks (user_id, title, content) values ('" + user_id + "', '" + title + "', '" + content + "')";
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

	}

}
