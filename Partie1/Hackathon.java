package Etape1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hackathon {
    private String nom;
    private LocalDate  date;
    private Ville ville;
    private List<Equipe> equipes = new ArrayList<>();

    public Hackathon(String nom, LocalDate date, Ville ville, List<Equipe> equipes) {
        this.nom = nom;
        this.date = date;
        this.ville = ville;
        this.equipes = equipes;
    }

    public Hackathon(String nom, LocalDate date, Ville ville) {
        this.nom = nom;
        this.date = date;
        this.ville = ville;
    }

    public Hackathon(String nom, LocalDate date) {
        this.nom = nom;
        this.date = date;
    }

    public Hackathon(String nom) {
        this.nom = nom;
    }


    public String getNom() {
        return nom;
    }

    public LocalDate getDate() {
        return date;
    }

    public Ville getVille() {
        return ville;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    public void addEquipe(Equipe equipe) {
        this.equipes.add(equipe);
    }

    public void removeEquipe(Equipe equipe) {
        this.equipes.remove(equipe);
    }


    @Override
    public String toString() {
        return "Hackathon{" +
                "nom='" + nom + '\'' +
                ", date=" + date +
                ", ville=" + ville +
                ", equipes=" + equipes +
                '}';
    }

    // Méthode pour afficher les informations du hackathon
    public void afficherInfos() {
        System.out.println("Hackathon: " + this.nom + ", Ville: " + this.ville);
        System.out.println("Équipes:");
        for (Equipe equipe : this.equipes) {
            System.out.println("  - " + equipe.getNomEquipe());
            for (Etudiant etudiant : equipe.getEtudiants()) {
                System.out.println("    * " + etudiant.getCne() + ", Université: " + etudiant.getUniversite());
            }
        }    

}
}
