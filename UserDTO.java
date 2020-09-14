package task_management;

public class UserDTO {
	private int id;
	private String login_id;
	private String login_password;

	public String toString() {
		return super.toString()
				+ ",id=" + id
				+ ",login_id=" + login_id
				+ "login_password" + login_password
				;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getLogin_password() {
		return login_password;
	}

	public void setLogin_password(String login_password) {
		this.login_password = login_password;
	}
}
