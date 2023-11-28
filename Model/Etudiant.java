public class Etudiant extends Personne {
    private String universite;
    private String competence;
    private Equipe equipe;

    public Etudiant(String nom, String contact, String universite, String competence) {
        super(nom, contact);
        this.universite = universite;
        this.competence = competence;
    }

    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}

