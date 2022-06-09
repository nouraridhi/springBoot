package demo.org.banque.dao;

import demo.org.banque.entites.Versement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersementRepository extends JpaRepository<Versement,Long> {
}
