package com.example.ikbq.dao;

import com.example.ikbq.entity.Menuinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuDao
{
	@Select("SELECT * FROM MENUINFO WHERE FNUM=0")
	List<Menuinfo> getFathers();

	@Select("SELECT * FROM MENUINFO WHERE FNUM=#{num}")
	List<Menuinfo> getSons(String num);
}