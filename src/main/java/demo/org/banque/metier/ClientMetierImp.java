package demo.org.banque.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.org.banque.entites.Client;

@Service
public class ClientMetierImp implements ClientMetier {
@Autowired
private demo.org.banque.dao.ClientRepository ClientRepository;
	@Override
	public Client saveClient(Client c) {
	
		return ClientRepository.save(c);
	}

	@Override
	public List<Client> listClient() {
		return ClientRepository.findAll();
		
	}

}
