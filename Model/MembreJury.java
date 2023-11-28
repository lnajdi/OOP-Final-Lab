public class MembreJury extends Personne {
    private String role;

    public MembreJury(String nom, String contact, String role) {
        super(nom, contact);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
