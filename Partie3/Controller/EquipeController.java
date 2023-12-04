import java.util.Scanner;

public class EquipeController {
    private Scanner scanner;
    private Hackathon hackathon; // Supposons que vous avez un objet Hackathon disponible

    public EquipeController(Scanner scanner, Hackathon hackathon) {
        this.scanner = scanner;
        this.hackathon = hackathon;
    }

    public void afficherMenu() {
        boolean retour = false;
        while (!retour) {
            System.out.println("\nSous-Menu Équipe:");
            System.out.println("1. Créer une équipe");
            System.out.println("2. Ajouter un étudiant à une équipe");
            System.out.println("3. Supprimer un étudiant d'une équipe");
            System.out.println("4. Afficher les membres d'une équipe");
            System.out.println("5. Retour");

            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    creerEquipe();
                    break;
                case 2:
                    ajouterEtudiantAEquipe();
                    break;
                case 3:
                    supprimerEtudiantDeEquipe();
                    break;
                case 4:
                    afficherMembresEquipe();
                    break;
                case 5:
                    retour = true;
                    break;
                default:
                    System.out.println("Option non valide, veuillez réessayer.");
            }
        }
    }

    private void creerEquipe() {
        scanner.nextLine(); // Consomme la ligne restante
        System.out.print("Entrez le nom de la nouvelle équipe: ");
        String nomEquipe = scanner.nextLine();

        Equipe nouvelleEquipe = new Equipe(nomEquipe);
        hackathon.addEquipe(nouvelleEquipe);
        System.out.println("Équipe '" + nomEquipe + "' créée avec succès.");
    }

    private void ajouterEtudiantAEquipe() {
        // Logique pour ajouter un étudiant à une équipe
    }

    private void supprimerEtudiantDeEquipe() {
        // Logique pour supprimer un étudiant d'une équipe
    }

    private void afficherMembresEquipe() {
        // Logique pour afficher les membres d'une équipe
    }

    // Autres méthodes nécessaires...
}
