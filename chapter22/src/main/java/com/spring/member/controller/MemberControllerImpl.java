package com.spring.member.controller;

import com.spring.member.dao.MemberDAO;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class MemberControllerImpl implements MemberController{

    private MemberDAO memberDAO;

    public void setMemberDAO(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Override
    public ModelAndView listMembers() {
        List membersList = null;
        membersList = memberDAO.selectAllMembers();
        ModelAndView mav = new ModelAndView("listMembers");
        mav.addObject("membersList", membersList);
        return mav;
    }
}
