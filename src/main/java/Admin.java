import java.util.ArrayList;
import java.util.List;

public class Admin {
    private String nom;
    private String prenom;
    private List<Ouvrier> ouvriers;

    public Admin(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.ouvriers = new ArrayList<>();
    }

    public void ajouterOuvrier(Ouvrier ouvrier) {
        ouvriers.add(ouvrier);
        System.out.println("Ouvrier ajouté : " + ouvrier);
    }

    public void supprimerOuvrier(Ouvrier ouvrier) {
        if (ouvriers.remove(ouvrier)) {
            System.out.println("Ouvrier supprimé : " + ouvrier);
        } else {
            System.out.println("Ouvrier non trouvé.");
        }
    }

    public void afficherOuvriers() {
        if (ouvriers.isEmpty()) {
            System.out.println("Aucun ouvrier enregistré.");
        } else {
            System.out.println("Liste des ouvriers :");
            for (Ouvrier ouvrier : ouvriers) {
                System.out.println("- " + ouvrier);
            }
        }
    }

    public Ouvrier rechercherOuvrier(String nom) {
        for (Ouvrier ouvrier : ouvriers) {
            if (ouvrier.getNom().equalsIgnoreCase(nom)) {
                System.out.println("Ouvrier trouvé : " + ouvrier);
                return ouvrier;
            }
        }
        System.out.println("Aucun ouvrier trouvé avec le nom : " + nom);
        return null;
    }

    @Override
    public String toString() {
        return "Admin: " + prenom + " " + nom;
    }
}



