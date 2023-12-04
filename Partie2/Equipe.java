import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private String nomEquipe;
    private Hackathon hackathon; // Référence au Hackathon
    private List<Etudiant> etudiants; // Liste des étudiants dans l'équipe

    // Constructeur principal
    public Equipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
        this.etudiants = new ArrayList<>(); // Initialiser la liste des étudiants
    }

    // Constructeur avec une liste d'étudiants (crée une copie de la liste pour éviter les modifications externes)
    public Equipe(String nomEquipe, List<Etudiant> etudiants) {
        this(nomEquipe);
        this.etudiants = new ArrayList<>(etudiants);
    }

    // Getters et setters
    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public List<Etudiant> getEtudiants() {
        return new ArrayList<>(etudiants); // Retourne une copie pour la sécurité
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = new ArrayList<>(etudiants); // Utilise une copie pour éviter la modification externe
    }

    public int getNombreEtudiants() {
        return etudiants.size(); // Retourne la taille actuelle de la liste
    }

    // Méthode pour ajouter un étudiant à l'équipe
    public void addEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
    }

    // Méthode pour retirer un étudiant de l'équipe
    public void removeEtudiant(Etudiant etudiant) {
        etudiants.remove(etudiant);
    }

    // Affiche les étudiants de l'équipe
    public void afficherEtudiants() {
        for (Etudiant etudiant : etudiants) {
            System.out.println(etudiant);
        }
    }

    // Méthode toString pour afficher les informations de l'équipe
    @Override
    public String toString() {
        return "Equipe{" +
                "nomEquipe='" + nomEquipe + '\'' +
                ", etudiants=" + etudiants +
                '}';
    }

    // Getters et setters pour le hackathon
    public Hackathon getHackathon() {
        return hackathon;
    }

    public void setHackathon(Hackathon hackathon) {
        this.hackathon = hackathon;
    }
}
