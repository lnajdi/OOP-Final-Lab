
public class Personne {
    //Attributs : nom, prénom, téléphone, email.    
    protected String nom;
    protected String prenom;
    protected String email;
    protected String numeroTelephone;

    public Personne(String nom, String prenom, String email, String numeroTelephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numeroTelephone = numeroTelephone;
    }

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", numeroTelephone='" + numeroTelephone + '\'' +
                '}';
    }
}
