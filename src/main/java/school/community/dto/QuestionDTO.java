package school.community.dto;

import lombok.Data;
import school.community.model.User;

/**
 * @Auther:cdx
 * @Date:2020-04-25
 * @Description:school.community.dto
 * @Version:1.0
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String tag;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private User user;
}
