package demo.org.banque.contoller;

import demo.org.banque.dao.RetraitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RetraitController {

    @Autowired
    RetraitRepository rr;


    @GetMapping("/getallroperations")
    public String showView(Model model) {

        model.addAttribute("operation", rr.findAll());

        return "getallroperations";

    }
}
