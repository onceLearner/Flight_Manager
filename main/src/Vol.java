public class Vol {
    private String idVol;
    private String idAvion;
    private String dateDepart;

    public String getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    private String heureDepart;
    private String heureArrive;
    private String aeroportDepart;
    private String aeroportArrive;
    private int duree;

    public Vol(String idVol, String idAvion,String dateDepart, String heureDepart, String heureArrive, String aeroportDepart, String aeroportArrive, int duree) {
        this.idVol = idVol;
        this.dateDepart=dateDepart;
        this.idAvion = idAvion;
        this.heureDepart = heureDepart;
        this.heureArrive = heureArrive;
        this.aeroportDepart = aeroportDepart;
        this.aeroportArrive = aeroportArrive;
        this.duree = duree;

    }


    public String getIdVol() {
        return idVol;
    }

    public void setIdVol(String idVol) {
        this.idVol = idVol;
    }

    public String getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(String idAvion) {
        this.idAvion = idAvion;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }

    public String getHeureArrive() {
        return heureArrive;
    }

    public void setHeureArrive(String heureArrive) {
        this.heureArrive = heureArrive;
    }

    public String getAeroportDepart() {
        return aeroportDepart;
    }

    public void setAeroportDepart(String aeroportDepart) {
        this.aeroportDepart = aeroportDepart;
    }

    public String getAeroportArrive() {
        return aeroportArrive;
    }

    public void setAeroportArrive(String aeroportArrive) {
        this.aeroportArrive = aeroportArrive;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
}
