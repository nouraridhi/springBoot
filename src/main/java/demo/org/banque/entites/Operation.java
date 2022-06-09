package demo.org.banque.entites;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Data

@Entity
public class Operation implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long    numeroOperation;
    private Date    dateOperation;
    private double  montant;

    // Associations
    @ManyToOne
    @JoinColumn( name = "CODE_CPTE" )
    private Compte  compte;
    @ManyToOne
    @JoinColumn( name = "CODE_EMP" )
    private Employe employe;

    // constructeurs
    public Operation() {
        super();
    }

    public Operation( Date dateOperation, double montant ) {
        super();
        this.dateOperation = dateOperation;
        this.montant = montant;
    }

    public Long getNumeroOperation() {
        return numeroOperation;
    }

    public void setNumeroOperation( Long numeroOperation ) {
        this.numeroOperation = numeroOperation;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation( Date dateOperation ) {
        this.dateOperation = dateOperation;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant( double montant ) {
        this.montant = montant;
    }


    public Compte getCompte() {
        return compte;
    }

    public void setCompte( Compte compte ) {
        this.compte = compte;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye( Employe employe ) {
        this.employe = employe;
    }

}
