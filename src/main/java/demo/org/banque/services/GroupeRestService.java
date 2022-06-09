package demo.org.banque.services;

import java.util.List;
import java.util.Optional;

import demo.org.banque.dao.GroupeRepository;
import demo.org.banque.entites.Client;
import demo.org.banque.entites.Groupe;
import demo.org.banque.metier.GroupeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GroupeRestService {
    @Autowired
    private GroupeMetier groupeMetier;
    @Autowired
    private GroupeRepository gr;

    @RequestMapping(value="/groupes",method=RequestMethod.POST)

    public Groupe saveGroupe(@RequestBody Groupe g)
    {
        return groupeMetier.saveGroupe(g);
    }

    @RequestMapping(value="/groupes",method=RequestMethod.GET)
    public List<Groupe> listGroupe() {
        return groupeMetier.listGroupe();
    }



    public void removeGById(Long codeGroupe) {
        gr.deleteById(codeGroupe);
    }

    public Optional<Groupe> getGById(Long codeGroupe) {
        return gr.findById(codeGroupe);
    }
}
