package com.alibb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibb.service.IManagerService;
import com.alibb.util.GetCustomerService;
import com.alibb.util.GetManagerService;

public class DeleteCustomerServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String id = req.getParameter("cid");
		int cid=Integer.parseInt(id);
		IManagerService service = new GetManagerService().getManagerService();
		service.deletecustomer(cid);
		req.getRequestDispatcher("checkcustomer").forward(req, resp);
	}
}
