public class Siege {
    private String idSiege,type;

    public Siege(String idSiege, String type) {
        this.idSiege = idSiege;
        this.type = type;
    }
    public Siege(){}

    public String getIdSiege() {
        return idSiege;
    }

    public void setIdSiege(String idSiege) {
        this.idSiege = idSiege;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
