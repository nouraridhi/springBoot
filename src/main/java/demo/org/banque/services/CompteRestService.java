package demo.org.banque.services;

import java.util.Optional;

import demo.org.banque.metier.OperationMetierImpl;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import demo.org.banque.entites.Compte;
import demo.org.banque.metier.CompteMetier;

@RestController

public class CompteRestService {
	@Autowired
	private CompteMetier compteMetier;
	@Autowired
	private OperationMetierImpl omi;




	@RequestMapping(value="/versement",method=RequestMethod.PUT)
	public void verser(@RequestParam String codeCompte, @RequestParam double montant)
	{
		omi.verser(codeCompte, montant);
	}

	@RequestMapping(value="/retrait",method=RequestMethod.POST)
	public void retirer(@RequestParam String codeCompte,@RequestParam double montant)
	{
		omi.retirer(codeCompte, montant);
	}


	@RequestMapping(value="/virement",method=RequestMethod.POST)
	public boolean virement(@RequestParam String codeCompte1, @RequestParam String codeCompte2, @RequestParam double montant)
	{
		return omi.virement(codeCompte1, codeCompte2, montant);
	}


}
