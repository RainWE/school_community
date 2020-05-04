package school.community.dto;

import lombok.Data;
import school.community.model.User;

/**
 * @Auther:cdx
 * @Date:2020-04-30
 * @Description:school.community.dto
 * @Version:1.0
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private Integer commentCount;
    private String content;
    private User user;
}
