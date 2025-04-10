public class Electricien extends Ouvrier{
    private String domaine ;
    private boolean certifie;

    public Electricien(String nom , String prenom , int anneesExperience,String domaine, boolean certifie){
        super(nom , prenom, anneesExperience);
        this.domaine= domaine;
        this.certifie= certifie;
    }

    @Override
    public void effectuerTravail() {
        System.out.println(getPrenom()+""+ getNom()+ "Effectue les travaux électriques("+domaine+")");
    }
    public void verifierInstalltion(){
        System.out.println("L'electricien verifie l'installation");
    }

    public String getDomaine() {
        return domaine;
   }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public boolean isCertifie() {
        return certifie;
    }

    public void setCertifie(boolean certifie) {
        this.certifie = certifie;
    }
    @Override
    public String toString() {
        return super.toString() + " - Domaine : " + domaine + " - Certifié : " + certifie;
    }


}

