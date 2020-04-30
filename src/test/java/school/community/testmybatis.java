package school.community;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import school.community.mapper.UserMapper;
import school.community.model.User;

/**
 * @Auther:cdx
 * @Date:2020-04-23
 * @Description:school.community
 * @Version:1.0
 */
public class testmybatis {

    @Autowired
    UserMapper userMapper;
    @Test
    public  void insert() {
        User user =new User();
        user.setToken("1");
        user.setName("1");
        user.setAccountId("1");
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModified(user.getGmtCreate());
        System.out.println(user.toString());
        userMapper.insert(user);
    }
}
