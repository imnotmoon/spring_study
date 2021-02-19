package com.spring.member.dao;
import com.spring.member.vo.MemberVO;
import org.springframework.jdbc.core.*;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List selectAllMembers() {
        String query = "select id, pwd, name, email, joinDate from t_member order by joinDate desc";
        List membersList = new ArrayList();
        membersList = this.jdbcTemplate.query(query, (org.springframework.jdbc.core.RowMapper) (rs, rowNum) -> {
            MemberVO memberVO = new MemberVO();
            memberVO.setId(rs.getString("id"));
            memberVO.setPwd(rs.getString("pwd"));
            memberVO.setName(rs.getString("name"));
            memberVO.setEmail(rs.getString("email"));
            memberVO.setJoinDate(rs.getDate("joinDate"));
            return memberVO;
        });
        return membersList;
    }

    @Override
    public int addMembers(MemberVO memberVO) throws Exception {
        String id = memberVO.getId();
        String pwd = memberVO.getPwd();
        String name = memberVO.getName();
        String email = memberVO.getEmail();
        String query = "insert int t_member(id, pwd, name, email) values ('" + id + "', " + "'" + pwd + "', " + "'" + name + "', " + "'" + email + "')";
        System.out.println(query);
        int result = jdbcTemplate.update(query);
        System.out.println(result);
        return result;
    }
}
