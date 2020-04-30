package school.community.dto;

import lombok.Data;

/**
 * @Auther:cdx
 * @Date:2020-04-30
 * @Description:school.community.dto
 * @Version:1.0
 */
@Data
public class CommentDTO {

    private Long parentId;
    private String content;
    private Integer type;
}
