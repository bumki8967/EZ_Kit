package com.project.ezkit.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@Autowired
	private AdminMapper mapper;
	
	public Admin selectAdminById(String admin_id) {
		return mapper.selectAdminById(admin_id);
	}
}
