package demo.org.banque.contoller;

import demo.org.banque.dao.ClientRepository;
import demo.org.banque.dao.EmployeRepository;
import demo.org.banque.dao.GroupeRepository;
import demo.org.banque.entites.Client;
import demo.org.banque.entites.Employe;
import demo.org.banque.entites.Groupe;
import demo.org.banque.services.ClientRestService;
import demo.org.banque.services.EmployeRestService;
import demo.org.banque.services.GroupeRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class GroupeController {

    @Autowired
    private GroupeRepository gr;

    @Autowired
    private GroupeRestService grs;



    @GetMapping("/listeGroupe")
    public String show(Model model) {
        model.addAttribute("groupes",grs.listGroupe());
        return "groupe";
    }


    @RequestMapping("/ajouterGroupe")
    public String insertG(@ModelAttribute("groupes") Groupe g) {

        gr.save(g);
        return "ajouterGroupe";
    }


    @GetMapping("/deleteG/{codeGroupe}")
    public String deleteG(@PathVariable Long codeGroupe) {
        grs.removeGById(codeGroupe);
        return "redirect:/listeGroupe";
    }


    @GetMapping("/updateG/{codeGroupe}")
    public String updateG(@PathVariable Long codeGroupe, Model model) {
        Optional<Groupe> g =grs.getGById(codeGroupe);
        if (g.isPresent()) {
            model.addAttribute("groupes", g.get());
            return "ajouterGroupe";
        }
        return "redirect:/listeGroupe";
    }



}
