package Etape1;

public class Etudiant extends Personne {
    
    private String cne;
    private Equipe equipe;

    public Etudiant(String nom, String prenom, String cne) {
        super(nom, prenom);
        this.cne = cne;
    }
    
    public Etudiant(String nom, String prenom, String cne,  Equipe equipe) {
        super(nom, prenom);
        this.cne = cne;
        this.equipe = equipe;
    }

    //getters andd setters
    public String getCne() {
        return cne;
    }   

    public void setCne(String cne) {
        this.cne = cne;
    }
    
    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

} 



    
