package com.alibb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.alibb.pojo.Customer;
import com.alibb.pojo.Manager;
import com.alibb.service.ICustomerService;
import com.alibb.service.IManagerService;
import com.alibb.util.GetCustomerService;
import com.alibb.util.GetManagerService;

public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String phonenumber=req.getParameter("phonenumber");
		String password=req.getParameter("password");
		String grade=req.getParameter("grade");
		String verifyCode = req.getParameter("verifyCode");
		//2 获得服务器session 存放数据 ,如果没有返回null
        String sessionCacheData = (String) req.getSession().getAttribute("sessionCacheData");
        // *将服务器缓存session数据移除
        req.getSession().removeAttribute("sessionCacheData");
        if(sessionCacheData == null){
            req.setAttribute("msg", "请不要重复提交");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
		int type=Integer.parseInt(grade);
		if(type==0){
			ICustomerService service=new GetCustomerService().getCustomerService();
			Customer customer=service.customerLogin(phonenumber, password);
			if(customer!=null){
				 if(! sessionCacheData.equalsIgnoreCase(verifyCode)){
			            //用户输入错误
			            // * 存放request作用域
			            req.setAttribute("msg", "验证码输入错误");
			            // * 请求转发
			            req.getRequestDispatcher("/login.jsp").forward(req, resp); 
			            return;
			        } 
				 else{
					 HttpSession hs=req.getSession();
					 hs.setAttribute("customer", customer);
					 resp.sendRedirect("customermain.jsp");
				 }
			}
			else{
				req.setAttribute("User_Password_Error", "用户名或密码错误");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		}
		else{
			IManagerService service= new GetManagerService().getManagerService();
			Manager manager=service.managerLogin(phonenumber, password);
			if(manager!=null){
				 if(! sessionCacheData.equalsIgnoreCase(verifyCode)){
			            //用户输入错误
			            // * 存放request作用域
			            req.setAttribute("msg", "验证码输入错误");
			            // * 请求转发
			            req.getRequestDispatcher("/login.jsp").forward(req, resp); 
			            return;
			        } 
				 else{
				     HttpSession hs=req.getSession();
					 hs.setAttribute("mid", manager.getMid());
					 resp.sendRedirect("managermain.jsp");
				 }
			}
			else{
				req.setAttribute("User_Password_Error", "用户名或密码错误");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		}
	    }
	    public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        this.doGet(request, response);
	    }
	}

