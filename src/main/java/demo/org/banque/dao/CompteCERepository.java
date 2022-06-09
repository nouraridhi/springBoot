package demo.org.banque.dao;

import demo.org.banque.entites.CompteE;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompteCERepository extends JpaRepository<CompteE,Long> {
}
