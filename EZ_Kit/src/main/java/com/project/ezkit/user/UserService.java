package com.project.ezkit.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserMapper mapper;

	public void insertUser(User u) {
		mapper.insertUser(u);
	}

	public User selectUserById(String user_id) {
		return mapper.selectUserById(user_id);
	}

	public User selectUserByNick(String user_nick) {
		return mapper.selectUserByNick(user_nick);
	}

	public void updateUser(User u) {
		mapper.updateUser(u);
	}

	public void updateUserRating(String user_id, String user_rating) {
		Map map = new HashMap();
		map.put("user_id", user_id);
		map.put("user_rating", user_rating);
		
		mapper.updateUserRating(map);
	}

	public void updateUserPoint(User u) {
		mapper.updateUserPoint(u);
	}

	public void deleteUser(String user_id) {
		mapper.deleteUser(user_id);
	}

	public User userPasswordByEmail(String user_id, String user_pw) {
		Map map = new HashMap();
		map.put("user_id", user_id);
		map.put("user_pw", user_pw);
		
		return mapper.userPasswordByEmail(map);
	}
}