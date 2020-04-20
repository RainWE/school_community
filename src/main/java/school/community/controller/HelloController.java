package school.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther:cdx
 * @Date:2020-04-20
 * @Description:school.community.controller
 * @Version:1.0
 */
@Controller
public class HelloController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

}
