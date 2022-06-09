package demo.org.banque.contoller;

import demo.org.banque.dao.EmployeRepository;
import demo.org.banque.entites.Client;
import demo.org.banque.entites.Employe;
import demo.org.banque.services.EmployeRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class EmployesController {
    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private EmployeRestService ers;

    @GetMapping("/index")
    public String show() {

        return "index";
    }

    @GetMapping("/listeEmployee")
    public String showView(Model model) {
        model.addAttribute("employe",ers.listemploye());
        return "employes";
    }


    @RequestMapping("/ajouterEmp")
    public String insertemp(@ModelAttribute("employe") Employe e) {

        employeRepository.save(e);
        return "ajouterEmploye";
    }



    @GetMapping("/deleteEmp/{codeEmploye}")
    public String deleteemp(@PathVariable Long codeEmploye) {
        ers.removeEmpById(codeEmploye);
        return "redirect:/listeEmployee";
    }


    @GetMapping("/updateEmp/{codeEmploye}")
    public String updateEmp(@PathVariable Long codeEmploye, Model model) {
        Optional<Employe> e =ers.getEmpById(codeEmploye);
        if (e.isPresent()) {
            model.addAttribute("employe", e.get());
            return "ajouterEmploye";
        }
        return "redirect:/listeEmployee";
    }
}
