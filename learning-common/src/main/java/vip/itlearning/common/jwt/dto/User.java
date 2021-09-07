package vip.itlearning.common.jwt.dto;

@Data
@Accessors(chain = true)
public class User {
    @TableId(type = IdType.AUTO)
    private int id;
    private String username;
    private String account;
    private String password;
    private String salt;
    private String staffNo;
    private String nickname;
    private String avatar;
    @JsonIgnore
    private Date createTime;
    @JsonIgnore
    private Date updateTime;
    @JsonIgnore
    @TableLogic
    private Date deleteTime;
}
