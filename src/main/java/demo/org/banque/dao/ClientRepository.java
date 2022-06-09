package demo.org.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.org.banque.entites.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ClientRepository extends JpaRepository<Client,Long> {

}
