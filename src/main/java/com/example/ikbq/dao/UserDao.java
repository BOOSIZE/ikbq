package com.example.ikbq.dao;

import com.example.ikbq.entity.Userinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao
{
	@Select("SELECT * FROM USERINFO WHERE ACCOUNT=#{account}")
	Userinfo getUser(String account);

	@Insert("INSERT INTO USERINFO (ACCOUNT,PASSWORD,NAME,SEX,STU,DATE) VALUES " +
			"(#{account},#{password},#{name},#{sex},#{stu},#{date})")
	int addUser(Userinfo userinfo);
}