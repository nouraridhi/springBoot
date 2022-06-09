package demo.org.banque.services;


import demo.org.banque.dao.CompteRepository;
import demo.org.banque.dao.OperationRepository;
import demo.org.banque.entites.Client;
import demo.org.banque.metier.CompteMetier;
import demo.org.banque.metier.CompteMetierIMpl;
import demo.org.banque.metier.OperationMetier;
import demo.org.banque.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class BanqueService {
	  @Autowired
	    private CompteMetier compteMetier;
	    
	    @Autowired
	    private OperationMetier operationMetier;

		@Autowired
		private OperationRepository or;
	    
	   


	    public PageOperation getOperations(@Param("codeCompte")Long codeCompte,
										   @Param("page")int page,
										   @Param("size")int size ) {
	        return operationMetier.getOperations(String.valueOf(codeCompte), page, size );
	    }


}
