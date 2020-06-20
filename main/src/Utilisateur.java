public abstract class Utilisateur {
    private String login;
    private String pwd;

    public Utilisateur(String login, String pwd) {
        this.login = login;
        this.pwd = pwd;
    }
    public  Utilisateur(){};

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
