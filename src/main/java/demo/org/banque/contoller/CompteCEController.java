package demo.org.banque.contoller;

import demo.org.banque.dao.ClientRepository;
import demo.org.banque.dao.CompteCERepository;
import demo.org.banque.dao.EmployeRepository;
import demo.org.banque.entites.Client;
import demo.org.banque.entites.CompteE;
import demo.org.banque.entites.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CompteCEController {


    @Autowired
    CompteCERepository ce;

    @Autowired
    EmployeRepository er;


    @Autowired
    ClientRepository c;


    @GetMapping("/getallaccountse")
    public String showView(Model model) {

        model.addAttribute("compteE",ce.findAll()) ;

        return  "getallaccountse" ;

    }




    @RequestMapping("/Addaccounte") public String AjouterNouveauCompteE(Model model) {


        List<Client> clist = c.findAll();
        List<Employe> elist = er.findAll();

        model.addAttribute("client",clist);
        model.addAttribute("employe",elist);


        return "Addaccounte" ; }



    @PostMapping("/saveaccounte")
    public String saveaccountc(@ModelAttribute CompteE accounte , Model model)

    { ce.save(accounte);
        return "redirect:/Addaccounte";
    }

    @GetMapping("/deleteae/{Code}") public String deleteclient(@PathVariable Long Code)

    {
        ce.deleteById(Code); return "redirect:/getallaccountse";
    }

}

