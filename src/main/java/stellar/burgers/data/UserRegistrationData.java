package stellar.burgers.data;

public class UserRegistrationData {

    public String nameOfUser;
    public String emailAddress;
    public String password;

    public UserRegistrationData(String nameOfUser, String emailAddress, String password) {
        this.nameOfUser = nameOfUser;
        this.emailAddress = emailAddress;
        this.password = password;
    }
}
