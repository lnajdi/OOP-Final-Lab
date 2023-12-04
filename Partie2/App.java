
import java.time.LocalDate;

public class App {  
    public static void main(String[] args) {
        // Création du hackathon AI4Morocco 2023 
        Hackathon hackathon = new Hackathon("AI4Morocco 2023", LocalDate.of(2023, 12, 25), Ville.TAROUDANT);
        
        // Création des équipes
        Equipe equipe1 = new Equipe("Équipe FPT");
        Equipe equipe2 = new Equipe("Équipe FST");  
        Equipe equipe3 = new Equipe("Équipe ENSA");

        // Ajout des équipes au hackathon 
        hackathon.addEquipe(equipe1);
        hackathon.addEquipe(equipe2);
        hackathon.addEquipe(equipe3);

        // Création et ajout des étudiants pour l'Équipe FPT
        equipe1.addEtudiant(new Etudiant("Mohamed", "Id Baha", "1400002354", Universite.UIZ));
        equipe1.addEtudiant(new Etudiant("Ahmed", "Zitouni", "1400002355", Universite.UIZ));
        equipe1.addEtudiant(new Etudiant("Hassan", "Anab", "1400002356", Universite.UIZ));
        
        // Création et ajout des étudiants pour l'Équipe FST
        equipe2.addEtudiant(new Etudiant("Fatima", "IDBRAHIM", "1400002357", Universite.UCA));
        equipe2.addEtudiant(new Etudiant("Aicha", "Alami", "1400002358", Universite.UCA));   
        equipe2.addEtudiant(new Etudiant("Hicham", "Smahi", "1400002359", Universite.UCA));
        
        // Création et ajout des étudiants pour l'Équipe ENSA
        equipe3.addEtudiant(new Etudiant("Abdelali", "Boufekrane", "1400002360", Universite.UIT));
        equipe3.addEtudiant(new Etudiant("Said", "Lamrani", "1400002361", Universite.UIT)); 
        equipe3.addEtudiant(new Etudiant("Mohamed", "Solaymani", "1400002362", Universite.UIT));

        // Affichage des informations du hackathon
        hackathon.afficherInfos();

        
        // Sauvegarde des données du hackathon
        HackathonDataSaver.saveHackathonData(hackathon, "data/hackathon.csv");

        // Sauvegarde des données des équipes
        HackathonDataSaver.saveEquipesData(hackathon.getEquipes(), "data/equipes.csv");

        // Sauvegarde des données des étudiants
        HackathonDataSaver.saveEtudiantsData(hackathon.getEquipes(), "data/etudiants.csv");
    }
}
    
  

