package demo.org.banque.dao;

import demo.org.banque.entites.Retrait;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetraitRepository extends JpaRepository<Retrait, Long > {
}
