package com.example.ikbq.controller;

import com.example.ikbq.entity.Userinfo;
import com.example.ikbq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/")
public class UserController
{
	@Autowired
	private UserService userServiceImpl;

	@RequestMapping("log")
	@ResponseBody
	public String log(String account, String pass, HttpSession session)
	{
		return userServiceImpl.log(account,pass,session);
	}

	@RequestMapping("getList")
	@ResponseBody
	public String getList(Integer limit,Integer page,String name,String sex,String stu)
	{
		return userServiceImpl.getList(limit, page,name,sex,stu);
	}

	@RequestMapping("deleteUser")
	@ResponseBody
	public String deleteUser(String account)
	{
		return userServiceImpl.deleteUser(account);
	}

	@RequestMapping("updateName")
	@ResponseBody
	public String updateName(String name,String account)
	{
		return userServiceImpl.updateName(name, account);
	}

	@RequestMapping("checkAccount")
	@ResponseBody
	public String checkAccount(String account)
	{
		return userServiceImpl.checkAccount(account);
	}

	@RequestMapping("addUser")
	@ResponseBody
	public String addUser(Userinfo userinfo)
	{
		return userServiceImpl.addUser(userinfo);
	}
}