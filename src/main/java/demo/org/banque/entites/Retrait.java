package demo.org.banque.entites;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity
@DiscriminatorValue("R")
@NoArgsConstructor
public class Retrait extends Operation{

    public Retrait(Date date, double montant, Compte compte) {
    }
}
