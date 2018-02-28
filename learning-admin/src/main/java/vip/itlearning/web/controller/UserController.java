package vip.itlearning.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vip.itlearning.common.enums.Status;
import vip.itlearning.core.shiro.ShiroKit;
import vip.itlearning.core.tips.Tip;
import vip.itlearning.dto.UserConverter;
import vip.itlearning.dto.UserDto;
import vip.itlearning.exception.BizExceptionEnum;
import vip.itlearning.exception.ItlearningException;
import vip.itlearning.model.system.User;
import vip.itlearning.repository.system.UserRepository;
import vip.itlearning.web.base.BaseController;
import vip.itlearning.web.result.ListResult;
import vip.itlearning.web.result.PageResult;
import vip.itlearning.web.result.Result;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author yaw
 * @date 2018/1/23 16:47
 */
@RestController
@RequestMapping("/user/*")
public class UserController extends BaseController{

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

    /**
     * 添加管理员
     */
    @RequestMapping("/add")
//    @BussinessLog(value = "添加管理员", key = "account", dict = UserDict.class)
//    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Tip add(@Valid UserDto user, BindingResult result) {
        if (result.hasErrors()) {
            throw new ItlearningException(BizExceptionEnum.REQUEST_NULL);
        }

        // 判断账号是否重复
        User theUser = userRepo.findByUsername(user.getUsername());
        if (theUser != null) {
            throw new ItlearningException(BizExceptionEnum.USER_ALREADY_REG);
        }

        // 完善账号信息
        user.setSalt(ShiroKit.getRandomSalt(5));
        user.setPassword(ShiroKit.md5(user.getPassword(), user.getSalt()));
        user.setStatus(Status.OK);
        user.setCreatetime(new Date());

        this.userRepo.save(UserConverter.createUser(user));
        return SUCCESS_TIP;
    }
}
