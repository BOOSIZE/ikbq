package com.example.ikbq.dao;

import com.example.ikbq.entity.Deptinfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface DeptDao
{
	@Select("SELECT * FROM DEPTINFO")
	List<Deptinfo> getList();


	@Select("SELECT D.NAME ,COUNT(U.ACCOUNT) SUM FROM DEPTINFO D LEFT JOIN USERINFO U" +
			" ON D.DID=U.DID AND U.ROLE!='1' GROUP BY D.NAME LIMIT #{limit} OFFSET #{start}")
	List<Deptinfo> getDeptList(Integer limit,Integer start);

	@Select("SELECT COUNT(*) FROM DEPTINFO")
	int getSum();

	@Delete("DELETE FROM DEPTINFO WHERE NAME=#{name}")
	int deleteDept(String name);

	@Select("SELECT COUNT(*) FROM DEPTINFO WHERE NAME=#{name}")
	int check(String name);

	@Insert("INSERT INTO DEPTINFO (NAME) VALUE (#{name})")
	int addDept(String name);
}