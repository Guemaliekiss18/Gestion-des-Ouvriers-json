import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GestionOuvriers implements ListesOuvriers {
    private List<Ouvrier> ouvriers = new ArrayList<>();

    @Override
    public void ajouterOuvrier(Ouvrier ouvrier) {
        ouvriers.add(ouvrier);
        System.out.println("Ouvrier ajouté : " + ouvrier);
    }

    @Override
    public void afficherOuvriers() {
        if (ouvriers.isEmpty()) {
            System.out.println("Aucun ouvrier enregistré.");
        } else {
            ouvriers.forEach(System.out::println);
        }
    }

    @Override
    public Ouvrier rechercherOuvrier(String nom) {
        return ouvriers.stream()
                .filter(ouvrier -> ouvrier.getNom().equalsIgnoreCase(nom))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void sauvegarderOuvriers(String cheminFichier) {
        try (FileWriter writer = new FileWriter(cheminFichier)) {
            new Gson().toJson(ouvriers, writer);
            System.out.println("Ouvriers sauvegardés dans le fichier : " + cheminFichier);
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }

    @Override
    public List<Ouvrier> chargerOuvriers(String cheminFichier) {
        try (FileReader reader = new FileReader(cheminFichier)) {
            Type typeListe = new TypeToken<ArrayList<Ouvrier>>() {}.getType();
            ouvriers = new Gson().fromJson(reader, typeListe);
            System.out.println("Ouvriers chargés depuis le fichier : " + cheminFichier);
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement : " + e.getMessage());
        }
        return ouvriers;
    }
}

