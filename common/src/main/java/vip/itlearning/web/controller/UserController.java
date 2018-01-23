package vip.itlearning.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.itlearning.dto.result.ListResultDTO;
import vip.itlearning.dto.result.ResultDTO;
import vip.itlearning.dto.system.UserDTO;
import vip.itlearning.model.system.User;
import vip.itlearning.repository.system.UserRepository;

import java.util.List;

/**
 * @author yaw
 * @date 2018/1/23 16:47
 */
@RestController
@RequestMapping("/user/*")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @RequestMapping("getAll")
    public ListResultDTO<UserDTO> getAllUser(){
        List<User> users = userRepo.findAll();
//        ListResultDTO.success()
        return null;
    }
}
