package com.alibb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibb.pojo.Goods;
import com.alibb.service.IManagerService;
import com.alibb.util.GetManagerService;

public class AddGoodsServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;utf-8");
		String gname=req.getParameter("gname");
		String price=req.getParameter("gprice");
		String number=req.getParameter("gnumber");
		if(gname!=null&&!gname.equals("")&&price!=null&&!price.equals("")&&number!=null&&!number.equals("")){
			double gprice = Double.parseDouble(gname);
			int gnumber = Integer.parseInt(number);
			Goods goods=new Goods(gname,gprice,gnumber);
			IManagerService service = new GetManagerService().getManagerService();
			service.addgoods(goods);
			req.setAttribute("infomation", "添加成功");
			req.getRequestDispatcher("addgoods.jsp").forward(req, resp);
		}
		else{
			req.setAttribute("empty", "商品信息不能为空");
			req.getRequestDispatcher("addgoods.jsp").forward(req, resp);
		}
	}
}
