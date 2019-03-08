package com.alibb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibb.pojo.Customer;
import com.alibb.service.ICustomerService;
import com.alibb.util.GetCustomerService;

public class RegisterServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;utf-8");
		String cname=req.getParameter("cname");
		String cpassword=req.getParameter("cpassword");
		String cphonenumber=req.getParameter("cphonenumber");
		String caddress=req.getParameter("caddress");
		double cmoney=Double.parseDouble(req.getParameter("cmoney"));
		Customer customer=new Customer(cname,cpassword,cphonenumber,caddress,cmoney);
		ICustomerService service = new GetCustomerService().getCustomerService();
		System.out.println(customer);
		service.customerRegister(customer);
		req.setAttribute("registersuccess", "注册成功");
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
}
