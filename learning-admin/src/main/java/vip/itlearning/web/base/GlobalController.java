package vip.itlearning.web.base;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 全局的控制器
 * @Author: yaw
 * @Date: 2018/2/7
 **/
@Controller
@RequestMapping("/global")
public class GlobalController {

    /**
     * 跳转到404页面
     *
     * @author yaw
     */
    @RequestMapping(path = "/error")
    public String errorPage() {
        return "/404.html";
    }

    /**
     * 跳转到session超时页面
     *
     * @author yaw
     */
    @RequestMapping(path = "/sessionError")
    public String errorPageInfo(Model model) {
        model.addAttribute("tips", "session超时");
        return "/login.html";
    }
}
