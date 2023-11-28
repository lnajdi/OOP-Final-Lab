import java.util.Scanner;

public class AppScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrée des informations du hackathon
        System.out.println("Entrez le nom du hackathon:");
        String nomHackathon = scanner.nextLine();
        System.out.println("Entrez la date du hackathon (format YYYY-MM-DD):");
        String dateHackathon = scanner.nextLine();
        System.out.println("Choisissez la ville du hackathon (1 pour Casablanca, 2 pour Rabat, etc.):");
        int choixVille = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne restante

        Ville villeHackathon = Ville.values()[choixVille - 1];
        Hackathon hackathon = new Hackathon(nomHackathon, dateHackathon, villeHackathon);

        // Entrée des informations des équipes
        System.out.println("Combien d'équipes participent?");
        int nombreEquipes = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne restante

        for (int i = 0; i < nombreEquipes; i++) {
            System.out.println("Entrez le nom de l'équipe " + (i + 1) + ":");
            String nomEquipe = scanner.nextLine();
            Equipe equipe = new Equipe(nomEquipe);
            hackathon.ajouterEquipe(equipe);

            // Entrée des informations des étudiants
            System.out.println("Combien d'étudiants dans l'équipe " + nomEquipe + "?");
            int nombreEtudiants = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne restante

            for (int j = 0; j < nombreEtudiants; j++) {
                System.out.println("Entrez le nom de l'étudiant " + (j + 1) + ":");
                String nomEtudiant = scanner.nextLine();
                System.out.println("Entrez l'université de l'étudiant:");
                String universiteEtudiant = scanner.nextLine();
                System.out.println("Entrez la compétence principale de l'étudiant:");
                String competenceEtudiant = scanner.nextLine();

                Etudiant etudiant = new Etudiant(nomEtudiant, universiteEtudiant, competenceEtudiant);
                equipe.ajouterEtudiant(etudiant);
            }
        }

        // Affichage des informations du hackathon
        System.out.println("Hackathon: " + hackathon.getNom() + " à " + hackathon.getLieu());
        System.out.println("Équipes participantes:");
        for (Equipe equipe : hackathon.getEquipes()) {
            System.out.println(" - " + equipe.getNom());
            System.out.println("   Membres:");
            for (Etudiant etudiant : equipe.getMembres()) {
                System.out.println("   - " + etudiant.getNom() + " de " + etudiant.getUniversite());
            }
        }

        scanner.close();
    }
}
```

Dans ce programme, l'utilisateur est invité à entrer les informations du hackathon, y compris le nom, la date, la ville, ainsi que les détails des équipes et des étudiants. Après l'entrée des données, le programme affiche un résumé des informations saisies. Vous pouvez étendre ou modifier ce programme pour inclure plus de fonctionnalités selon vos besoins.