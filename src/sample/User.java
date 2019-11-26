package sample;

import java.util.ArrayList;

public class User {
    //This class will manipulate the user information based on the current User. The methods are add a post, delete a post, comment, or add a friend.
    String myUserName;
    String myName;
    ArrayList<String> friends;
    ArrayList<String> posts;

    User(String userName, String name, ArrayList<String> myFriends, ArrayList<String> myPosts) {
        myUserName = userName;
        myName = name;
        friends = myFriends;
        posts = myPosts;
    }

    public static void main(String[] args) {

    }
}


