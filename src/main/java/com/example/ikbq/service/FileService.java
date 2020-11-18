package com.example.ikbq.service;

import org.springframework.http.HttpRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface FileService
{
	String getList(Integer limit,Integer page);

	String deleteFile(Long id);

	String addFile(HttpServletRequest request, MultipartFile file);
}