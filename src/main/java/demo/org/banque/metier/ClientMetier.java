package demo.org.banque.metier;


import java.util.List;

import demo.org.banque.entites.Client;
public interface ClientMetier {
	public Client saveClient(Client c);
    public List <Client> listClient();
}
