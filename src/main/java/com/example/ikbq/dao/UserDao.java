package com.example.ikbq.dao;

import com.example.ikbq.entity.Userinfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao
{
	@Select("SELECT * FROM USERINFO WHERE ACCOUNT=#{account}")
	Userinfo getUser(String account);

	@Insert("INSERT INTO USERINFO (ACCOUNT,PASSWORD,NAME,SEX,STU,DATE) VALUES " +
			"(#{account},#{password},#{name},#{sex},#{stu},#{date})")
	int addUser(Userinfo userinfo);

	List<Userinfo> getList(Integer limit,Integer start,String name,String sex,String stu);

	@Select("<script> SELECT COUNT(*) FROM USERINFO WHERE 1=1 " +
			"<when test='name!=null'> AND NAME LIKE CONCAT('%',#{name},'%')</when>" +
			"<when test='sex!=null' > AND SEX=#{sex}</when> " +
			"<when test='stu!=null'> AND STU=#{stu}</when></script>")
	int getSum(String name,String sex,String stu);


	@Delete("DELETE FROM USERINFO WHERE ACCOUNT=#{account}")
	int deleteUser(String account);

	@Update("UPDATE USERINFO SET NAME =#{name} WHERE ACCOUNT=#{account}")
	int updateName(String name,String account);
}