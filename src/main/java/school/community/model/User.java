package school.community.model;

import lombok.Data;

/**
 * @Auther:cdx
 * @Date:2020-04-23
 * @Description:school.community.model
 * @Version:1.0
 */
@Data
public class User {

    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;

}
