package vip.itlearning.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import vip.itlearning.common.enums.Status;

import java.util.Date;

/**
 * 用户传输bean
 *
 * @author stylefeng
 * @Date 2017/5/5 22:40
 */
@Getter
@Setter
public class UserDto {

    private Integer id;
    private String username;
    private String password;
    private String salt;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
//    private Integer sex;
//    private String email;
//    private String phone;
//    private String roleid;
    private Integer deptid;
    private Status status;
//    private Date createtime;
//    private Integer version;
//    private String avatar;

}
