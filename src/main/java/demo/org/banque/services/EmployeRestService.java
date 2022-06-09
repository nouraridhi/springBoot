package demo.org.banque.services;

import java.util.List;
import java.util.Optional;

import demo.org.banque.dao.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import demo.org.banque.entites.Employe;
import demo.org.banque.metier.EmployeMetier;



@RestController


public class EmployeRestService {
	@Autowired
private EmployeMetier employeMetier;
	@Autowired
	private EmployeRepository er;


	@PostMapping
	public Employe saveEmploye(@RequestBody Employe e) {
		return employeMetier.saveEmploye(e);
	}

	@GetMapping
	public List<Employe> listemploye() {
		return employeMetier.listemploye();
	}


	public void removeEmpById(Long codeEmploye) {
		er.deleteById(codeEmploye);
	}

	public Optional<Employe> getEmpById(Long codeEmploye) {
		return er.findById(codeEmploye);
	}
}


