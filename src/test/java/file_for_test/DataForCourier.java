package file_for_test;

public class DataForCourier {

    private String firstName;
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public DataForCourier(){

    }

    public DataForCourier(String login, String password, String firstName){
        this.login=login;
        this.password=password;
        this.firstName=firstName;
    }
}
