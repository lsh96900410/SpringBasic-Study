package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringMemberFormController {

    @RequestMapping("/springmvc/v1/members/newForm")
    public ModelAndView process(){
        return new ModelAndView("newForm");
    }
}
