package school.community.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * @Auther:cdx
 * @Date:2020-04-28
 * @Description:school.community.interceptor
 * @Version:1.0
 */
@Configuration
//@EnableWebMvc  //开启配置默认配置失效
public class WebConfig {

    @Autowired
    private SessionInterceptor sessionInterceptor;

    public void addInterceptors(InterceptorRegistry registration){
        registration.addInterceptor(sessionInterceptor).addPathPatterns("/**");
    }

}
