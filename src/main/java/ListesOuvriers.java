import java.util.List;

public interface ListesOuvriers {
    void ajouterOuvrier(Ouvrier ouvrier);

    void afficherOuvriers();

    Ouvrier rechercherOuvrier(String nom);

    void sauvegarderOuvriers(String cheminFichier);

    List<Ouvrier> chargerOuvriers(String cheminFichier);
}
