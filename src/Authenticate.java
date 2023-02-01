//authenticate class for authenticate employee in system which uses email and password for verification
public class Authenticate {

    //here i use hardcore values because i dont have persistent data
    private final String email = "harshj.wappnet@gmail.com";
    private final String password = "Harsh@123";

    /*checkpassword metod take two parameter email and password and if email and password is
    correct than it returns sucess otherwise email or password is wrong.
     */
    void checkpassword(String user_email, String user_password) {

        if (email.equals(user_email) && password.equals(user_password)) {
            System.out.println("Authentication Sucessful");
        } else {
            System.out.println("Wrong email or password");
            System.exit(0);
        }
    }

}
