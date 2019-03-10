package com.alibb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibb.pojo.Customer;
import com.alibb.service.ICustomerService;
import com.alibb.util.GetCustomerService;

public class BuyGoodsServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Customer customer =(Customer)req.getSession().getAttribute("customer");
		Integer cid = customer.getCid();
		int gid=Integer.parseInt(req.getParameter("gid"));
		double gprice=Double.parseDouble(req.getParameter("gprice"));
		String bnumber=req.getParameter("bgnumber");
		if(bnumber!=null&&!bnumber.equals("")){
			ICustomerService service = new GetCustomerService().getCustomerService();
			service.buygoods(gid,bnumber,gprice,cid);
			req.setAttribute("success","购买成功" );
			req.getRequestDispatcher("lookgoods").forward(req, resp);
		}
		else{
			req.setAttribute("emptyinfomation","请输入购买数量" );
			req.getRequestDispatcher("buygoods.jsp").forward(req, resp);
		}
	}
}
