package com.yadu.example.demo.controller;

import com.github.pagehelper.PageHelper;
import com.yadu.example.demo.entity.User;
import com.yadu.example.demo.service.LocaleMessageSourceService;
import com.yadu.example.demo.service.UserAService;
import com.yadu.example.demo.service.UserService;
import com.yadu.example.demo.until.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Locale;
@Slf4j
@RestController
public class Controller {

    @Autowired
    private UserService userService;

    @Autowired
    private UserAService userAService;

    @Autowired
    private MessageSource messageSource;

    /**
     * 获取国际化信息
     */
    @Resource
    private LocaleMessageSourceService localeMessageSourceService;

    @GetMapping("/hi")
    public String index(){
        return "hello spring boot";
    }
    @RequestMapping("/users/{userId}")
    public User getUser(@PathVariable("userId") int userId){
        User user = userService.getById(userId);
        return user;
    }

    /**
     * freemarker模板
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/indexFre")
    public ModelAndView indexFre(ModelAndView modelAndView) {
       /* //设置返回的页面名称
        modelAndView.setViewName("indexFre");
        //要返回在页面的数据
        List<User> userList =  userService.getUsers();
        modelAndView.addObject("userList", userList);*/
        return modelAndView;
    }


    @RequestMapping("/index")
    public ModelAndView hello(ModelAndView modelAndView){
        //String msg3 = localeMessageSourceService.getMessage("welcome");
        modelAndView.setViewName("index");
        return  modelAndView;
    }

    /**
     * 切换语言
     * @param modelAndView
     * @param request
     * @param response
     * @param lang
     * @return
     */
    @RequestMapping("/changeSessionLanauage")
    public ModelAndView changeSessionLanauage(ModelAndView modelAndView,HttpServletRequest request, HttpServletResponse response, String lang){
        System.out.println(lang);
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        if("zh".equals(lang)){
            localeResolver.setLocale(request, response, new Locale("zh", "CN"));
        }else if("en".equals(lang)){
            localeResolver.setLocale(request, response, new Locale("en", "US"));
        }
        modelAndView.setViewName("redirect:index");
        return modelAndView;
    }


    /**
     * 测试分页
     * @return
     */
    @ResponseBody
    @RequestMapping("/test")
    public ServiceResult test(){
        PageHelper.startPage(0,2);
        List<User>  list= userService.getUsers();
        /*User student = userAService.getById(1);
        User student1 = userService.getById(2);
        List<User> list =new ArrayList<>();
        list.add(student);
        list.add(student1);*/
        return ServiceResult.success(list);
    }






}