package school.community.dto;

import lombok.Data;

/**
 * Created by codedrinker on 2019/6/26.
 * 上传文件对象
 */
@Data
public class FileDTO {
    private int success;
    private String message;
    private String url;
}
