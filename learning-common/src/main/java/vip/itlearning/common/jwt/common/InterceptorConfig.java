package vip.itlearning.common.jwt.common;

import org.springframework.context.annotation.Configuration;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/v1/user/login");
    }
}
