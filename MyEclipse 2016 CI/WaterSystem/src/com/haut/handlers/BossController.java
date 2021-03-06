package com.haut.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.haut.beans.Boss;
import com.haut.beans.PageInfo;
import com.haut.service.IBossService;

@Controller
public class BossController {
	@Autowired
	@Qualifier("bossService")
	private IBossService service;
	public void setService(IBossService service) {
		this.service = service;
	}
	@RequestMapping("/checkboss.do")
	public ModelAndView docheckboss(HttpServletRequest request,HttpServletResponse response){
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
		pi=service.showboss(pageSize, pageNumber);
		mv.addObject("PageInfo", pi);
		mv.setViewName("forward:/show_boss.jsp");
		return mv;
	}
	@RequestMapping("/check_current_boss.do")
	public ModelAndView docheck_current_boss(HttpServletRequest request,HttpServletResponse response){
		String boss_number=request.getParameter("boss_number");
		ModelAndView mv=new ModelAndView();
		Boss boss=service.check_current_boss(boss_number);
		mv.addObject("boss",boss);
		mv.setViewName("forward:/show_current_boss.jsp");
		return mv;
	}
	
	

}
