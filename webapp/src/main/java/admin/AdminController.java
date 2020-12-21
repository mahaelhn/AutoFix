package admin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Admin")
public class AdminController {


    @RequestMapping
    public String admin(){
        return "Admin";
    }


}