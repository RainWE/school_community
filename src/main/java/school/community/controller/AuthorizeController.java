package school.community.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import school.community.dto.AccessTokenDTO;
import school.community.dto.GithubUser;
import school.community.prodiver.GithubProvider;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther:cdx
 * @Date:2020-04-22
 * @Description:school.community.controller
 * @Version:1.0
 */
@Controller
public class AuthorizeController {

    @Autowired
    GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @RequestMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletRequest request){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser =githubProvider.getUser(accessToken);
//      测试得到用户名
//        System.out.println(githubUser.getName());
        if(githubUser !=null){
            //登录成功，写cookie和session
            request.getSession().setAttribute("user", githubUser);
            return "redirect:/";
        }else {
            //登录失败，重新登录
            return "redirect:/";
        }
    }

}

