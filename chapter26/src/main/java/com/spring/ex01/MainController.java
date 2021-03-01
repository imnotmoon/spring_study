package com.spring.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("mainController")
@RequestMapping("/test")
public class MainController {
    @RequestMapping(value = "/main1.do", method = RequestMethod.GET)
    public ModelAndView main1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("asdfkasdjfklasdfja;skdfjaklsdjf;");
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", "main1");
        mav.setViewName("main");
        return mav;
    }

    @RequestMapping(value = "/main2.do", method = RequestMethod.GET)
    public ModelAndView main2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", "main2");
        mav.setViewName("main");
        return mav;
    }
}
