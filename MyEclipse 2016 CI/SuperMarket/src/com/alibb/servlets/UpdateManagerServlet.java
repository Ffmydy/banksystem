package com.alibb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibb.pojo.Manager;
import com.alibb.service.IManagerService;
import com.alibb.util.GetManagerService;

public class UpdateManagerServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		int mid=Integer.parseInt(req.getParameter("mid"));
		String mname=req.getParameter("mname");
		String mphonenumber=req.getParameter("mphonenumber");
		String mpassword=req.getParameter("mpassword");
		//System.out.println(mname+mphonenumber+mpassword);
		if(mname!=null&&!mname.equals("")&&mphonenumber!=null&&!mphonenumber.equals("")&&mpassword!=null&&!mpassword.equals("")){
			Manager manager=new Manager(mname,mpassword,mphonenumber);
			manager.setMid(mid);
			IManagerService service = new GetManagerService().getManagerService();
			service.updatemanager(manager);
			req.getRequestDispatcher("showmanager").forward(req, resp);
		}
		else{
			req.setAttribute("emptyinfomation", "信息不能为空");
			req.getRequestDispatcher("updatemanager.jsp").forward(req, resp);
		}
	}
}
