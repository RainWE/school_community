package school.community.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import school.community.dto.QuestionDTO;
import school.community.model.Question;

import java.util.List;

/**
 * @Auther:cdx
 * @Date:2020-04-24
 * @Description:school.community.mapper
 * @Version:1.0
 */
@Repository
@Mapper
public interface QuestionMapper {

    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    public void create(Question question);

    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param("offset") Integer offset,@Param("size") Integer size);

    @Select("select count(1) from question")
    Integer count();

    @Select("select * from question where creator=#{userId} limit #{offset},#{size}")
    List<Question> listByUserId(@Param("userId") Integer userId, @Param("offset") Integer offset,@Param("size") Integer size);

    @Select("select count(1) from question where creator=#{userId}")
    Integer countByUserId(@Param("userId") Integer userId);

    @Select("select * from question where id=#{id}")
    Question getById(@Param("id")Integer id);

    @Update("update question set title = #{title},description=#{description},gmt_modified=#{gmtModified},tag=#{tag} where id=#{id}")
    void update(Question question);
}
