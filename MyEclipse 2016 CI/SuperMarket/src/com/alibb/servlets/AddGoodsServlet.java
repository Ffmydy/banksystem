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
		double gprice = Double.parseDouble(req.getParameter("gprice"));
		int gnumber = Integer.parseInt(req.getParameter("gnumber"));
		Goods goods=new Goods(gname,gprice,gnumber);
		IManagerService service = new GetManagerService().getManagerService();
		service.addgoods(goods);
		req.setAttribute("infomation", "添加成功");
		req.getRequestDispatcher("addgoods.jsp").forward(req, resp);
	}
}
