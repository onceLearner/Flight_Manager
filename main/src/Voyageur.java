public class Voyageur extends Utilisateur {

    private String nom, prenom, addresse,passeport;

    public Voyageur(String login, String pwd, String nom, String prenom, String addresse, String passeport) {
        super(login, pwd);
        this.nom = nom;
        this.prenom = prenom;
        this.addresse = addresse;
        this.passeport = passeport;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getPasseport() {
        return passeport;
    }

    public void setPasseport(String passeport) {
        this.passeport = passeport;
    }
}

