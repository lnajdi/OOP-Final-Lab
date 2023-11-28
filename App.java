public class App {
    public static void main(String[] args) {
        // Création du hackathon
        Hackathon hackathon = new Hackathon("Défi Technologique pour l'Innovation Sociale", "2023-04-15", Ville.CASABLANCA);

        // Création et ajout des équipes
        Equipe equipe1 = new Equipe("Équipe Alfa");
        Equipe equipe2 = new Equipe("Équipe Beta");
        Equipe equipe3 = new Equipe("Équipe Gamma");
        hackathon.ajouterEquipe(equipe1);
        hackathon.ajouterEquipe(equipe2);
        hackathon.ajouterEquipe(equipe3);

        // Création et ajout des étudiants pour l'Équipe Alfa
        equipe1.ajouterEtudiant(new Etudiant("Amina", "amina@example.com", "Université Mohammed V", "Développement Web"));
        equipe1.ajouterEtudiant(new Etudiant("Karim", "karim@example.com", "École Mohammadia d'Ingénieurs", "Cybersécurité"));
        equipe1.ajouterEtudiant(new Etudiant("Leila", "leila@example.com", "Université Hassan II", "Design UX/UI"));

        // Création et ajout des étudiants pour l'Équipe Beta
        equipe2.ajouterEtudiant(new Etudiant("Youssef", "youssef@example.com", "Université Al Akhawayn", "Intelligence Artificielle"));
        equipe2.ajouterEtudiant(new Etudiant("Sara", "sara@example.com", "Université Cadi Ayyad", "Data Science"));
        equipe2.ajouterEtudiant(new Etudiant("Omar", "omar@example.com", "Université Ibn Tofail", "Réseaux et Télécommunications"));

        // Création et ajout des étudiants pour l'Équipe Gamma
        equipe3.ajouterEtudiant(new Etudiant("Hassan", "hassan@example.com", "Université Abdelmalek Essaadi", "Robotique"));
        equipe3.ajouterEtudiant(new Etudiant("Nadia", "nadia@example.com", "Université Ibn Zohr", "Marketing Digital"));
        equipe3.ajouterEtudiant(new Etudiant("Samir", "samir@example.com", "Université Sidi Mohamed Ben Abdellah", "Génie Logiciel"));

        // Création des membres du jury
        MembreJury jury1 = new MembreJury("Fatima", "fatima@example.com", "Juge Principal");
        MembreJury jury2 = new MembreJury("Ali", "ali@example.com", "Mentor Technique");
        MembreJury jury3 = new MembreJury("Houda", "houda@example.com", "Expert en Innovation");

        // Création du jury et ajout des membres
        Jury jury = new Jury();
        jury.ajouterMembreJury(jury1);
        jury.ajouterMembreJury(jury2);
        jury.ajouterMembreJury(jury3);

        // Association du jury au hackathon
        hackathon.setJury(jury);

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
    }
}
