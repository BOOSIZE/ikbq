package com.example.ikbq.controller;

import com.example.ikbq.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/file/")
public class FileController
{
	@Autowired
	private FileService fileServiceImpl;

	@RequestMapping("getList")
	@ResponseBody
	public String getList(Integer limit,Integer page)
	{
		return fileServiceImpl.getList(limit, page);
	}

	@RequestMapping("deleteFile")
	@ResponseBody
	public String deleteFile(Long id)
	{
		return fileServiceImpl.deleteFile(id);
	}

	@RequestMapping("addFile")
	@ResponseBody
	public String addFile(HttpServletRequest request, MultipartFile file)
	{
		return fileServiceImpl.addFile(request, file);
	}
}