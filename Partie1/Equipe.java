package Etape1;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    //Attributs : nom, liste des étudiants, nombre d'étudiants, nombre maximum d'étudiants.
    private String nomEquipe;
    
    private  List<Etudiant> etudiants = new ArrayList<>(); // Initialize the list here
 ;

    private int nombreEtudiants;

    

    public Equipe(String nomEquipe, List<Etudiant> etudiants, int nombreEtudiants) {
        this.nomEquipe = nomEquipe;
        this.etudiants = etudiants;
        this.nombreEtudiants = nombreEtudiants;
    }


    public Equipe(String nomEquipe, int nombreEtudiants) {
        this.nomEquipe = nomEquipe;
        this.nombreEtudiants = nombreEtudiants;
    }

    public Equipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }       

    public String getNomEquipe() {
        return nomEquipe;
    }   

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }   

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }   


    public int getNombreEtudiants() {
        return nombreEtudiants;
    }   

    public void setNombreEtudiants(int nombreEtudiants) {
        this.nombreEtudiants = nombreEtudiants;
    }

    public void addEtudiant(Etudiant etudiant) {
        this.etudiants.add(etudiant);
    }

    public void removeEtudiant(Etudiant etudiant) {
        this.etudiants.remove(etudiant);
    }   

   
    public void afficherEtudiants() {
        for (Etudiant etudiant : etudiants) {
            System.out.println(etudiant);
        }
    }   


    

    @Override
    public String toString() {
        return "Equipe{" +
                "nomEquipe='" + nomEquipe + '\'' +
                ", etudiants=" + etudiants +
                ", nombreEtudiants=" + nombreEtudiants +
                '}';
    }   


}
