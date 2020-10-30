package com.example.ikbq.dao;

import com.example.ikbq.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao
{
	@Select("SELECT * FROM USERINFO WHERE ACCOUNT=#{account}")
	Userinfo getUser(String account);
}