package demo.org.banque.metier;

import java.util.Date;


import demo.org.banque.dao.EmployeRepository;
import demo.org.banque.entites.Compte;
import demo.org.banque.entites.Retrait;
import demo.org.banque.entites.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OperationMetierImpl implements OperationMetier {
	@Autowired
 private demo.org.banque.dao.OperationRepository OperationRepository;
	@Autowired
 private demo.org.banque.dao.CompteRepository compteRepository;
	@Autowired
	 private EmployeRepository employeRepository;
	private Object Pageable;

	@Autowired
	private demo.org.banque.dao.OperationRepository or;
	/*
	@Override
	@Transactional
	public boolean verser(String code, double montant, Long codeEmp) {
		Compte cp=CompteRepository.findById(code).get();
		Employe e=employeRepository.findById(codeEmp).get();
	Operation o=new Versement();
	o.setDateOperation(new Date());
	o.setMontant(montant);
	o.setCompte(cp);
	o.setEmploye(e);
	OperationRepository.save(o);
	cp.setSolde(cp.getSolde()+montant);
	return true;
	}
	@Override
	@Transactional
	public boolean verser2(String code, double montant, Long codeEmp) {
		Compte cp=CompteRepository.findById(code).get();
		Employe e=employeRepository.findById(codeEmp).get();
	Operation o=new Versement();
	o.setDateOperation(new Date());
	o.setMontant(montant);
	o.setCompte(cp);
	o.setEmploye(e);
	OperationRepository.save(o);
	cp.setSolde(cp.getSolde()+montant);
	return true;
	}
	@Override
	@Transactional
	public boolean retirer(String code, double montant, Long codeEmp) {
		// TODO Auto-generated method stub
		Compte cp=CompteRepository.findById(code).get();
		Employe e=employeRepository.findById(codeEmp).get();
		
		
		
	Operation o=new Versement();
	o.setDateOperation(new Date());
	o.setMontant(montant);
	o.setCompte(cp);
	o.setEmploye(e);
	OperationRepository.save(o);
	cp.setSolde(cp.getSolde()-montant);
        
	
	return true;
        


	}

	@Override
	@Transactional
	public boolean virement(String cpte1, String cpte2, double montant, Long codeEmp) {

		retirer(cpte1,montant,codeEmp);
		verser(cpte2,montant,codeEmp);
		return true;
	}

	@Override
	public PageOperation getOperations(String codeCompte, int page, int size) {

		return null;
	}


	*/



	@Override
	public void verser(String codeCompte, double montant) {
		Compte cp = compteRepository.findById(codeCompte).get();
		Versement v = new Versement(new Date(), montant, cp);
		cp.setSolde(cp.getSolde()+montant);

		or.save(v);
	}

	@Override
	public void retirer(String codeCompte, double montant) {
		Compte compte = compteRepository.findById(codeCompte).get();
		if (compte == null) {
			throw new RuntimeException("Compte introuvable");
		}
		if (compte.getSolde() < montant)
			throw new RuntimeException("Solde insuffisant");

		Retrait v = new Retrait(new Date(), montant, compte);
		compte.setSolde(compte.getSolde()-montant);
		or.save(v);


	}

	@Override
	public boolean virement(String codeCpte1, String codeCpte2, double montant) {
		if (codeCpte1.equals(codeCpte2)) {
			throw new RuntimeException("Operation invalide: meme compte");
		}
		retirer(codeCpte1,montant);
		verser(codeCpte2,montant);
		return true;
	}







	@Override
	public PageOperation getOperations(String codeCompte, int page, int size) {
		return null;
	}


}
