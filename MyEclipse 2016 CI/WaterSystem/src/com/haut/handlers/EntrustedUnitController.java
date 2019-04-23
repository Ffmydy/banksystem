package com.haut.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.haut.beans.Entrusted_unit;
import com.haut.beans.PageInfo;
import com.haut.service.IEntrustedunitService;


@Controller
public class EntrustedUnitController {
	@Autowired
	@Qualifier("entrustedunitService")
	private IEntrustedunitService service;
	public void setService(IEntrustedunitService service) {
		this.service = service;
	}
	@RequestMapping("/checkunit.do")
	public ModelAndView docheckunit(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		PageInfo pi=new PageInfo();
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize=3;
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize=Integer.parseInt(pageSizeStr);
		}
		String pageNumberStr=request.getParameter("pageNumber");
		int pageNumber=1;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			pageNumber=Integer.parseInt(pageNumberStr); 
		}
		pi=service.showunit(pageSize, pageNumber);
		mv.addObject("PageInfo", pi);
		mv.setViewName("forward:/show_entrustedunit.jsp");
		return mv;
	}
	@RequestMapping("/check_current_unit.do")
	public ModelAndView docheck_current_unit(HttpServletRequest request,HttpServletResponse response){
		String unit_number=request.getParameter("unit_number");
		ModelAndView mv=new ModelAndView();
		Entrusted_unit entrusted_unit=service.check_current_unit(unit_number);
		mv.addObject("entrusted_unit", entrusted_unit);
		mv.setViewName("forward:/show_current_entrustedunit.jsp");
		return mv;  
	}
}
