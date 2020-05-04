package school.community.dto;

import lombok.Data;

/**
 * @Auther:cdx
 * @Date:2020-04-22
 * @Description:school.community.dto
 * @Version:1.0
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
