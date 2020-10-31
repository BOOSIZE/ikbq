package com.example.ikbq.service.impl;

import com.example.ikbq.dao.UserDao;
import com.example.ikbq.entity.Userinfo;
import com.example.ikbq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
	@Autowired(required = false)
	private UserDao userDao;

	@Override
	public String log(String account,String pass)
	{
		String str="nobody";
		Userinfo userinfo =userDao.getUser(account);
		if(userinfo!=null)
		{
			str="no";
			if(userinfo.getPassword().equals(pass))
			{
				str="yes";
			}
		}
		return str;
	}

	@Override
	public String checkAccount(String account)
	{
		String str="no";

		Userinfo userinfo=userDao.getUser(account);

		if(userinfo==null)
		{
			str="yes";
		}

		return str;
	}

	@Override
	public String addUser(Userinfo userinfo)
	{
		String str="no";

		int n=userDao.addUser(userinfo);
		if(n>0)
		{
			str="yes";
		}

		return str;
	}
}