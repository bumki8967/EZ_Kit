package com.project.ezkit.admin;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

	Admin selectAdminById(String admin_id);
}
