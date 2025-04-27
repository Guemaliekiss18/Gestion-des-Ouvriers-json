import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OuvrierDAO {
    public static void ajouterOuvrier(Ouvrier ouvrier) {
        String query = "INSERT INTO ouvriers (nom, prenom, annees_experience, type_ouvrier, specialisation, domaine, certifie, type_batiment) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, ouvrier.getNom());
            stmt.setString(2, ouvrier.getPrenom());
            stmt.setInt(3, ouvrier.getAnneesExperience());
            stmt.setString(4, ouvrier.getClass().getSimpleName());

            if (ouvrier instanceof Maçon) {
                stmt.setString(5, ((Maçon) ouvrier).getSpecialisation());
                stmt.setNull(6, java.sql.Types.VARCHAR);
                stmt.setNull(7, java.sql.Types.BOOLEAN);
                stmt.setNull(8, java.sql.Types.VARCHAR);
            } else if (ouvrier instanceof Electricien) {
                stmt.setNull(5, java.sql.Types.VARCHAR);
                stmt.setString(6, ((Electricien) ouvrier).getDomaine());
                stmt.setBoolean(7, ((Electricien) ouvrier).isCertifie());
                stmt.setNull(8, java.sql.Types.VARCHAR);
            } else if (ouvrier instanceof Peintre) {
                stmt.setNull(5, java.sql.Types.VARCHAR);
                stmt.setNull(6, java.sql.Types.VARCHAR);
                stmt.setBoolean(7, ((Peintre) ouvrier).isCertification());
                stmt.setString(8, ((Peintre) ouvrier).getTypeBatiment());
            }

            stmt.executeUpdate();
            System.out.println("Ouvrier ajouté avec succès dans la base de données.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

