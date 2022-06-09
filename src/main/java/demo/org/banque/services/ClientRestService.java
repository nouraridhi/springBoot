package demo.org.banque.services;

import java.util.List;
import java.util.Optional;

import demo.org.banque.dao.ClientRepository;
import demo.org.banque.entites.Client;
import demo.org.banque.entites.Employe;
import demo.org.banque.metier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientRestService {
@Autowired
private ClientMetier clientMetier;
@Autowired
private ClientRepository cr;

@RequestMapping(value="/clients",method=RequestMethod.POST)

public Client saveClient(@RequestBody Client c)
{
	return clientMetier.saveClient(c);
}

@RequestMapping(value="/clients",method=RequestMethod.GET)
public List<Client> listClient() {
	return clientMetier.listClient();
}



	public void removeClById(Long codeClient) {
		cr.deleteById(codeClient);
	}

	public Optional<Client> getClById(Long codeClient) {
		return cr.findById(codeClient);
	}
}
