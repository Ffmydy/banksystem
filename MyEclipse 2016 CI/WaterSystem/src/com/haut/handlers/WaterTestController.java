package com.haut.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.haut.beans.PageInfo;
import com.haut.service.IWatertestService;

@Controller
public class WaterTestController {
	@Autowired
	@Qualifier("watertestService")
	private IWatertestService service;
	public void setService(IWatertestService service) {
		this.service = service;
	}
	@RequestMapping("/checkprogram.do")
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
		pi=service.showitem(pageSize, pageNumber);
		mv.addObject("PageInfo", pi);
		mv.setViewName("forward:/show_wateritem.jsp");
		return mv;
	}
	@RequestMapping("/deleteprogram.do")
	public ModelAndView dodeleteprogram(int item_number){
		ModelAndView mv=new ModelAndView();
		service.deleteitem(item_number);
		mv.setViewName("forward:/checkprogram.do");
		return mv;
	}
}
