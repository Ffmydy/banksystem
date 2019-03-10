package com.alibb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibb.pojo.Goods;
import com.alibb.service.IManagerService;
import com.alibb.util.GetManagerService;

public class UpdateCustomerServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		int cid=Integer.parseInt(req.getParameter("cid"));
		String cname=req.getParameter("cname");
		String cpassword=req.getParameter("cpassword");
		String cphonenumber=req.getParameter("cphonenumber");
		String caddress=req.getParameter("caddress");
		if(cpassword!=null&&!cpassword.equals("")&&cphonenumber!=null&&!cphonenumber.equals("")&&caddress!=null&&!caddress.equals("")){
			IManagerService service = new GetManagerService().getManagerService();
			service.updatecustomer(cid,cpassword,cphonenumber,caddress);
			req.getRequestDispatcher("checkcustomer").forward(req, resp);
		}
		else{
			req.setAttribute("error", "信息不能为空");
			req.getRequestDispatcher("updatecustomer.jsp").forward(req, resp);
		}
	}
}
