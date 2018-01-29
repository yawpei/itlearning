package vip.itlearning.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import vip.itlearning.model.system.User;
import vip.itlearning.repository.system.UserRepository;
import vip.itlearning.web.result.ListResult;
import vip.itlearning.web.result.PageResult;
import vip.itlearning.web.result.Result;

import javax.validation.constraints.NotNull;
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
    public ListResult<User> getAllUser(){
        List<User> users = userRepo.findAll();
        return ListResult.success(users);
    }

    @RequestMapping("page/users")
    public PageResult<User> getUsersByPageable(@RequestParam("username") String username, Pageable pageable){
        Page<User> users = userRepo.findAllByUsernameLike(username,pageable);
        return PageResult.success(users);
    }

    @PostMapping("create")
    public Result<Void> createUser(@RequestBody @NotNull User user){
        User user1 = userRepo.save(user);
        Result<Void> result = new Result<>();
        return Result.success();
    }
}
