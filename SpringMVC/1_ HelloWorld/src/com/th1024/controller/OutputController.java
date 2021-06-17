package com.th1024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author TuHong
 * @create 2021-04-23 10:08
 */

@RequestMapping("/output")
@Controller
@SessionAttributes(value = "haha",types = {String.class})
public class OutputController {

    /*
    1. SpringMVC可以通过在方法形参列表传入Map、Model或者ModelMap，将数据保存在这些参数中，参数再将数据保存在请求域中的方式，在页面中获取数据

    Map、Model或者ModelMap实际运行时都为同一种类型：BindingAwareModelMap

    Map(interface(jdk))      Model(interface(spring))
  			||							//
  			||						   //
  			\/						  //
  		ModelMap(class)			     //
 					\\				//
  					 \\	           //
  					ExtendedModelMap
  							||
  							\/
  					BindingAwareModelMap

    2. 方法的返回值可以为ModelAndView类型，既包含视图信息（页面地址）也包含模型数据（给页面带的数据）

    3. @SessionAttributes(value = "msg", types = {String.class})
    value = "msg"：在往请求域中保存数据时，只要是key的值为"msg"，这份数据也会同时保存在Session域中
    types = {String.class}：在往请求域中保存数据时，只要value是String类型的，这份数据也会同时保存在Session域中
    不推荐使用，往Session域中保存数据使用原生API
     */

    @RequestMapping("/handle01")
    public String handle01(Map<String,Object> map){
        map.put("msg","map存入的数据");
        map.put("haha","哈哈");
        System.out.println("map类型" + map.getClass());//org.springframework.validation.support.BindingAwareModelMap
        return "success";
    }

    @RequestMapping("/handle02")
    public String handle02(Model model){
        model.addAttribute("msg","model存入的数据");
        model.addAttribute("haha",18);
        System.out.println("model的类型" + model.getClass());//org.springframework.validation.support.BindingAwareModelMap
        return "success";
    }

    @RequestMapping("/handle03")
    public String handle03(ModelMap modelMap){
        modelMap.addAttribute("msg","modelMap存入的数据");
        System.out.println("modelMap的类型" + modelMap.getClass());//org.springframework.validation.support.BindingAwareModelMap
        return "success";
    }

    /*
    返回值可以为ModelAndView，为页面携带数据
     */
    @RequestMapping("/handle04")
    public ModelAndView handle04(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","modelAndView存入的数据");
        mv.setViewName("success");
        return mv;
    }
}
