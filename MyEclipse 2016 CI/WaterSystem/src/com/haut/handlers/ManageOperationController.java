package com.haut.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.haut.beans.PageInfo;
import com.haut.service.IManageoperationService;
@Controller
public class ManageOperationController {
	@Autowired
	@Qualifier("manageoperationService")
	private IManageoperationService service;
	public void setService(IManageoperationService service) {
		this.service = service;
	}
	@RequestMapping("/checkoperation.do")
	public ModelAndView docheckprogram(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		PageInfo pi=new PageInfo();
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize=6;
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize=Integer.parseInt(pageSizeStr);
		}
		String pageNumberStr=request.getParameter("pageNumber");
		int pageNumber=1;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			pageNumber=Integer.parseInt(pageNumberStr); 
		}
		pi=service.show_manageoperation(pageSize, pageNumber);
		mv.addObject("PageInfo", pi);
		mv.setViewName("forward:/show_manageoperation.jsp");
		return mv;
	}
	@RequestMapping("/queryoperationbyoperation_managename.do")
	public ModelAndView doqueryoperationbyoperation_managename(String operation_managename,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		PageInfo pi=new PageInfo();
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize=6;
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize=Integer.parseInt(pageSizeStr);
		}
		String pageNumberStr=request.getParameter("pageNumber");
		int pageNumber=1;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			pageNumber=Integer.parseInt(pageNumberStr); 
		}
		if(operation_managename==null){
			operation_managename=request.getParameter("operation_managename");
		}
		pi=service.queryoperationbyoperation_managename(pageSize, pageNumber,operation_managename);
		mv.addObject("PageInfo", pi);
		mv.addObject("operation_managename", operation_managename);
		mv.setViewName("forward:/show_queryoperationbyoperation_managename.jsp");
		return mv;
	}
	@RequestMapping("/queryoperationbyoperation_time.do")
	public ModelAndView doqueryoperationbyoperation_time(String operation_time,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		PageInfo pi=new PageInfo();
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize=6;
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize=Integer.parseInt(pageSizeStr);
		}
		String pageNumberStr=request.getParameter("pageNumber");
		int pageNumber=1;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			pageNumber=Integer.parseInt(pageNumberStr); 
		}
		if(operation_time==null){
			operation_time=request.getParameter("operation_time");
		}
		pi=service.queryoperationbyoperation_time(pageSize, pageNumber,operation_time);
		mv.addObject("PageInfo", pi);
		mv.addObject("operation_time", operation_time);
		mv.setViewName("forward:/show_queryoperationbyoperation_time.jsp");
		return mv;
	}
	@RequestMapping("/queryoperationbyoperation_name.do")
	public ModelAndView doqueryoperationbyoperation_name(String operation_name,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		PageInfo pi=new PageInfo();
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize=6;
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize=Integer.parseInt(pageSizeStr);
		}
		String pageNumberStr=request.getParameter("pageNumber");
		int pageNumber=1;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			pageNumber=Integer.parseInt(pageNumberStr); 
		}
		if(operation_name==null){
			operation_name=request.getParameter("operation_name");
		}
		pi=service.queryoperationbyoperation_name(pageSize, pageNumber,operation_name);
		mv.addObject("PageInfo", pi);
		mv.addObject("operation_name", operation_name);
		mv.setViewName("forward:/show_queryoperationbyoperation_name.jsp");
		return mv;
	}
}
