package com.example.ikbq.service.impl;

import com.example.ikbq.dao.DeptDao;
import com.example.ikbq.dao.MenuDao;
import com.example.ikbq.dao.UserDao;
import com.example.ikbq.entity.Deptinfo;
import com.example.ikbq.entity.Menuinfo;
import com.example.ikbq.entity.TableModel;
import com.example.ikbq.entity.Userinfo;
import com.example.ikbq.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
	@Autowired(required = false)
	private UserDao userDao;

	@Autowired(required = false)
	private MenuDao menuDao;

	@Autowired(required = false)
	private DeptDao deptDao;

	@Override
	public String log(String account, String pass, HttpSession session)
	{
		String str="nobody";
		Userinfo userinfo =userDao.getUser(account);
		if(userinfo!=null)
		{
			str="no";
			if(userinfo.getPassword().equals(pass))
			{
				str="user";
				session.setAttribute("user",userinfo);
				if(!(userinfo.getRole().equals("1")))
				{
					List<Menuinfo> fathers=menuDao.getFathers();
					HashMap<String, List<Menuinfo>> map=new HashMap<>();
					for(Menuinfo menu: fathers)
					{
						List<Menuinfo> list=menuDao.getSons(menu.getNum());
						map.put(menu.getName(),list);
					}
					session.setAttribute("menu",map);
					str="admin";
				}
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

	@Override
	public String addAdmin(Userinfo userinfo)
	{

		String str="no";

		int n=userDao.addAdmin(userinfo);
		if(n>0)
		{
			str="yes";
		}

		return str;
	}

	@Override
	public String deleteUser(String account)
	{
		String str="no";

		int n=userDao.deleteUser(account);
		if(n>0)
		{
			str="yes";
		}
		return str;
	}

	@Override
	public String updateName(String name, String account)
	{
		String str="no";

		int n=userDao.updateName(name,account);
		if(n>0)
		{
			str="yes";
		}
		return str;
	}

	@Override
	public String updatePass(String pass, HttpSession session)
	{
		String str="no";

		Userinfo userinfo=(Userinfo) session.getAttribute("user");

		int n=userDao.updatePass(pass,userinfo.getAccount());
		if(n>0)
		{
			str="yes";
		}
		return str;
	}

	@Override
	public String getList(Integer limit,Integer page,String name,String sex,String stu)
	{
		if(sex!=null && sex.equals("全部"))
		{
			sex=null;
		}

		if(stu!=null && stu.equals("全部"))
		{
			stu=null;
		}

		TableModel tableModel=new TableModel();
		tableModel.setCount(userDao.getSum(name,sex,stu));
		tableModel.setData(userDao.getList(limit,limit*(page-1),name,sex,stu));
		return new Gson().toJson(tableModel);
	}


	@Override
	public String getAdminList(Integer limit,Integer page,String name,String sex,String did)
	{
		if(sex!=null && sex.equals("全部"))
		{
			sex=null;
		}

		if(did!=null && did.equals("全部"))
		{
			did=null;
		}

		TableModel tableModel=new TableModel();
		tableModel.setCount(userDao.getAdminSum(name,sex,did));
		tableModel.setData(userDao.getAdminList(limit,limit*(page-1),name,sex,did));
		return new Gson().toJson(tableModel);
	}

	@Override
	public List<Deptinfo> getDept()
	{
		return deptDao.getList();
	}

	@Override
	public Userinfo getMsg(HttpSession session)
	{
		Userinfo userinfo=(Userinfo) session.getAttribute("user");
		return userDao.getMsg(userinfo.getAccount());
	}
}