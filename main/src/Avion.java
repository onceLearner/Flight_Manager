public class Avion {
    private String id_avion, compagnie;
    private int nb_place;

    public Avion(String id_avion, String compgnie, int nb_place) {
        this.id_avion = id_avion;
        this.compagnie = compgnie;
        this.nb_place = nb_place;
    }

    public String getId_avion() {
        return id_avion;
    }

    public void setId_avion(String id_avion) {
        this.id_avion = id_avion;
    }

    public String getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(String compagnie) {
        this.compagnie = compagnie;
    }

    public int getNb_place() {
        return nb_place;
    }

    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }
}
