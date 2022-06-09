package demo.org.banque.metier;


import java.util.List;
import demo.org.banque.entites.Employe;
public interface EmployeMetier {
	public Employe saveEmploye(Employe e);
	public List <Employe>listemploye();

}
