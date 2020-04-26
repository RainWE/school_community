package school.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import school.community.dto.PaginationDTO;
import school.community.dto.QuestionDTO;
import school.community.mapper.QuestionMapper;
import school.community.mapper.UserMapper;
import school.community.model.Question;
import school.community.model.User;
import school.community.service.QuestionService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther:cdx
 * @Date:2020-04-20
 * @Description:school.community.controller
 * @Version:1.0
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;


    @GetMapping("/")
    public String index(HttpServletRequest request
            , Model model
            , @RequestParam(name ="page",defaultValue = "1") Integer page
            ,@RequestParam(name ="size",defaultValue = "5") Integer size) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0)
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }

        PaginationDTO pagination = questionService.list(page,size);
        model.addAttribute("pagination", pagination);
        return "index";
    }

}
