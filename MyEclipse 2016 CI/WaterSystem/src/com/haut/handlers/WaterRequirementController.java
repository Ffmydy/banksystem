package com.haut.handlers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.haut.beans.Count_Requirement_Bymonth;
import com.haut.beans.Count_Requirement_Byyear;
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
	@RequestMapping("/add_water_requirement.do")
	public ModelAndView doadd_water_requirement(@Validated Irrigation_Water_Requirement irrigation_water_requirement,BindingResult br){
		ModelAndView mv=new ModelAndView();
		List<ObjectError> errors=br.getAllErrors();
		if(errors.size()>0){
			FieldError yearError=br.getFieldError("year");
			FieldError monthError=br.getFieldError("month");
			FieldError water_requirementError=br.getFieldError("water_requirement");
			if(yearError!=null){
				mv.addObject("error",yearError.getDefaultMessage());
			}
			if(monthError!=null){
				mv.addObject("error", monthError.getDefaultMessage());
			}
			if(water_requirementError!=null){
				mv.addObject("error",water_requirementError.getDefaultMessage());
			}
			mv.setViewName("/add_water_requirement.jsp");
			return mv;
		}
		else{
			Irrigation_Water_Requirement irrigation_water_requirement2=service.isempty(irrigation_water_requirement);
			if(irrigation_water_requirement2!=null){
				mv.addObject("error", "添加的月份已经存在");
				mv.setViewName("/add_water_requirement.jsp");
				return mv;
			}
			else{
				service.add_water_requirement(irrigation_water_requirement);
				mv.setViewName("/checkwater_requirement.do");
				return mv;
			}
		}
	}
	@RequestMapping("/count_requirement_bymonth.do")
	public ModelAndView docount_reuqirement_bymonth(int month){
		ModelAndView mv=new ModelAndView();
		Count_Requirement_Bymonth count_requirement_bymonth=service.count_requirement_bymonth(month);
		//System.out.println(count_requirement_bymonth);
		mv.addObject("count_requirement_bymonth", count_requirement_bymonth);
		mv.setViewName("/count_requirement_bymonth.jsp");
		return mv;
	}
	@RequestMapping("/count_requirement_byyear.do")
	public ModelAndView docount_requirement_byyear(int year){
		ModelAndView mv=new ModelAndView();
		Count_Requirement_Byyear count_requirement_byyear=service.count_requirement_byyear(year);
		mv.addObject("count_requirement_byyear",count_requirement_byyear);
		mv.setViewName("/count_requirement_byyear.jsp");
		return mv;
	}
	@RequestMapping("/check_someyear_allmonthrequirement.do")
	public ModelAndView docheck_someyear_allmonthrequirement(Integer year){
		ModelAndView mv=new ModelAndView();
		List<Irrigation_Water_Requirement> irrigation_water_requirements=service.check_someyear_allmonthrequirement(year);
		//System.out.println("----"+irrigation_water_requirements);
		mv.addObject("lists", irrigation_water_requirements);
		mv.setViewName("/show_someyear_allmonth_requirement.jsp");
		return mv;
	}
}
