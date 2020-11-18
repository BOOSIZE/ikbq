package com.example.ikbq.dao;

import com.example.ikbq.entity.Fileinfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FileDao
{
	@Select("SELECT COUNT(*) FROM FILEINFO")
	int getSum();

	@Select("SELECT * FROM FILEINFO LIMIT #{limit} OFFSET #{start}")
	List<Fileinfo> getList(Integer limit,Integer start);

	@Delete("DELETE FROM FILEINFO WHERE ID=#{id}")
	int deleteFile(Long id);

	@Insert("INSERT INTO FILEINFO (ACCOUNT,NAME,TITLE,MONEY,TYPE) VALUES " +
			"(#{account},#{name},#{title},#{money},#{type})")
	int addFile(Fileinfo fileinfo);

	@Select("SELECT NAME FROM FILEINFO WHERE ID=#{id}")
	String getName(Long id);
}