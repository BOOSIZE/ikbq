package com.example.ikbq.controller;

import com.example.ikbq.entity.Userinfo;
import com.example.ikbq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user/")
public class UserController
{
	@Autowired
	private UserService userServiceImpl;

	@RequestMapping("log")
	@ResponseBody
	public String log(String account,String pass)
	{
		return userServiceImpl.log(account,pass);
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