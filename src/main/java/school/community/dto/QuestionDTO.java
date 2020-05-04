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
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
