package com.barber.server.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.barber.server.domain.vo.input.Person;

@Controller
public class ThymeleafController {
	
	
	 @RequestMapping(value = {"/","/hello"})
	 public String hello11(Locale locale, Model model) {
	   		model.addAttribute("greeting", "Hello!");

	   		Date date = new Date();
	   		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);        
	   		String formattedDate = dateFormat.format(date);
	   		model.addAttribute("currentTime", formattedDate);
	   		model.addAttribute("title", "nnd");
	   		
	   		model.addAttribute("title", "nnd");
	   		model.addAttribute("title", "nnd");

	   		return "hello";
	   	}
	 
	@RequestMapping("/index")
    public String index(Model model) {
        Person single = new Person("aa", 11);
        List<Person> people = new ArrayList<>();
        Person p1 = new Person("zhangsan", 11);
        Person p2 = new Person("lisi", 22);
        Person p3 = new Person("wangwu", 33);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        return "index";
    }
	
    @RequestMapping("/hi")
	public String hello(Locale locale, Model model) {
		model.addAttribute("greeting", "Hello!");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);        
		String formattedDate = dateFormat.format(date);
		model.addAttribute("currentTime", formattedDate);
		model.addAttribute("title", "nnd");
		

		return "layout";
	}
    
   
    
    
//    @Autowired
//    private NeoProperties  neoProperties;
//    
//    @RequestMapping("/hii")
//    @ResponseBody
// 	public NeoProperties helloo(Locale locale, Model model) {
// 		
// 		return neoProperties;
// 	}

}