package com.example.ikbq.service;

public interface DeptService
{
	String getDeptList(Integer limit,Integer page);

	String deleteDept(String name);

	String check(String name);

	String addDept(String name);
}