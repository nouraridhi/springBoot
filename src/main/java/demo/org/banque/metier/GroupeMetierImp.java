package demo.org.banque.metier;

import demo.org.banque.dao.GroupeRepository;
import demo.org.banque.metier.ClientMetier;
import demo.org.banque.metier.GroupeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.org.banque.entites.Groupe;

import java.util.List;

@Service
public class GroupeMetierImp implements GroupeMetier {
    @Autowired
    private GroupeRepository groupeRepository;
    @Override
    public Groupe saveGroupe(Groupe g) {

        return groupeRepository.save(g);
    }

    @Override
    public List<Groupe> listGroupe() {
        return groupeRepository.findAll();

    }

}
