package com.haut.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.haut.beans.Irrigation_Water_Requirement;
import com.haut.beans.PageInfo;
import com.haut.service.IWaterrequirementService;

@Controller
public class WaterRequirementController {
	@Autowired
	@Qualifier("waterRequirementService")
	private IWaterrequirementService service;
	public void setService(IWaterrequirementService service) {
		this.service = service;
	}
	@RequestMapping("/checkwater_requirement.do")
	public ModelAndView docheckwater_requirement(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		PageInfo pi=new PageInfo();
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize=12;
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize=Integer.parseInt(pageSizeStr);
		}
		String pageNumberStr=request.getParameter("pageNumber");
		int pageNumber=1;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			pageNumber=Integer.parseInt(pageNumberStr); 
		}
		pi=service.show_water_requirement(pageSize, pageNumber);
		mv.addObject("PageInfo", pi);
		mv.setViewName("forward:/show_water_requirement.jsp");
		return mv;	
	}
	@RequestMapping("/check_somemonth_water_requirement.do")
	public ModelAndView docheck_somemonth_water_requirement(int year,int month){
		ModelAndView mv=new ModelAndView();
		Irrigation_Water_Requirement irrigation_water_requirement=service.check_somemonth_water_requirement(year,month);
		mv.addObject("irrigation_water_requirement", irrigation_water_requirement);
		mv.setViewName("forward:/show_somemonth_water_requirement.jsp");
		return mv;
	}
}
