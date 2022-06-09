package demo.org.banque.dao;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import demo.org.banque.entites.Operation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OperationRepository extends JpaRepository <Operation,Long>{


    List<Operation> findByNumeroOperation(@Param("numeroOperation") Long numeroOeration);

    List<Operation> findByDateOperation(@Param("dateCreation") java.util.Date dateCreation);





}
