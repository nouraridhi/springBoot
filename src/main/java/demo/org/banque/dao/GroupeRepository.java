package demo.org.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.org.banque.entites.Groupe;

public interface GroupeRepository extends JpaRepository <Groupe,Long>{

}
