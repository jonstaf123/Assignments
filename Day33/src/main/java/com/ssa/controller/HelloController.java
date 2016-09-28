package com.ssa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/about")
    public ModelAndView about(HttpServletRequest request, ModelAndView mv) {
//        if(request.getParameter("name") != null){
//            mv.addObject("name", request.getParameter("name"));
//        }
        mv.setViewName("about");
        return mv;
    }
	
	@RequestMapping("/help")
    public ModelAndView help(HttpServletRequest request, ModelAndView mv) {
		HashMap<Integer, String > messages = new HashMap<Integer, String>();
		
		
		
		
	messages.put(1,"message 1");
	messages.put(2,"message 2");
	messages.put(3,"help page 3");
	messages.put(4,"message 4");
	messages.put(5,"message 5");
	
	
		
	
    

	
		
	
		String strId =request.getParameter("id");
		int id=Integer.parseInt(strId);
		String messagetxt= messages.get(id);
        mv.addObject("id", request.getParameter("id"));
        mv.addObject("description",messagetxt);
        mv.setViewName("help");
        return mv;
    }
	@RequestMapping("/")
    public ModelAndView home(HttpServletRequest request, ModelAndView mv) {
        if(request.getParameter("name") != null){
            mv.addObject("name", request.getParameter("name"));
        }
        mv.setViewName("home");
        return mv;
    }
}
