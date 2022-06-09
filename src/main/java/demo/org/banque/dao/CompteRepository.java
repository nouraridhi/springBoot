package demo.org.banque.dao;

import demo.org.banque.entites.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import demo.org.banque.entites.Compte;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompteRepository extends JpaRepository<Compte, String>{


    List<Compte> findBycodeCompte(@Param("codeCompte") Long codeCompte);



    List<Compte> findByDateCreation(@Param("dateCreation") java.util.Date dateCreation);






}
