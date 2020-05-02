package school.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import school.community.dto.QuestionDTO;
import school.community.service.QuestionService;

/**
 * @Auther:cdx
 * @Date:2020-04-28
 * @Description:school.community.controller
 * @Version:1.0
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @GetMapping("/question/{id}")
    public  String question(@PathVariable(name="id") Long id, Model model){

        QuestionDTO questionDTO=questionService.getById(id);
        //累加阅读数
        questionService.incView(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}

