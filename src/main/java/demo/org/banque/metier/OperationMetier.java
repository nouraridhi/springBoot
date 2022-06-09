package demo.org.banque.metier;



public interface OperationMetier {

    public PageOperation getOperations( String codeCompte, int page, int size );


    void verser(String codeCompte, double montant);

	void retirer(String codeCompte, double montant);

	boolean virement(String codeCpte1, String codeCpte2, double montant);
}
