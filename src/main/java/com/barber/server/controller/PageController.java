package com.barber.server.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.barber.server.service.serviceImpl.CustomerService;



@Controller
public class PageController {

    private static final Logger log = LoggerFactory.getLogger(PageController.class);

//    /**
//     * 默认页<br/>
//     * @RequestMapping("/") 和 @RequestMapping 是有区别的
//     * 如果不写参数，则为全局默认页，加入输入404页面，也会自动访问到这个页面。
//     * 如果加了参数“/”，则只认为是根页面。
//     *
//     */
//    @RequestMapping(value = {"/","/index"})
//    public String index(Map<String, Object> model){
//        model.put("time", new Date());
//        model.put("message", "hello，你好！");
//
//        return "index";
//    }
//
//    /**
//     * 响应到JSP页面page1
//     *
//     * @return
//     * @author SHANHY
//     * @create  2016年1月5日
//     */
//    @RequestMapping("/page1")
//    public ModelAndView page1(){
//        log.info(">>>>>>>> PageController.page1");
//        // 页面位置 /WEB-INF/jsp/page/page.jsp
//        ModelAndView mav = new ModelAndView("page/page1");
//        mav.addObject("content", "hello");
//        return mav;
//    }

    @RequestMapping("/testJson")
    @ResponseBody
    public Map<String, String> getInfo(@RequestParam(required=false) String name,
            @RequestParam(required=false) String name1) {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("name1", name1);
        return map;
    } 
    
  
    @Autowired
    private CustomerService customerService;
    
    @RequestMapping(value = "/params")  
    public Object getEntryByParams(@RequestParam(value = "name", defaultValue = "test") String name, 
    		@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {  
         
    	Sort sort = new Sort(Sort.Direction.DESC, "updateTime");  
        Pageable pageable = new PageRequest(page, size, sort);  
        return customerService.getList(name,pageable);      
    }
    
    @RequestMapping(value = "/names")  
    public Object getEntryByParams1(@RequestParam(value = "name", defaultValue = "test") String name, 
    		@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {  
         
    	Sort sort = new Sort(Sort.Direction.DESC, "updateTime");  
        Pageable pageable = new PageRequest(page, size, sort);  
        return customerService.getListNames(name,pageable);      
    }
    
    
    
//    @RequestMapping(value = "/pagelist")
//    public Page<customer> getEntryByPageable(@RequestParam(value = "page", defaultValue = "0") Integer page,
//            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
//    		@PageableDefault(value = 15, sort = { "id" ,"updateTime"}, direction = Direction.DESC) Pageable pageable
//    		) {
//    	
//    	
//        return customerJpaManager.findAll(pageable);
//    }

}
