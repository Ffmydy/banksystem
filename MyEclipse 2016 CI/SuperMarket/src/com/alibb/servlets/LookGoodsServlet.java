package com.alibb.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibb.pojo.Goods;
import com.alibb.pojo.PageInfo;
import com.alibb.service.IManagerService;
import com.alibb.util.GetManagerService;

public class LookGoodsServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;utf-8");
		PageInfo pi=new PageInfo();
		//第一次访问验证，如果传递参数，设置默认值
		String pageSizeStr = req.getParameter("pageSize");
		int pageSize=5;
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize=Integer.parseInt(pageSizeStr);
		}
		String pageNumberStr=req.getParameter("pageNumber");
		int pageNumber=1;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			pageNumber=Integer.parseInt(pageNumberStr); 
		}
		IManagerService service = new GetManagerService().getManagerService();
	    pi = service.showallgoods(pageSize, pageNumber);
		req.setAttribute("PageInfo",pi);
		req.getRequestDispatcher("looklookgoods.jsp").forward(req, resp);
	}
}
