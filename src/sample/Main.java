package sample;

import java.util.Scanner;
import java.util.ArrayList;

//This class specifically handles user interaction and will be the program that you want to run in the terminal

public class Main {
    Scanner input;
    UserData userData;
    User currentUser;
    Login login;


    Main() {
        input = new Scanner(System.in);
        userData = new UserData();
        login = new Login();
    }

    public String initialMessage() {
        System.out.println("Welcome to Blog Post! Would you like to login or signup?");
        Main main = new Main();
        String choice = input.nextLine().toLowerCase();

        if (choice.equals("login")) {
            //run loginPage and check for that good good
            String userName = main.checkLogin();
            if (userName.equals("Not Valid. Please Try Again.")) {
                return "";
            }
            //if valid -> we've got a userName variable that we can return and then go to the user page!
            return userName;

        } else if (choice.equals("signup")) {
            //run loginPage method that takes the input and makes a new user login stuff...?
            String userName = main.makeAccount();

            return userName;
            //have someone signup and then make them log in....
        } else {
            System.out.println("Please try again and enter one of the two options (case sensitive)");
            return "";
        }

    }

    public String makeAccount() {

        //make a new user and then add to userData stuff.
        Login login = new Login();
        System.out.println("What is your name: ");
        String name = input.nextLine();

        System.out.println("What would you like for your Username: ");
        String userName = input.nextLine();

        System.out.println("What about your Password: ");
        String password = input.nextLine();

        //make a user with the new username, an empty friends list, and an empty posts list
        currentUser = new User(userName, name, new ArrayList<String>(), new ArrayList<String>());

        //make sure the login class has the username and password
        login.addUserLogin(userName, password);

        //make sure the userData is updated.
        userData.addUser(currentUser);

        System.out.println("Perfect, we'll make and account and log you in with those credentials");

        return userName;

    }

     public String checkLogin() {
         System.out.println("Username: ");
         String userName = input.nextLine();

         System.out.println("Password: ");
         String password = input.nextLine();

         boolean logCheck = login.checkLogin(userName, password);
         if (logCheck) {
             return userName;
         } else {
             return "Not Valid. Please Try Again.";
         }
     }

     public void userDashBoard(String userName, Main main) {
        System.out.println("Welcome " + userName + ", would you like to (choose a number): ");
        System.out.println("1. View My Posts");
        System.out.println("2. View Friends");
        System.out.println("3. Change My Posts");
        System.out.println("4. Delete Posts");
        System.out.println("5. Add Friends");
        System.out.println("6. Delete Friends");
        System.out.println("7. Logout");

        String choice = input.nextLine();

        if (choice.equals("1")) {
            //get the posts and print them out
            ArrayList<String> posts = userData.postData(userName);
            System.out.println(posts);

            System.out.println("");

            main.userDashBoard(userName, main);

        } else if (choice.equals("2")) {
            //here's your friends!
            ArrayList<String> friends = userData.friendsData(userName);
            System.out.println(friends);

            System.out.println("");

            main.userDashBoard(userName, main);

        } else if (choice.equals("3")) {
            //show the posts... then ask what one you want to change and the new content.
             // print out the new posts list
            ArrayList<String> posts = userData.postData(userName);
            System.out.println(posts);
            System.out.println("Which number post would you like to change?");
            String postNumber = input.nextLine();
            System.out.println("What would you like to change it to?");
            String postChange = input.nextLine();

            userData.changePost(userName, postNumber, postChange);

            ArrayList<String> newPosts = userData.postData(userName);
            System.out.println("Here's your new posts: ");
            System.out.println(newPosts);

            System.out.println("");

            main.userDashBoard(userName, main);

        } else if (choice.equals("4")) {

            ArrayList<String> posts = userData.postData(userName);
            System.out.println(posts);
            System.out.println("Which number post would you like to delete?");
            String postNumber = input.nextLine();

            userData.deletePost(userName, postNumber);

            ArrayList<String> newPosts = userData.postData(userName);
            System.out.println("Here's your new posts: ");
            System.out.println(newPosts);

            System.out.println("");

            main.userDashBoard(userName, main);

        } else if (choice.equals("5")) {
            //here are your friends, who would you like to add?
            ArrayList<String> friends = userData.friendsData(userName);
            System.out.println(friends);
            System.out.println("Which friend would you like to add?");
            String newFriend = input.nextLine();


            userData.addFriend(userName, newFriend);

            //print out new friend list
            ArrayList<String> newFriends = userData.friendsData(userName);
            System.out.println("Here's your new friends list: ");
            System.out.println(newFriends);

            System.out.println("");

            main.userDashBoard(userName, main);

        } else if (choice.equals("6")) {
            //here are your friends, which would you like to delete?
            ArrayList<String> friends = userData.friendsData(userName);
            System.out.println(friends);
            System.out.println("Which number friend would you like to delete?");
            String friendIndex = input.nextLine();

            userData.deleteFriend(userName, friendIndex);

            //print out new friend list
            ArrayList<String> newFriends = userData.friendsData(userName);
            System.out.println("Here's your new friends list: ");
            System.out.println(newFriends);

            System.out.println("");

            main.userDashBoard(userName, main);

        } else if (choice.equals("7")) {
            System.out.println("You have Logged Out");

        } else {
            System.out.println("Sorry, that was not one of the choices. Please login and try again");

        }
     }

    public static void main(String[] args) {
        Main main = new Main();
        String getUserName = main.initialMessage();
        if (!getUserName.isBlank()) {
            main.userDashBoard(getUserName, main);
        }
    }
}
