package vip.itlearning.common.jwt.service;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private GetInformationFromJWT getInformationFromJWT;

    public String getSaltByAccount(LoginDTO loginDTO) {
        QueryWrapper<MeyerUser> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(MeyerUser::getAccount,loginDTO.getAccount());
        return this.userMapper.selectOne(wrapper).getSalt();
    }

    public String getPasswordByAccount(LoginDTO loginDTO) {
        QueryWrapper<MeyerUser> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(MeyerUser::getAccount,loginDTO.getAccount());
        return this.userMapper.selectOne(wrapper).getPassword();
    }

    public LoginVO getUserMsg(LoginDTO loginDTO) {
        QueryWrapper<MeyerUser> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(MeyerUser::getAccount,loginDTO.getAccount());
        MeyerUser meyerUser = this.userMapper.selectOne(wrapper);
        String token = this.getToken(meyerUser);

        LoginVO loginVO = new LoginVO();
        loginVO.setToken(token);
        BeanUtils.copyProperties(meyerUser,loginVO);
        return loginVO;
    }

    public String getToken(MeyerUser meyerUser) {
        Map<String,String> payload = new HashMap<>();
        payload.put("userId", meyerUser.getId()+"");
        payload.put("username", meyerUser.getUsername());
        payload.put("account", meyerUser.getAccount());
        return JWTUtils.getToken(payload);
    }
    
    public String getUsernameByJWT(HttpServletRequest request) {
        return this.getInformationFromJWT.getUsernameByJWT(request);
    }
}
