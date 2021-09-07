package vip.itlearning.common.jwt.common;

public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求头中令牌
        ApiResponse apiResponse = null;
        String token = request.getHeader("token");
        try {
            JWTUtils.verify(token);
            return true;
        }catch (SignatureVerificationException e){
            apiResponse = new ApiResponse(505,"无效签名",false);
        }catch (TokenExpiredException e){
            apiResponse = new ApiResponse(505,"token过期",false);
        }catch (AlgorithmMismatchException e){
            apiResponse = new ApiResponse(505,"token算法不一致",false);
        }catch (Exception e){
            apiResponse = new ApiResponse(505,"token无效",false);
        }
        String json = new ObjectMapper().writeValueAsString(apiResponse);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }
}
