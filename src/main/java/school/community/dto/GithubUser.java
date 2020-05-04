package school.community.dto;

import lombok.Data;

/**
 * @Auther:cdx
 * @Date:2020-04-22
 * @Description:school.community.dto
 * @Version:1.0
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
