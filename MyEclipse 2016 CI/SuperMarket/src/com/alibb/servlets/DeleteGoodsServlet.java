package com.alibb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibb.service.IManagerService;
import com.alibb.util.GetManagerService;

public class DeleteGoodsServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		IManagerService service=new GetManagerService().getManagerService();
		int gid=Integer.parseInt(req.getParameter("gid"));
		service.deletegoods(gid);
		req.getRequestDispatcher("checkgoods").forward(req, resp);
	}
}
