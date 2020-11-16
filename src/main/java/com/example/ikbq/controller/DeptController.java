package com.example.ikbq.controller;

import com.example.ikbq.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dept/")
public class DeptController
{
	@Autowired
	private DeptService deptServiceImpl;

	@RequestMapping("getDeptList")
	@ResponseBody
	public String getDeptList(Integer limit,Integer page)
	{
		return deptServiceImpl.getDeptList(limit,page);
	}

	@RequestMapping("deleteDept")
	@ResponseBody
	public String deleteDept(String name)
	{
		return deptServiceImpl.deleteDept(name);
	}

	@RequestMapping("addDept")
	@ResponseBody
	public String addDept(String name)
	{
		return deptServiceImpl.addDept(name);
	}

	@RequestMapping("check")
	@ResponseBody
	public String check(String name)
	{
		return deptServiceImpl.check(name);
	}
}