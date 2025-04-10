public abstract class Ouvrier {
    private String nom;
    private String prenom;
    private int anneesExperience;

    public Ouvrier(String nom, String prenom, int anneesExperience) {
        this.nom = nom;
        this.prenom = prenom;
        this.anneesExperience = anneesExperience;
    }
    public abstract void effectuerTravail();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAnneesExperience() {
        return anneesExperience;
    }


    public void setAnneesExperience(int anneesExperience) {
        this.anneesExperience = anneesExperience;
    }

    @Override
    public String toString(){
        return  getClass().getSimpleName()+"-"+prenom+""+nom+"("+anneesExperience+"ans d'experience)";
    }
}

