import java.util.ArrayList;
import java.util.List;

public class Maçon extends Ouvrier {
    private String specialisation;
    private List<String> outils;


    public Maçon(String nom, String prenom, int anneesExperience, String specialisation) {
        super(nom, prenom, anneesExperience);
        this.specialisation = specialisation;
        this.outils= new ArrayList<>();

    }

    @Override
    public void effectuerTravail() {
        System.out.println(getPrenom()+""+getNom()+"Faire des travaux de maçonnerie("+specialisation+")");
    }
    public void ajouterOutils(String outil){
        outils.add(outil);
    }
    public void afficherOutils(){
        System.out.println("Outils utilisés par "+getPrenom()+ ":");
        for (String outil: outils){
            System.out.println("-"+outil);
        }
    }
    public void construireMur(){
        System.out.println("Le maçon construit un mur en bloc-ciment");
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
    @Override
    public String toString() {
        return super.toString() + " - Spécialisation : " + specialisation;
    }

}

