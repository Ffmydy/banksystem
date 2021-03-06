package com.haut.handlers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.haut.beans.Manage;
import com.haut.beans.PageInfo;
import com.haut.beans.Water_Test_Operation;
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
	@RequestMapping("/checkunqualified_program.do")
	public ModelAndView docheckunqualified_program(HttpServletRequest request,HttpServletResponse response){
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
		pi=service.show_unqualified_item(pageSize, pageNumber);
		mv.addObject("PageInfo", pi);
		mv.setViewName("forward:/show_water_unqualified_item.jsp");
		return mv;
	}
	@RequestMapping("/deleteprogram.do")
	public ModelAndView dodeleteprogram(HttpSession session){
		ModelAndView mv=new ModelAndView();
		String operation_name="删除";
		Manage manage=(Manage) session.getAttribute("manage");
		String operation_managename=manage.getManage_name();
		String operation_itemname=(String) session.getAttribute("item_name");
		String operation_itemnumber=(String) session.getAttribute("item_number");
		Date  date =new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
		String opereation_time = sdf.format(date);
		Water_Test_Operation water_test_operation=new Water_Test_Operation(operation_managename,operation_itemnumber,operation_itemname,opereation_time,operation_name);
		service.deleteitem((String)session.getAttribute("item_number"),water_test_operation);
		mv.setViewName("redirect:/checkprogram.do");
		return mv;
	}
	@RequestMapping("/updateprogram.do")
	public ModelAndView doupdateprogram(@Validated Water_Test_Report water_test_report,BindingResult br,HttpServletRequest request,HttpSession session){
		ModelAndView mv=new ModelAndView();
		List<ObjectError> errors=br.getAllErrors();
		//System.out.println(water_test_report);
		if(errors.size()>0){
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
			String operation_name="修改";
			Manage manage=(Manage) session.getAttribute("manage");
			String operation_managename=manage.getManage_name();
			String operation_itemnumber=water_test_report.getItem_number();
			String operation_itemname=water_test_report.getItem_name();
			Date  date =new Date();
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
    		String opereation_time = sdf.format(date);
    		Water_Test_Operation water_test_operation=new Water_Test_Operation(operation_managename,operation_itemnumber,operation_itemname,opereation_time,operation_name);
			service.updateitem(water_test_report,water_test_operation);
			mv.setViewName("redirect:/checkprogram.do");
			return mv;
		}
   }
	@RequestMapping("/addprogram.do")
	public ModelAndView doaddprogram(@Validated Water_Test_Report water_test_report,BindingResult br,HttpServletRequest request,HttpSession session){
		ModelAndView mv=new ModelAndView();
		List<ObjectError> errors=br.getAllErrors();
		System.out.println(water_test_report);
		if(errors.size()>0){
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
			mv.setViewName("/add_wateritem.jsp");
			return mv;
		}
		else{
			Water_Test_Report water_test_report2=new Water_Test_Report();
			water_test_report2=service.check_itemnumber(water_test_report.getItem_number());
			if(water_test_report2==null){
				String operation_name="添加";
				Manage manage=(Manage) session.getAttribute("manage");
				String operation_managename=manage.getManage_name();
				String operation_itemnumber=water_test_report.getItem_number();
				String operation_itemname=water_test_report.getItem_name();
				Date  date =new Date();
	    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
	    		String opereation_time = sdf.format(date);
	    		Water_Test_Operation water_test_operation=new Water_Test_Operation(operation_managename,operation_itemnumber,operation_itemname,opereation_time,operation_name);
				service.additem(water_test_report,water_test_operation);
				mv.setViewName("redirect:/checkprogram.do");
				return mv;
			}
			else{
				mv.addObject("error", "项目已经存在，请查证后再添加！");
				mv.setViewName("/add_wateritem.jsp");
				return mv;
			}
			
		}
	}
	@RequestMapping("/querybyitem_number.do")
	public ModelAndView doquerybyitem_number(String item_number){
		ModelAndView mv=new ModelAndView();
		Water_Test_Report water_test_report=service.check_itemnumber(item_number);
			mv.setViewName("/show_querybyitem_number.jsp");
			mv.addObject("water_test_report", water_test_report);
			return mv;
	}
	@RequestMapping("/querybydetection_time.do")
	public ModelAndView doquerybydetection_time(String detection_time,HttpServletRequest request,HttpServletResponse response){
		//System.out.println(detection_time);
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
		if(detection_time==null){
			detection_time=request.getParameter("detection_time");
		}
		pi=service.querybydetection_time(pageSize, pageNumber,detection_time);
		mv.addObject("PageInfo", pi);
		mv.addObject("detection_time",detection_time);
		mv.setViewName("forward:/show_querybydetection_time.jsp");
		return mv;
	}
	@RequestMapping("/querybyunit_number.do")
	public ModelAndView doquerybyunit_number(String unit_number,HttpServletRequest request,HttpServletResponse response){
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
		if(unit_number==null){
			unit_number=request.getParameter("unit_number");
		}
		pi=service.querybyunit_number(pageSize, pageNumber,unit_number);
		mv.addObject("PageInfo", pi);
		mv.addObject("unit_number",unit_number);
		mv.setViewName("forward:/show_querybyunit_number.jsp");
		return mv;
	}
	@RequestMapping("/querybywater_level.do")
	public ModelAndView doquerybywater_level(Integer water_level,HttpServletRequest request,HttpServletResponse response){
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
		if(water_level==null){
			water_level=Integer.parseInt(request.getParameter("water_level"));
		}
		pi=service.querybywater_level(pageSize, pageNumber,water_level);
		mv.addObject("PageInfo", pi);
		mv.addObject("water_level",water_level);
		mv.setViewName("forward:/show_querybywater_level.jsp");
		return mv;
	}
	@RequestMapping("/queryunqualifiedbyitem_number.do")
	public ModelAndView doqueryunqualifiedbyitem_number(String item_number){
		ModelAndView mv=new ModelAndView();
		Water_Test_Report water_test_report=service.queryunqualifiedbyitem_number(item_number);
		if(water_test_report==null){
			mv.addObject("UnqualifieditemEmpty", "该项目不存在或者该项目是合格水检项目，请查证后再查询!");
			mv.setViewName("/checkunqualified_program.do");
		}else{
			mv.setViewName("/show_queryunqualifiedbyitem_number.jsp");
			mv.addObject("water_test_report", water_test_report);
		}
		return mv;
	}
	@RequestMapping("/queryunqualifiedbydetection_time.do")
	public ModelAndView doqueryunqualifiedbydetection_time(String detection_time,HttpServletRequest request,HttpServletResponse response){
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
		if(detection_time==null){
			detection_time=request.getParameter("detection_time");
		}
		pi=service.queryunqualifiedbydetection_time(pageSize, pageNumber,detection_time);
		mv.addObject("PageInfo", pi);
		mv.addObject("detection_time",detection_time);
		mv.setViewName("forward:/show_queryunqualifiedbydetection_time.jsp");
		return mv;
	}
	@RequestMapping("/queryunqualifiedbyunit_number.do")
	public ModelAndView doqueryunqualifiedbyunit_number(String unit_number,HttpServletRequest request,HttpServletResponse response){
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
		if(unit_number==null){
			unit_number=request.getParameter("unit_number");
		}
		pi=service.queryunqualifiedbyunit_number(pageSize, pageNumber,unit_number);
		mv.addObject("PageInfo", pi);
		mv.addObject("unit_number",unit_number);
		mv.setViewName("forward:/show_queryunqualifiedbyunit_number.jsp");
		return mv;
	}
}
