

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HackathonDataSaver {

    // Méthode pour créer le dossier si nécessaire
    private static void createDirectoryIfNotExists(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs(); // Crée le dossier (et les dossiers parents si nécessaire)
        }
    }

    public static void saveHackathonData(Hackathon hackathon, String hackathonFilePath) {
        try (FileWriter csvWriter = new FileWriter(hackathonFilePath)) {
            // En-tête du fichier Hackathon
            csvWriter.append("Nom,Date,Lieu\n");
            csvWriter.append(hackathon.getNom()).append(",")
                     .append(hackathon.getDate().toString()).append(",")
                     .append(hackathon.getVille().toString()).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


   
    // Méthode pour sauvegarder les données de plusieurs équipes
    public static void saveEquipesData(List<Equipe> equipes, String equipesFilePath) {
        try (FileWriter csvWriter = new FileWriter(equipesFilePath)) {
            // En-tête du CSV
            csvWriter.append("Nom Equipe,Nom Hackathon,Nombre Etudiants\n");

            // Écrire les données de chaque équipe
            for (Equipe equipe : equipes) {
                String nomHackathon = equipe.getHackathon() != null ? equipe.getHackathon().getNom() : "Inconnu";
                csvWriter.append(equipe.getNomEquipe()).append(",")
                         .append(nomHackathon).append(",")
                         .append(String.valueOf(equipe.getNombreEtudiants())).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static void saveEtudiantsData(List<Equipe> equipes, String etudiantsFilePath) {
        try (FileWriter csvWriter = new FileWriter(etudiantsFilePath)) {
            // En-tête du fichier Étudiants
            csvWriter.append("Matricule,Equipe\n"); // En-tête modifiée
            for (Equipe equipe : equipes) {
                for (Etudiant etudiant : equipe.getEtudiants()) {
                    csvWriter.append(etudiant.getCne()).append(",")
                             .append(equipe.getNomEquipe()).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
}