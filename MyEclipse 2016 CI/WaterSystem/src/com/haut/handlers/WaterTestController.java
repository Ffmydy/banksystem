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

import com.haut.beans.PageInfo;
import com.haut.beans.Water_Test_Report;
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
	@RequestMapping("/updateprogram.do")
	public ModelAndView doupdateprogram(@Validated Water_Test_Report water_test_report,BindingResult br,HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		List<ObjectError> errors=br.getAllErrors();
		System.out.println(water_test_report);
		if(errors.size()>0){
			System.out.println(water_test_report+"出错了");
			FieldError item_numberError=br.getFieldError("item_number");
			FieldError itme_nameError=br.getFieldError("item_name");
			FieldError item_concentrationError=br.getFieldError("item_concentration");
			FieldError water_levelError=br.getFieldError("water_level");
			FieldError detection_timeError=br.getFieldError("detection_time");
			FieldError unit_numberError=br.getFieldError("unit_number");
			if(unit_numberError!=null){
				mv.addObject("error",unit_numberError.getDefaultMessage());
			}
			if(detection_timeError!=null){
				mv.addObject("error", detection_timeError.getDefaultMessage());
			}
			if(water_levelError!=null){
				mv.addObject("error",water_levelError.getDefaultMessage());
			}
			if(item_concentrationError!=null){
				mv.addObject("error", item_concentrationError.getDefaultMessage());
			}
			if( itme_nameError!=null){
				mv.addObject("error", itme_nameError.getDefaultMessage());
			}
			if(item_numberError!=null){
				mv.addObject("error",item_numberError.getDefaultMessage());
			}
			mv.setViewName("/updateitem.jsp");
			return mv;
		}
		else{
			System.out.println(water_test_report+"进去了");
			service.updateitem(water_test_report);
			mv.setViewName("/checkprogram.do");
			return mv;
		}
   }
}
