public class Discours {
    private String sujet;
    private String orateur;

    public Discours(String sujet, String orateur) {
        this.sujet = sujet;
        this.orateur = orateur;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getOrateur() {
        return orateur;
    }

    public void setOrateur(String orateur) {
        this.orateur = orateur;
    }
}
