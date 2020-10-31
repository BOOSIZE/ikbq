package com.example.ikbq.service;

import com.example.ikbq.entity.Userinfo;

public interface UserService
{
	String log(String account,String pass);

	String checkAccount(String account);

	String addUser(Userinfo userinfo);
}