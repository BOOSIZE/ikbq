package com.example.ikbq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IkbqApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(IkbqApplication.class, args);
		System.out.println("服务器已启动");
	}

}
