import java.util.Scanner;

public class EtudiantController {
    private Scanner scanner;
    private Hackathon hackathon; // Supposons que vous avez un objet Hackathon disponible

    public EtudiantController(Scanner scanner, Hackathon hackathon) {
        this.scanner = scanner;
        this.hackathon = hackathon;
    }

    public void afficherMenu() {
        boolean retour = false;
        while (!retour) {
            System.out.println("\nSous-Menu Étudiant:");
            System.out.println("1. Créer un étudiant");
            System.out.println("2. Assigner un étudiant à une équipe");
            System.out.println("3. Mettre à jour les détails d'un étudiant");
            System.out.println("4. Afficher les informations d'un étudiant");
            System.out.println("5. Retour");

            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    creerEtudiant();
                    break;
                case 2:
                    assignerEtudiantAEquipe();
                    break;
                case 3:
                    mettreAJourEtudiant();
                    break;
                case 4:
                    afficherInformationsEtudiant();
                    break;
                case 5:
                    retour = true;
                    break;
                default:
                    System.out.println("Option non valide, veuillez réessayer.");
            }
        }
    }

    private void creerEtudiant() {
        scanner.nextLine(); // Consomme la ligne restante
        System.out.print("Entrez le nom de l'étudiant: ");
        String nom = scanner.nextLine();
        System.out.print("Entrez le prénom de l'étudiant: ");
        String prenom = scanner.nextLine();
        System.out.print("Entrez le matricule de l'étudiant: ");
        String matricule = scanner.nextLine();

        Etudiant etudiant = new Etudiant(nom, prenom, matricule);
        // Ajoutez l'étudiant à une collection ou un système de gestion
        System.out.println("Étudiant '" + nom + " " + prenom + "' créé avec succès.");
    }

    private void assignerEtudiantAEquipe() {
        // Logique pour assigner un étudiant à une équipe
    }

    private void mettreAJourEtudiant() {
        // Logique pour mettre à jour les détails d'un étudiant
    }

    private void afficherInformationsEtudiant() {
        // Logique pour afficher les informations d'un étudiant
    }

}
