package school.community.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import school.community.mapper.UserMapper;
import school.community.model.User;
import school.community.model.UserExample;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Auther:cdx
 * @Date:2020-04-28
 * @Description:school.community.interceptor
 * @Version:1.0
 */
@Component
public class SessionInterceptor implements HandlerInterceptor {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0)
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();

                    UserExample userExample =new UserExample();
                    userExample.createCriteria().andTokenEqualTo(token);
                    List<User> users = userMapper.selectByExample(userExample);

                    if (users.size() != 0) {
                        request.getSession().setAttribute("user", users.get(0));
                    }
                    break;
                }
            }
        return true;
    }

}
