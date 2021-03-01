package com.spring.ex01;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.Reader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberDAO {
    private static SqlSessionFactory sqlMapper = null;
    public static SqlSessionFactory getInstance() {
        if(sqlMapper == null) {
            try {
                String resource = "mybatis/SqlMapConfig.xml";
                Reader reader = Resources.getResourceAsReader(resource);
                sqlMapper = new SqlSessionFactoryBuilder().build(reader);
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sqlMapper;
    }

    public List<MemberVO> selectAllMemberList() {
        sqlMapper=getInstance();
        SqlSession session = sqlMapper.openSession();
        List<MemberVO> memList = null;
        memList = session.selectList("mapper.member.selectAllMemberList");
        return memList;
    }
}
