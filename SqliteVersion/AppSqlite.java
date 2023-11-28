package SqliteVersion;

import Model.Ville;
import Model.Hackathon; // Add this import statement

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import Model.Equipe; // Add this import statement
import Model.Etudiant;
import Model.MembreJury; // Add this import statement

public class AppSqlite {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:path/to/your/hackathon.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseHelper.createTables(conn);

                Scanner scanner = new Scanner(System.in);

                // Saisie des informations du hackathon
                System.out.println("Entrez le nom du hackathon:");
                String nomHackathon = scanner.nextLine();
                System.out.println("Entrez la date du hackathon (format YYYY-MM-DD):");
                String dateHackathon = scanner.nextLine();
                System.out.println("Choisissez la ville du hackathon (1 pour Casablanca, 2 pour Rabat, etc.):");
                int choixVille = scanner.nextInt();
                scanner.nextLine();

                Ville villeHackathon = Ville.values()[choixVille - 1];
                Hackathon hackathon = new Hackathon(nomHackathon, dateHackathon, villeHackathon);

                DatabaseHelper.insertHackathon(conn, hackathon);


                // Saisie et insertion des équipes
                System.out.println("Combien d'équipes participent?");
                int nombreEquipes = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < nombreEquipes; i++) {
                    System.out.println("Entrez le nom de l'équipe " + (i + 1) + ":");
                    String nomEquipe = scanner.nextLine();
                    Equipe equipe = new Equipe(nomEquipe);
                    int hackathonId = DatabaseHelper.insertHackathon(conn, hackathon);
                    DatabaseHelper.insertEquipe(conn, equipe, hackathonId);
                }

                // Saisie et insertion des étudiants
                System.out.println("Entrez le nombre total d'étudiants:");
                int nombreEtudiants = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < nombreEtudiants; i++) {
                    System.out.println("Entrez le nom de l'étudiant " + (i + 1) + ":");
                    String nomEtudiant = scanner.nextLine();
                    System.out.println("Entrez l'université de l'étudiant:");
                    String universite = scanner.nextLine();
                    System.out.println("Entrez la compétence principale de l'étudiant:");
                    String competence = scanner.nextLine();
                    System.out.println("Entrez l'ID de l'équipe de l'étudiant:");
                    int equipeId = scanner.nextInt();
                    scanner.nextLine();

                    Etudiant etudiant = new Etudiant(nomEtudiant, universite, competence);
                    DatabaseHelper.insertEtudiant(conn, etudiant, equipeId);
                }


                // Saisie et insertion des membres du jury

                // ...

                System.out.println("Entrez le nombre de membres du jury:");
                int nombreMembresJury = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < nombreMembresJury; i++) {
                    System.out.println("Entrez le nom du membre du jury " + (i + 1) + ":");
                    String nomMembreJury = scanner.nextLine();
                    System.out.println("Entrez le rôle du membre du jury:");
                    String role = scanner.nextLine();

                    MembreJury membreJury = new MembreJury(nomMembreJury, role);
                    DatabaseHelper.insertMembreJury(conn, membreJury, hackathon.getId());
                }

                scanner.close();

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

               
}

class DatabaseHelper {
    public static void createTables(Connection conn) throws SQLException {
        String sqlCreateHackathons = 
            "CREATE TABLE IF NOT EXISTS hackathons (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "date TEXT," +
            "location TEXT);";

        String sqlCreateEquipes = 
            "CREATE TABLE IF NOT EXISTS equipes (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "hackathon_id INTEGER," +
            "FOREIGN KEY (hackathon_id) REFERENCES hackathons(id));";

        String sqlCreateEtudiants = 
            "CREATE TABLE IF NOT EXISTS etudiants (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "universite TEXT," +
            "competence TEXT," +
            "equipe_id INTEGER," +
            "FOREIGN KEY (equipe_id) REFERENCES equipes(id));";

        String sqlCreateMembresJury = 
            "CREATE TABLE IF NOT EXISTS membres_jury (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "role TEXT," +
            "hackathon_id INTEGER," +
            "FOREIGN KEY (hackathon_id) REFERENCES hackathons(id));";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sqlCreateHackathons);
            stmt.execute(sqlCreateEquipes);
            stmt.execute(sqlCreateEtudiants);
            stmt.execute(sqlCreateMembresJury);
        }
    }

    public static void insertHackathon(Connection conn, Hackathon hackathon) throws SQLException {
        String sqlInsertHackathon = 
            "INSERT INTO hackathons (name, date, location) VALUES (?, ?, ?);";

        try (PreparedStatement pstmt = conn.prepareStatement(sqlInsertHackathon)) {
            pstmt.setString(1, hackathon.getNom());
            pstmt.setString(2, hackathon.getDate());
            pstmt.setString(3, hackathon.getLieu().toString());
            pstmt.executeUpdate();
        }
    }

    public static void insertEquipe(Connection conn, Equipe equipe, int hackathonId) throws SQLException {
        String sqlInsertEquipe = 
            "INSERT INTO equipes (name, hackathon_id) VALUES (?, ?);";

        try (PreparedStatement pstmt = conn.prepareStatement(sqlInsertEquipe)) {
            pstmt.setString(1, equipe.getNom());
            pstmt.setInt(2, hackathonId);
            pstmt.executeUpdate();
        }
    }

    public static void insertEtudiant(Connection conn, Etudiant etudiant, int equipeId) throws SQLException {
        String sqlInsertEtudiant = 
            "INSERT INTO etudiants (name, universite, competence, equipe_id) VALUES (?, ?, ?, ?);";

        try (PreparedStatement pstmt = conn.prepareStatement(sqlInsertEtudiant)) {
            pstmt.setString(1, etudiant.getNom());
            pstmt.setString(2, etudiant.getUniversite());
            pstmt.setString(3, etudiant.getCompetence());
            pstmt.setInt(4, equipeId);
            pstmt.executeUpdate();
        }
    }

    public static void insertMembreJury(Connection conn, MembreJury membreJury, int hackathonId) throws SQLException {
        String sqlInsertMembreJury = 
            "INSERT INTO membres_jury (name, role, hackathon_id) VALUES (?, ?, ?);";

        try (PreparedStatement pstmt = conn.prepareStatement(sqlInsertMembreJury)) {
            pstmt.setString(1, membreJury.getNom());
            pstmt.setString(2, membreJury.getRole());
            pstmt.setInt(3, hackathonId);
            pstmt.executeUpdate();
        }
    }
}
}



