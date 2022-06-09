package demo.org.banque.metier;

import java.util.List;
import java.util.Optional;

import demo.org.banque.entites.Client;
import demo.org.banque.entites.Groupe;

public interface GroupeMetier {

    public Groupe saveGroupe(Groupe g);
    public List<Groupe> listGroupe();
}
