package com.project.ezkit.user;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

   void insertUser(User u);
   
   User selectUserById(String user_id);
   
   User selectUserByNick(String user_nick);
   
   void updateUser(User u);
   
   void updateUserRating(Map map);
   
   void updateUserPoint(User u);
   
   void deleteUser(String user_id);
   
   User userPasswordByEmail(Map map);
}