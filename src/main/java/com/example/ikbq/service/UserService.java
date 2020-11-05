package com.example.ikbq.service;

import com.example.ikbq.entity.Deptinfo;
import com.example.ikbq.entity.Userinfo;
import org.springframework.boot.web.servlet.server.Session;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService
{
	String log(String account, String pass, HttpSession session);

	String checkAccount(String account);

	String addUser(Userinfo userinfo);

	String addAdmin(Userinfo userinfo);

	String getList(Integer limit,Integer page,String name,String sex,String stu);

	String getAdminList(Integer limit,Integer page,String name,String sex,String did);

	String deleteUser(String account);

	String updateName(String name,String account);

	String updatePass(String pass,HttpSession session);

	List<Deptinfo> getDept();

	Userinfo getMsg(HttpSession session);
}