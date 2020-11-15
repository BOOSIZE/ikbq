package com.example.ikbq.dao;

import com.example.ikbq.entity.Menuinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuDao
{
	@Select("SELECT F.NAME FNAME,S.* FROM MENUINFO F,MENUINFO S WHERE F.NUM=S.FNUM")
	List<Menuinfo> getMenus();
}