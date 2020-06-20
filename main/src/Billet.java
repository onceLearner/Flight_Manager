public class Billet {
    private String idBillet,dateReservation, dateVoyage, dateArrive,etat;

    public Billet(String idBillet, String dateReservation, String dateVoyage, String dateArrive, String etat) {
        this.idBillet = idBillet;
        this.dateReservation = dateReservation;
        this.dateVoyage = dateVoyage;
        this.dateArrive = dateArrive;
        this.etat = etat;
    }

    public String getIdBillet() {
        return idBillet;
    }

    public void setIdBillet(String idBillet) {
        this.idBillet = idBillet;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getDateVoyage() {
        return dateVoyage;
    }

    public void setDateVoyage(String dateVoyage) {
        this.dateVoyage = dateVoyage;
    }

    public String getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive(String dateArrive) {
        this.dateArrive = dateArrive;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
