import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private String nom;
    private List<Etudiant> membres = new ArrayList<>();
    private Discours presentation;

    public Equipe(String nom) {
        this.nom = nom;
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        membres.add(etudiant);
        etudiant.setEquipe(this);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Etudiant> getMembres() {
        return membres;
    }

    public void setMembres(List<Etudiant> membres) {
        this.membres = membres;
    }

    public Discours getPresentation() {
        return presentation;
    }

    public void setPresentation(Discours presentation) {
        this.presentation = presentation;
    }
}
