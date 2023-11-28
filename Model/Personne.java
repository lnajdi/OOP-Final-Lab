public class Personne {
    protected String nom;
    protected String contact;

    public Personne(String nom, String contact) {
        this.nom = nom;
        this.contact = contact;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
