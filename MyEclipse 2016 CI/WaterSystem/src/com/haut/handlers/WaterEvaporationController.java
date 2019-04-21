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
import com.haut.beans.Reservoir_Water_Evaporation;
import com.haut.service.IWaterevaporationService;

@Controller
public class WaterEvaporationController {
	@Autowired
	@Qualifier("waterEvaporationService")
	private IWaterevaporationService service;
	public void setService(IWaterevaporationService service) {
		this.service = service;
	}
	@RequestMapping("/checkwater_evaporation.do")
	public ModelAndView docheckwater_evaporation(HttpServletRequest request,HttpServletResponse response){
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
		pi=service.show_water_evaporation(pageSize, pageNumber);
		mv.addObject("PageInfo", pi);
		mv.setViewName("forward:/show_water_evaporation.jsp");
		return mv;	
	}
	@RequestMapping("/add_water_evaporation.do")
	public ModelAndView doadd_water_evaporation(@Validated Reservoir_Water_Evaporation reservoir_water_evaporation,BindingResult br){
		ModelAndView mv=new ModelAndView();
		List<ObjectError> errors=br.getAllErrors();
		if(errors.size()>0){
			FieldError yearError=br.getFieldError("year");
			FieldError monthError=br.getFieldError("month");
			FieldError water_evaporationError=br.getFieldError("water_evaporation");
			if(yearError!=null){
				mv.addObject("error",yearError.getDefaultMessage());
			}
			if(monthError!=null){
				mv.addObject("error", monthError.getDefaultMessage());
			}
			if(water_evaporationError!=null){
				mv.addObject("error",water_evaporationError.getDefaultMessage());
			}
			mv.setViewName("/add_water_evaporation.jsp");
			return mv;
		}
		else{
			Reservoir_Water_Evaporation reservoir_water_evaporation2=service.isempty(reservoir_water_evaporation);
			if(reservoir_water_evaporation2!=null){
				mv.addObject("error", "添加的月份已经存在");
				mv.setViewName("/add_water_evaporation.jsp");
				return mv;
			}
			else{
				service.add_water_evaporation(reservoir_water_evaporation);
				mv.setViewName("/checkwater_evaporation.do");
				return mv;
			}
		}
	}
	@RequestMapping("/check_somemonth_water_evaporation.do")
	public ModelAndView docheck_somemonth_water_evaporation(int year,int month){
		ModelAndView mv=new ModelAndView();
		Reservoir_Water_Evaporation reservoir_water_evaporation=service.check_somemonth_water_evaporation(year,month);
		mv.addObject("reservoir_water_evaporation", reservoir_water_evaporation);
		mv.setViewName("forward:/show_somemonth_water_evaporation.jsp");
		return mv;
	}
	
}
