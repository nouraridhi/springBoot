package demo.org.banque.contoller;

import demo.org.banque.dao.*;
import demo.org.banque.entites.*;
import demo.org.banque.metier.CompteMetier;
import demo.org.banque.metier.OperationMetierImpl;
import demo.org.banque.services.CompteRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CompteCCController {

    @Autowired
    private CompteMetier cm;

    @Autowired
    private CompteRepository cr;

    @Autowired
    private ClientRepository c;
    @Autowired
    private EmployeRepository er;

    @Autowired
    private CompteCCRepository cc;

    @Autowired
    private CompteRestService crs;

    @Autowired
    private OperationMetierImpl omi;


        @GetMapping("/getallaccountsc")
        public String showView(Model model) {

            model.addAttribute("compteC",cc.findAll()) ;

            return  "getallaccountsc" ;

        }

        @RequestMapping("/Addaccountc")
        public String ajouterNouveauCompteC(Model model) {


            List<Client> clist = c.findAll();
            List<Employe> elist = er.findAll();

            model.addAttribute("client",clist);
            model.addAttribute("employe",elist);


            return "Addaccountc" ; }



        @PostMapping("/saveaccountc")
        public String saveaccountc(@ModelAttribute CompteC accountc , Model model)
        { cc.save(accountc);
            return "redirect:/Addaccountc"; }

        @GetMapping("/deleteac/{Code}")
        public String deleteaccountc(@PathVariable Long Code) {
            cc.deleteById(Code); return "redirect:/getallaccountsc"; }


    }
