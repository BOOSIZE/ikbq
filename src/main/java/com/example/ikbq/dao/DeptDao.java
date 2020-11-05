package com.example.ikbq.dao;

import com.example.ikbq.entity.Deptinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptDao
{
	@Select("SELECT * FROM DEPTINFO")
	List<Deptinfo> getList();
}