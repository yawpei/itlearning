package vip.itlearning.dto;

import org.springframework.beans.BeanUtils;
import vip.itlearning.model.system.User;

/**
 * @description 用户转换
 * @author: yaw
 * @date: 2018/2/28
 **/
public class UserConverter {
    public static User createUser(UserDto userDto){
        if(userDto == null){
            return null;
        }else{
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            return user;
        }
    }
}
