package school.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import school.community.dto.PaginationDTO;
import school.community.service.QuestionService;

/**
 * @Auther:cdx
 * @Date:2020-04-20
 * @Description:school.community.controller
 * @Version:1.0
 */
@Controller
public class IndexController {


    @Autowired
    private QuestionService questionService;


    @GetMapping("/")
    public String index(Model model
            , @RequestParam(name ="page",defaultValue = "1") Integer page
            ,@RequestParam(name ="size",defaultValue = "5") Integer size) {


        PaginationDTO pagination = questionService.list(page,size);
        model.addAttribute("pagination", pagination);
        return "index";
    }

}
