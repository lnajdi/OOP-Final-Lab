import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AppPersistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Saisie des informations du hackathon
        System.out.println("Entrez le nom du hackathon:");
        String nomHackathon = scanner.nextLine();
        System.out.println("Entrez la date du hackathon (format YYYY-MM-DD):");
        String dateHackathon = scanner.nextLine();
        System.out.println("Choisissez la ville du hackathon (1 pour Casablanca, 2 pour Rabat, etc.):");
        int choixVille = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne restante

        Ville villeHackathon = Ville.values()[choixVille - 1];
        Hackathon hackathon = new Hackathon(nomHackathon, dateHackathon, villeHackathon);

        // Saisie des informations des équipes
        System.out.println("Combien d'équipes participent?");
        int nombreEquipes = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne restante

        for (int i = 0; i < nombreEquipes; i++) {
            System.out.println("Entrez le nom de l'équipe " + (i + 1) + ":");
            String nomEquipe = scanner.nextLine();
            Equipe equipe = new Equipe(nomEquipe);
            hackathon.ajouterEquipe(equipe);

            // Saisie des informations des étudiants
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

        // Écriture des informations dans des fichiers CSV
        ecrireHackathon(hackathon, "hackathon.csv");
        ecrireEquipes(hackathon.getEquipes(), "equipes.csv");

        // Lecture des informations depuis des fichiers CSV
        Hackathon hackathonLu = lireHackathon("hackathon.csv");
        List<Equipe> equipesLues = lireEquipes("equipes.csv");

        // Affichage des informations lues
        afficherHackathon(hackathonLu);
        afficherEquipes(equipesLues);

        scanner.close();
    }

    public static void ecrireHackathon(Hackathon hackathon, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append(hackathon.getNom()).append(",");
            writer.append(hackathon.getDate()).append(",");
            writer.append(hackathon.getLieu().toString()).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Hackathon lireHackathon(String filePath) {
        Hackathon hackathon = null;
        try (Scanner scanner = new Scanner(new File(filePath))) {
            if (scanner.hasNextLine()) {
                String[] hackathonInfo = scanner.nextLine().split(",");
                hackathon = new Hackathon(hackathonInfo[0], hackathonInfo[1], Ville.valueOf(hackathonInfo[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return hackathon;
    }

    public static void ecrireEquipes(List<Equipe> equipes, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Equipe equipe : equipes) {
                writer.append(equipe.getNom()).append("\n");
                for (Etudiant etudiant : equipe.getMembres()) {
                    writer.append(etudiant.getNom()).append(",");
                    writer.append(etudiant.getUniversite()).append(",");
                    writer.append(etudiant.getCompetence()).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Equipe> lireEquipes(String filePath) {
        List<Equipe> equipes = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            Equipe equipe = null;
            while (scanner.hasNextLine()) {
                String[] ligne = scanner.nextLine().split(",");
                if (ligne.length == 1) {
                    if (equipe != null) {
                        equipes.add(equipe);
                    }
                    equipe = new Equipe(ligne[0]);
                } else {
                    Etudiant etudiant = new Etudiant(ligne[0], ligne[1], ligne[2]);
                    equipe.ajouterEtudiant(etudiant);
                }
            }
            if (equipe != null) {
                equipes.add(equipe);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return equipes;
    }

    public static void afficherHackathon(Hackathon hackathon) {
        System.out.println("Hackathon: " + hackathon.getNom() + " à " + hackathon.getLieu());
    }

    public static void afficherEquipes(List<Equipe> equipes) {
        System.out.println("Équipes participantes:");
        for (Equipe equipe : equipes) {
            System.out.println(" - " + equipe.getNom());
            System.out.println("   Membres:");
            for (Etudiant etudiant : equipe.getMembres()) {
                System.out.println("   - " + etudiant.getNom() + " de " + etudiant.getUniversite());
            }
        }
    }
}
