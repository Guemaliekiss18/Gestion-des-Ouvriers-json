import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataManager {

    private static final String FILE_PATH = "ouvriers.json";

    // Méthode pour sauvegarder la liste des ouvriers dans un fichier JSON
    public static void sauvegarderOuvriers(List<Ouvrier> ouvriers) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(ouvriers, writer);
            System.out.println("Données sauvegardées avec succès dans " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde des données : " + e.getMessage());
        }
    }

    // Méthode pour charger la liste des ouvriers depuis un fichier JSON
    public static List<Ouvrier> chargerOuvriers() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, List.class); // Charger en tant que liste générique
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement des données : " + e.getMessage());
        }
        return null;
    }
}
