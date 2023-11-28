import java.util.ArrayList;
import java.util.List;

public class Jury {
    private List<MembreJury> membres = new ArrayList<>();

    public void ajouterMembreJury(MembreJury membre) {
        membres.add(membre);
    }

    public List<MembreJury> getMembres() {
        return membres;
    }

    public void setMembres(List<MembreJury> membres) {
        this.membres = membres;
    }
}

