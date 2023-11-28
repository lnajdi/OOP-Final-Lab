import java.util.ArrayList;
import java.util.List;

public class Hackathon {
    private String nom;
    private String date;
    private Ville lieu;
    private List<Equipe> equipes = new ArrayList<>();
    private Jury jury;

    public Hackathon(String nom, String date, Ville lieu) {
        this.nom = nom;
        this.date = date;
        this.lieu = lieu;
    }

    public void ajouterEquipe(Equipe equipe) {
        equipes.add(equipe);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Ville getLieu() {
        return lieu;
    }

    public void setLieu(Ville lieu) {
        this.lieu = lieu;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    public Jury getJury() {
        return jury;
    }

    public void setJury(Jury jury) {
        this.jury = jury;
    }
}
