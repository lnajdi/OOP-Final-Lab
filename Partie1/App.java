package Etape1;


import java.time.LocalDate;


public class App {  

    public static void main(String[] args) {
        // Création du hackathon AI4Morocco 2023 
    
        Hackathon hackathon = new Hackathon(
            "AI4Morocco 2023",
            LocalDate.of(2023, 12, 25),
            Ville.TAROUDANT
        );
        
        // Création  des équipes
        Equipe equipe1 = new Equipe("Équipe FPT", 3);
        Equipe equipe2 = new Equipe("Équipe FST", 3);  
        Equipe equipe3 = new Equipe("Équipe ENSA", 3);

        //ajout équipes au hackathon 
        hackathon.addEquipe(equipe1);
        hackathon.addEquipe(equipe2);
        hackathon.addEquipe(equipe3);


        // Création et ajout des étudiants pour l'Équipe FPT
        Etudiant etudiant1 = new Etudiant("Mohamed", "Id Baha", "1400002354");
        Etudiant etudiant2 = new Etudiant("Ahmed", "Zitouni", "1400002355");
        Etudiant etudiant3 = new Etudiant("Hassan", "Anab", "1400002356");
        equipe1.addEtudiant(etudiant1);
        equipe1.addEtudiant(etudiant2);
        equipe1.addEtudiant(etudiant3);
        
        // Création et ajout des étudiants pour l'Équipe FST
        Etudiant etudiant4 = new Etudiant("Fatima", "IDBRAHIM", "1400002357");
        Etudiant etudiant5 = new Etudiant("Aicha","Alami", "1400002358");   
        Etudiant etudiant6 = new Etudiant("Hicham", "Smahi", "1400002359");
        equipe2.addEtudiant(etudiant4);
        equipe2.addEtudiant(etudiant5);
        equipe2.addEtudiant(etudiant6);
        


        // Création et ajout des étudiants pour l'Équipe ENSA
        Etudiant etudiant7 = new Etudiant("Abdelali", "Boufekrane", "1400002360",equipe3);
        Etudiant etudiant8 = new Etudiant("Said", "lamrani", "1400002361",equipe3); 
        Etudiant etudiant9 = new Etudiant("Mohamed", "Solaymani","1400002362",equipe3);
    

        //afficher hackathon infos
        hackathon.afficherInfos();
    }
}
    
  

