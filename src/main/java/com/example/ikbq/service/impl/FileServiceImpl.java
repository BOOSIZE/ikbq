package com.example.ikbq.service.impl;

import com.example.ikbq.dao.FileDao;
import com.example.ikbq.entity.Fileinfo;
import com.example.ikbq.entity.TableModel;
import com.example.ikbq.entity.Userinfo;
import com.example.ikbq.service.FileService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Service
@Transactional
public class FileServiceImpl implements FileService
{
	@Autowired(required = false)
	private FileDao fileDao;


	@Override
	public String getList(Integer limit, Integer page)
	{
		TableModel tableModel=new TableModel();
		tableModel.setCount(fileDao.getSum());
		tableModel.setData(fileDao.getList(limit,limit*(page-1)));
		return new Gson().toJson(tableModel);
	}

	@Override
	public String addFile(HttpServletRequest request, MultipartFile file)
	{
		String str="no";

		try
		{
			Fileinfo fileinfo=new Fileinfo();
			Userinfo userinfo=(Userinfo) request.getSession().getAttribute("user");

			fileinfo.setAccount(userinfo.getAccount());
			fileinfo.setTitle(request.getParameter("title"));
			fileinfo.setMoney(request.getParameter("money"));



			File dir=new File(System.getProperty("user.dir")+"/src/main/resources/static/files");


			String fname=file.getOriginalFilename();

			int index=fname.lastIndexOf('.');
			String type=fname.substring(index);
			String realName=fname.substring(0,index);
			fileinfo.setType(type);

			File newFile=new File(dir.getAbsoluteFile()+"/"+fname);

			int count=1;
			while(newFile.exists())
			{
				newFile=new File(dir.getAbsoluteFile()+"/"+realName+"副本"+count+type);
				count++;
			}

			fileinfo.setName(newFile.getName());

			file.transferTo(newFile);


			int n=fileDao.addFile(fileinfo);
			if(n>0)
			{
				str="yes";
			}



		}
		catch(Exception e)
		{
			e.printStackTrace();
		}



		return str;
	}

	@Override
	public String deleteFile(Long id)
	{
		String str="no";

		String name=fileDao.getName(id);
		File file=new File(System.getProperty("user.dir")+"/src/main/resources/static/files/"+name);
		file.delete();

		int n=fileDao.deleteFile(id);
		if(n>0)
		{
			str="yes";
		}
		return str;
	}
}