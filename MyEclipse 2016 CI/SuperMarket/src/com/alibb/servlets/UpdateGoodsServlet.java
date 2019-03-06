package com.alibb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibb.pojo.Goods;
import com.alibb.service.IManagerService;
import com.alibb.util.GetManagerService;

public class UpdateGoodsServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		int gid=Integer.parseInt(req.getParameter("gid"));
		String gname=req.getParameter("gname");
		String price=req.getParameter("gprice");
		String number=req.getParameter("gnumber");
		if(price!=null&&!price.equals("")&&number!=null&&!number.equals("")){
		    double gprice=Double.parseDouble(price);
		    int gnumber=Integer.parseInt(req.getParameter(number));
		    Goods goods=new Goods(gname,gprice,gnumber);
			goods.setGid(gid);
			IManagerService service = new GetManagerService().getManagerService();
			service.updategoods(goods);
			req.getRequestDispatcher("checkgoods").forward(req, resp);
		}
		else{
			req.setAttribute("error", "价格或数量不能为空");
			req.getRequestDispatcher("updategoods.jsp").forward(req, resp);
		}
		
	}

}
