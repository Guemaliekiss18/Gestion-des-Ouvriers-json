import java.util.ArrayList;
import java.util.List;

public class Peintre extends Ouvrier{
    private  String typeBatiment;
    private List<String> techniques;
    private boolean certification;

    public Peintre(String nom, String prenom, int anneesExperience, String typeBatiment, boolean certification){
        super(nom, prenom, anneesExperience);
        this.typeBatiment= typeBatiment;
        this.certification=certification;
        this.techniques= new ArrayList<>();
    }

    @Override
    public void effectuerTravail() {
        System.out.println(getPrenom()+ " "+ getNom()+"Peint un  " + typeBatiment+ " Avec les techniques : "+ techniques);
    }
    public void preparerSurface(){
        System.out.println("Preparation de la surface(ponçage ,nettoyage)");
    }
    public void aplliquerCouche(){
        System.out.println("Application peinture");
    }
    public void ajouterTechniques(String technique){
        techniques.add(technique);

    }

    public String getTypeBatiment() {
        return typeBatiment;
    }

    public void setTypeBatiment(String typeBatiment) {
        this.typeBatiment = typeBatiment;
    }

    public List<String> getTechniques() {
        return techniques;
    }

    public void setTechniques(List<String> techniques) {
        this.techniques = techniques;
    }

    public boolean isCertification() {
        return certification;
    }

    public void setCertification(boolean certification) {
        this.certification = certification;
    }
    @Override
    public String toString() {
        return super.toString() + " - Type de bâtiment : " + typeBatiment + " - Certifié : " + certification;
    }

}

