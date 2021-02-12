package ex01;
import java.util.Date;

public class MemberVO {

    String id, pwd, name, email;
    Date joinDate;

    public MemberVO() {
        System.out.println("MemberVO 생성자 호출");
    }

    public MemberVO(String id, String pwd, String name, String email, Date joinDate) {
        this.id = id;
        this.pwd = pwd;
        this.email = email;
        this.name = name;
        this.joinDate = joinDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
}
