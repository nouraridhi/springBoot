package demo.org.banque.metier;

import java.util.Optional;

import demo.org.banque.entites.Compte;
import org.springframework.web.bind.annotation.PathVariable;

public interface CompteMetier {
	public Compte saveCompte( Compte cp );




	Optional<Compte> getCompte(Long codeCompte);


}
