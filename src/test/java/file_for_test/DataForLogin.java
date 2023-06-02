package file_for_test;

public class DataForLogin {

    private String login;
    private String password;

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DataForLogin(String login, String password){
        this.login=login;
        this.password=password;
    }
    public DataForLogin(){
    }
}
