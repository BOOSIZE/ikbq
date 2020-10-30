package com.example.ikbq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/go/")
public class GoController
{
	@RequestMapping("to/{path}")
	public String to(@PathVariable String path)
	{
		return path;
	}
}