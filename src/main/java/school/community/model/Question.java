package school.community.model;

import lombok.Data;

/**
 * @Auther:cdx
 * @Date:2020-04-24
 * @Description:school.community.model
 * @Version:1.0
 */
@Data
public class Question {
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


}