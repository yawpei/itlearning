package vip.itlearning.common.jwt.dto;

@Data
@NoArgsConstructor
public class LoginDTO {
    @NotBlank(message = "用户名不能为空")
    private String account;
    @NotBlank(message = "密码不能为空")
    private String password;
}
