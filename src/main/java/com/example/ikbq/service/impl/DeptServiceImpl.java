package com.example.ikbq.service.impl;

import com.example.ikbq.dao.DeptDao;
import com.example.ikbq.entity.TableModel;
import com.example.ikbq.service.DeptService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeptServiceImpl implements DeptService
{
	@Autowired(required = false)
	private DeptDao deptDao;

	@Override
	public String deleteDept(String name)
	{
		String str="no";

		int n=deptDao.deleteDept(name);
		if(n>0)
		{
			str="yes";
		}
		return str;
	}

	@Override
	public String getDeptList(Integer limit, Integer page)
	{
		TableModel tableModel=new TableModel();
		tableModel.setCount(deptDao.getSum());
		tableModel.setData(deptDao.getDeptList(limit,limit*(page-1)));

		return new Gson().toJson(tableModel);
	}

	@Override
	public String check(String name)
	{
		String str="no";

		int n=deptDao.check(name);
		if(n==0)
		{
			str="yes";
		}
		return str;
	}

	@Override
	public String addDept(String name)
	{
		String str="no";

		int n=deptDao.addDept(name);
		if(n>0)
		{
			str="yes";
		}
		return str;
	}
}