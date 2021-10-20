package com.project.ezkit.user;

import java.sql.Date;

public class User {

	private int user_num;
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_nick;
	private String user_tel;
	private String user_postcode;
	private String user_addr1;
	private String user_addr2;
	private Date user_regdate;
	private int user_point;
	private String user_type;
	private String user_rating;

	public User() {
	}

	public User(int user_num, String user_id, String user_pw, String user_name, String user_nick, String user_tel,
			String user_postcode, String user_addr1, String user_addr2, Date user_regdate, int user_point,
			String user_type, String user_rating) {
		super();
		this.user_num = user_num;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_nick = user_nick;
		this.user_tel = user_tel;
		this.user_postcode = user_postcode;
		this.user_addr1 = user_addr1;
		this.user_addr2 = user_addr2;
		this.user_regdate = user_regdate;
		this.user_point = user_point;
		this.user_type = user_type;
		this.user_rating = user_rating;
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_nick() {
		return user_nick;
	}

	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}

	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	public String getUser_postcode() {
		return user_postcode;
	}

	public void setUser_postcode(String user_postcode) {
		this.user_postcode = user_postcode;
	}

	public String getUser_addr1() {
		return user_addr1;
	}

	public void setUser_addr1(String user_addr1) {
		this.user_addr1 = user_addr1;
	}

	public String getUser_addr2() {
		return user_addr2;
	}

	public void setUser_addr2(String user_addr2) {
		this.user_addr2 = user_addr2;
	}

	public Date getUser_regdate() {
		return user_regdate;
	}

	public void setUser_regdate(Date user_regdate) {
		this.user_regdate = user_regdate;
	}

	public int getUser_point() {
		return user_point;
	}

	public void setUser_point(int user_point) {
		this.user_point = user_point;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getUser_rating() {
		return user_rating;
	}

	public void setUser_rating(String user_rating) {
		this.user_rating = user_rating;
	}

	@Override
	public String toString() {
		return "User [user_num=" + user_num + ", user_id=" + user_id + ", user_pw=" + user_pw + ", user_name="
				+ user_name + ", user_nick=" + user_nick + ", user_tel=" + user_tel + ", user_postcode=" + user_postcode
				+ ", user_addr1=" + user_addr1 + ", user_addr2=" + user_addr2 + ", user_regdate=" + user_regdate
				+ ", user_point=" + user_point + ", user_type=" + user_type + ", user_rating=" + user_rating + "]";
	}

}