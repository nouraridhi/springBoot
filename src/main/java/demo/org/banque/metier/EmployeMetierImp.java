package demo.org.banque.metier;

import java.util.List;

import demo.org.banque.dao.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.org.banque.entites.Employe;

@Service
public class EmployeMetierImp implements EmployeMetier {
	@Autowired
  private EmployeRepository employeRepository;
	@Override
	public Employe saveEmploye(Employe e) {
		// TODO Auto-generated method stub
		return employeRepository.save(e);
	}

	@Override
	public List<Employe> listemploye() {
		// TODO Auto-generated method stub
		return employeRepository.findAll();
	}

}
