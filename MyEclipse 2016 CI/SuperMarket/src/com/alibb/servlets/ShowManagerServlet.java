package com.alibb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibb.pojo.Manager;
import com.alibb.service.IManagerService;
import com.alibb.util.GetManagerService;

public class ShowManagerServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String id = req.getParameter("mid");
		System.out.println(id);
		if(id!=null&&!id.equals("")){
			int mid=Integer.parseInt(id);
			IManagerService service = new GetManagerService().getManagerService();
			Manager manager = service.checkmanager(mid);
			req.setAttribute("manager", manager);
			req.getRequestDispatcher("showmanager.jsp").forward(req, resp);
		}
		else{
			req.getRequestDispatcher("managermain.jsp").forward(req, resp);
		}
	}
}
