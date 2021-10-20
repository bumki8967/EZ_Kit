package com.project.ezkit.admin;

public class Admin {
	private String admin_id;
	private String admin_pw;
	private String admin_nick;
	private String user_type;

	public Admin() {
	}

	public Admin(String admin_id, String admin_pw, String admin_nick, String user_type) {
		super();
		this.admin_id = admin_id;
		this.admin_pw = admin_pw;
		this.admin_nick = admin_nick;
		this.user_type = user_type;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_pw() {
		return admin_pw;
	}

	public void setAdmin_pw(String admin_pw) {
		this.admin_pw = admin_pw;
	}

	public String getAdmin_nick() {
		return admin_nick;
	}

	public void setAdmin_nick(String admin_nick) {
		this.admin_nick = admin_nick;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_pw=" + admin_pw + ", admin_nick=" + admin_nick + ", user_type="
				+ user_type + "]";
	}

}
