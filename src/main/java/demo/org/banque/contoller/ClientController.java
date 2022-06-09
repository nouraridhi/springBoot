package demo.org.banque.contoller;

import demo.org.banque.dao.ClientRepository;
import demo.org.banque.dao.EmployeRepository;
import demo.org.banque.entites.Client;
import demo.org.banque.entites.Employe;
import demo.org.banque.services.ClientRestService;
import demo.org.banque.services.EmployeRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientRestService crs;



    @GetMapping("/listeClient")
    public String show(Model model) {
        model.addAttribute("client",crs.listClient());
        return "client";
    }


    @RequestMapping("/ajoutercl")
    public String insertcl(@ModelAttribute("client") Client c) {

        clientRepository.save(c);
        return "ajouterClient";
    }


    @GetMapping("/deleteCl/{codeClient}")
    public String deleteCl(@PathVariable Long codeClient) {
        crs.removeClById(codeClient);
        return "redirect:/listeClient";
    }


    @GetMapping("/updateCl/{codeClient}")
    public String updatecl(@PathVariable Long codeClient, Model model) {
        Optional<Client> c =crs.getClById(codeClient);
        if (c.isPresent()) {
            model.addAttribute("client", c.get());
            return "ajouterClient";
        }
        return "redirect:/listeClient";
    }



}
