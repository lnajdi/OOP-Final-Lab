

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

    public static void saveEquipesData(List<Equipe> equipes, String equipesFilePath) {
        try (FileWriter csvWriter = new FileWriter(equipesFilePath)) {
            // En-tête du fichier Équipes
            csvWriter.append("Nom Equipe\n");
            for (Equipe equipe : equipes) {
                csvWriter.append(equipe.getNomEquipe()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveEtudiantsData(List<Equipe> equipes, String etudiantsFilePath) {
        try (FileWriter csvWriter = new FileWriter(etudiantsFilePath)) {
            // En-tête du fichier Étudiants
            csvWriter.append("Nom Etudiant,Prénom Etudiant,Matricule,Equipe\n");
            for (Equipe equipe : equipes) {
                for (Etudiant etudiant : equipe.getEtudiants()) {
                    if (etudiant.getEquipe() != null) { // Vérifiez que l'équipe n'est pas null
                        csvWriter.append(etudiant.getCne()).append(",")
                                 .append(etudiant.getEquipe().getNomEquipe()).append("\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}