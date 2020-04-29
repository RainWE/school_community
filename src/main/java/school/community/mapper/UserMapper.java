package school.community.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import school.community.model.User;

/**
 * @Auther:cdx
 * @Date:2020-04-23
 * @Description:school.community.mapper
 * @Version:1.0
 */
@Repository
@Mapper
public interface UserMapper {

    @Insert("insert into user (account_id,name,token,gmt_create,gmt_modified,avatar_url) values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("select * from user where token =#{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id =#{id}")
    User findById(@Param("id")Integer id);

    @Select("select * from user where account_id =#{accountId}")
    User findByAccountId(@Param("accountId")String accountId);

    @Update("Update user set name=#{name},token=#{token},gmt_modified=#{gmtModified},avatar_url=#{avatarUrl} where account_id =#{accountId}")
    void update(User dbUser);
}
