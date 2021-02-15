package com.spring.ex02;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController  {

    public ModelAndView login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println(httpServletRequest);
        String userID = "";
        String passwd = "";
        ModelAndView mav = new ModelAndView();
        httpServletRequest.setCharacterEncoding("utf-8");
        userID = httpServletRequest.getParameter("userID");
        passwd = httpServletRequest.getParameter("passwd");
        mav.addObject("userID", userID);
        mav.addObject("passwd", passwd);
        mav.setViewName("result");
        return mav;
    }
}
