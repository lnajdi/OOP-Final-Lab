import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static HackathonController hackathonController;
    private static EquipeController equipeController;
    private static EtudiantController etudiantController;

    public static void main(String[] args) {
        hackathonController = new HackathonController(scanner);
        equipeController = new EquipeController(scanner);
        etudiantController = new EtudiantController(scanner);

        boolean quitter = false;
        while (!quitter) {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Gérer Hackathon");
            System.out.println("2. Gérer Équipes");
            System.out.println("3. Gérer Étudiants");
            System.out.println("4. Quitter");

            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    hackathonController.afficherMenu();
                    break;
                case 2:
                    equipeController.afficherMenu();
                    break;
                case 3:
                    etudiantController.afficherMenu();
                    break;
                case 4:
                    quitter = true;
                    break;
                default:
                    System.out.println("Option non valide, veuillez réessayer.");
            }
        }
        scanner.close();
    }
}