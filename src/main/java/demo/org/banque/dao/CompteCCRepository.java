package demo.org.banque.dao;

import demo.org.banque.entites.CompteC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteCCRepository extends JpaRepository<CompteC,Long> {
}
