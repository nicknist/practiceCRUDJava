package sample;

import java.util.ArrayList;

public class Login {
    //This program will hold all of the logins for the users. This will have a username and password
    private ArrayList<String> userNames = new ArrayList<String>();
    private ArrayList<String> passwords = new ArrayList<String>();

    Login() {
     userNames.add("nickiscool");
     userNames.add("beniscool");
     userNames.add("johniscool");

     passwords.add("nick3");
     passwords.add("ben3");
     passwords.add("john3");
    }

    public void addUserLogin(String name, String password) {
        userNames.add(name);
        passwords.add(password);
    }

    public boolean checkLogin(String userName, String password) {
        int index = userNames.indexOf(userName);
        boolean passwordCheck = false;
        if (index != -1) {
            passwordCheck = password.equals(passwords.get(index));
        }
        if (index != -1 && passwordCheck) {
            return true;
        } else if (index != -1) {
            System.out.println("The password is wrong. Please try again.");
            return false;
        } else {
            System.out.println("That username does not exist. Please try again and make an account.");
            return false;
        }
    }


    public static void main(String[] args) {

    }
}