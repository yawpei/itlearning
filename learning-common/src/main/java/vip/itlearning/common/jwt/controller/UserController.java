package vip.itlearning.common.jwt.controller;

@RestController
@RequestMapping("/v1/user")
@Validated
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;


    @PostMapping("/login")
    public ApiResponse login(@RequestBody @Validated LoginDTO loginDTO) {
        String salt = this.userService.getSaltByAccount(loginDTO);
        String password = new SimpleHash("MD5",loginDTO.getPassword(),salt,1).toHex();
        String realPassword = this.userService.getPasswordByAccount(loginDTO);
        if(StringUtils.isEmpty(realPassword)){
            return new ApiResponse(400,"用户名错误",0);
        } else if (!realPassword.equals(password)) {
            return new ApiResponse(400, "密码错误", 0);
        } else {
            LoginVO loginVO = this.userService.getUserMsg(loginDTO);
            return new ApiResponse(200,"success",loginVO);
        }
    }
    
    @GetMapping("/test")
    public ApiResponse test(HttpServletRequest request) {
        String username = this.userService.getUsernameByJWT(request);
        return new ApiResponse(200,"success",username);
    }
}
