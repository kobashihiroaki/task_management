package task_management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
	public UserDTO selectUser (String login_id, String login_password) {
		String sql = "SELECT id, login_id from users where login_id = '" + login_id + "' and login_password = '" + login_password + "'";
		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;
		UserDTO udto = new UserDTO();
		try {
			con = ConnectionManager.getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(sql);
			while (rs.next()) {
				udto.setId(rs.getInt("id"));
				udto.setLogin_id(rs.getString("login_id"));
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
		return udto;
	}

//	public String existsUser(String login_id, String login_password) {
//		String sql = "SELECT id, login_id from users where login_id = '" + login_id + "' and login_password = '" + login_password + "'";
//		Connection con = null;
//		Statement smt = null;
//		ResultSet rs = null;
//		UserDTO udto = new UserDTO();
//		try {
//			con = ConnectionManager.getConnection();
//			smt = con.createStatement();
//			rs = smt.executeQuery(sql);
//			while (rs.next()) {
//				udto.setId(rs.getInt("id"));
//				udto.setLogin_id(rs.getString("login_id"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (Exception ignore) {
//				}
//			}
//			if (smt != null) {
//				try {
//					smt.close();
//				} catch (Exception ignore) {
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception ignore) {
//				}
//			}
//		}
//
//		String success;
//
//		//ログイン成功
//		if (udto.getLogin_id() != null) {
//			success = 0;
//
//		//ログイン失敗
//		} else {
//			success = "1";
//		}
//
//		return ;
//	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
//		UserDAO udao = new UserDAO();
//		String login_id = "kobashi";
//		String login_password = "hogehoge";
//		UserDTO udto = udao.selectUser(login_id, login_password);
//		System.out.println(udto.getLogin_id());
//		JSONObject json = new JSONObject();
//		json.put("login_id", "kobashi");
//		json.put("login_password", "hogehoge");
//		System.out.println(json);
	}

}
