package demo.org.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.org.banque.entites.Employe;

public interface EmployeRepository extends JpaRepository<Employe,Long> {
	

}
