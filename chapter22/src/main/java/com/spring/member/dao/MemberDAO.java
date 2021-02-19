package com.spring.member.dao;

import com.spring.member.vo.MemberVO;

import java.util.List;

public interface MemberDAO {
    public List selectAllMembers();
    public int addMembers(MemberVO memberVO) throws Exception;

}
