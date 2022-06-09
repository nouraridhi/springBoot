package demo.org.banque.metier;

import java.util.Date;
import java.util.Optional;

import demo.org.banque.dao.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.org.banque.entites.Compte;


@Service
	public class CompteMetierIMpl implements CompteMetier{
		@Autowired
		private CompteRepository compteRepository;
		@Override
		public Compte saveCompte(Compte cp) {
			// TODO Auto-generated method stub
			cp.setDateCreation(new Date());
			return compteRepository.save(cp);
		}




	@Override
	public Optional<Compte> getCompte(Long codeCompte) {
		return compteRepository.findById(String.valueOf(codeCompte));
	}


}
