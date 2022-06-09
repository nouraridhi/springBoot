package demo.org.banque.entites;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity
@DiscriminatorValue("V")
public class Versement extends Operation {


    public Versement(Date date, double montant, Compte cp) {
    }
}