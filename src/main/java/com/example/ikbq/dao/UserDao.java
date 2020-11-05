package com.example.ikbq.dao;

import com.example.ikbq.entity.Userinfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao
{
	@Select("SELECT * FROM USERINFO WHERE ACCOUNT=#{account}")
	Userinfo getUser(String account);

	@Insert("INSERT INTO USERINFO (ACCOUNT,PASSWORD,NAME,SEX,STU,DATE,ROLE) VALUES " +
			"(#{account},#{password},#{name},#{sex},#{stu},#{date},'1')")
	int addUser(Userinfo userinfo);

	@Insert("INSERT INTO USERINFO (ACCOUNT,PASSWORD,NAME,SEX,ROLE,DID) VALUES" +
			"(#{account},#{password},#{name},#{sex},#{role},#{did})")
		int addAdmin(Userinfo userinfo);

//	@Select("<script> SELECT * FROM USERINFO WHERE 1=1 " +
//			"<when test='name!=null'> AND NAME LIKE CONCAT('%',#{name},'%')</when>" +
//			"<when test='sex!=null' > AND SEX=#{sex}</when>" +
//			"<when test='stu!=null'> AND STU=#{stu}</when>" +
//			"LIMIT #{limit} OFFSET #{start} </script>")
	List<Userinfo> getList(Integer limit,Integer start,String name,String sex,String stu);

	@Select("<script> SELECT COUNT(*) FROM USERINFO WHERE ROLE='1' " +
			"<when test='name!=null'> AND NAME LIKE CONCAT('%',#{name},'%')</when>" +
			"<when test='sex!=null' > AND SEX=#{sex}</when> " +
			"<when test='stu!=null'> AND STU=#{stu}</when></script>")
	int getSum(String name,String sex,String stu);

	@Select("<script> SELECT U.*,D.NAME dname FROM USERINFO U,DEPTINFO D WHERE U.ROLE!='1' AND U.DID=D.DID" +
			"<when test='name!=null'> AND U.NAME LIKE CONCAT('%',#{name},'%')</when>" +
			"<when test='sex!=null' > AND U.SEX=#{sex}</when>" +
			"<when test='did!=null' > AND U.DID=#{did}</when>" +
			"LIMIT #{limit} OFFSET #{start} </script>")
	List<Userinfo> getAdminList(Integer limit,Integer start,String name,String sex,String did);

	@Select("<script> SELECT COUNT(*) FROM USERINFO WHERE ROLE!='1'" +
			"<when test='name!=null'> AND NAME LIKE CONCAT('%',#{name},'%')</when>" +
			"<when test='sex!=null' > AND SEX=#{sex}</when> " +
			"<when test='did!=null' > AND DID=#{did}</when> </script>")
	int getAdminSum(String name,String sex,String did);


	@Delete("DELETE FROM USERINFO WHERE ACCOUNT=#{account}")
	int deleteUser(String account);

	@Update("UPDATE USERINFO SET NAME =#{name} WHERE ACCOUNT=#{account}")
	int updateName(String name,String account);

	@Update("UPDATE USERINFO SET PASSWORD =#{pass} WHERE ACCOUNT=#{account}")
	int updatePass(String pass,String account);


	@Select("SELECT D.NAME dname, CASE WHEN(U.SEX='1') THEN '男' WHEN(U.SEX='0') THEN '女' END AS sex," +
			"CASE WHEN(U.ROLE='2') THEN '经理' WHEN(U.ROLE='3') THEN '员工' END AS role " +
			"FROM USERINFO U,DEPTINFO D WHERE D.DID=U.DID AND U.ACCOUNT=#{account}")
	Userinfo getMsg(String account);

}