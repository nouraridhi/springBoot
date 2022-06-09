package demo.org.banque.entites;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Date;
import java.util.Collection;

@Data
@Entity
@DiscriminatorValue("CE")
public class CompteE extends Compte{

	public CompteE() {
		super();

	}

	public CompteE(Long numCompte, Date dateCreation, double solde, Collection<Operation> operations, Client client,
				   Employe emp) {
		super(numCompte, dateCreation, solde, operations, client, emp);

	}

	public double getTaux() {
		return Taux;
	}

	public void setTaux(double taux) {
		Taux = taux;
	}

	private double Taux;
}