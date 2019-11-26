package sample;

import java.util.ArrayList;

public class UserData {
    //This class will hold all the userdata which includes names, posts,
    ArrayList<User> userData;
    ArrayList<String> friend1;
    ArrayList<String> friend2;
    ArrayList<String> post1;
    ArrayList<String> post2;
    ArrayList<String> post3;
    User user1;
    User user2;
    User user3;


    UserData() {
        userData = new ArrayList<User>();

        friend1 = new ArrayList<String>();
        friend1.add("Ben");
        friend1.add("John");

        friend2 = new ArrayList<String>();
        friend2.add("Nick");

        post1 = new ArrayList<String>();
        post1.add("I got a dog today");
        post1.add("Yesterday was Ellie's birthday");
        post1.add("Happy Holidays");

        post2 = new ArrayList<String>();
        post2.add("I went to Puerto Rico over break and it was awesome");
        post2.add("I enjoy climbing");

        post3 = new ArrayList<String>();
        post3.add("I went home for Thanksgiving and ate a bunch of food");
        post3.add("I am done with Whole30 and enjoyed the experience");

        user1 = new User("nickiscool", "Nick", friend1, post1);
        user2 = new User("beniscool", "Ben", friend2, post2);
        user3 = new User("johniscool","John", friend2, post3);

        userData.add(user1);
        userData.add(user2);
        userData.add(user3);
    }

    public void addUser(User user) {
        userData.add(user);
    }

    public ArrayList<String> friendsData(String userName) {
        //for each user in userdata.... if the userName matches, then put the user in the variable.
        User currentUser;
        for (User user : userData) {
            if (user.myUserName.equals(userName)) {
                currentUser = user;
                return currentUser.friends;
            }
        }
        return new ArrayList<String>();
    }

    public ArrayList<String> postData(String userName) {
        User currentUser;
        for (User user: userData) {
            if (user.myUserName.equals(userName)) {
                currentUser = user;
                return currentUser.posts;
            }
        }
        return new ArrayList<String>();
    }

    public void changePost(String userName, String index, String newPost) {
        User currentUser;
        for (User user: userData) {
            if (user.myUserName.equals(userName)) {
                currentUser = user;
                int actualIndex = Integer.parseInt(index) - 1;
                currentUser.posts.set(actualIndex, newPost);
            }
        }
    }

    public void deletePost(String userName, String index) {
        User currentUser;
        for (User user: userData) {
            if (user.myUserName.equals(userName)) {
                currentUser = user;
                int actualIndex = Integer.parseInt(index) - 1;
                currentUser.posts.remove(actualIndex);
            }
        }
    }

    public void addFriend(String userName, String newFriend) {
        User currentUser;
        for (User user: userData) {
            if (user.myUserName.equals(userName)) {
                currentUser = user;
                currentUser.friends.add(newFriend);
            }
        }
    }

    public void deleteFriend(String userName, String friendIndex) {
        User currentUser;
        for (User user: userData) {
            if (user.myUserName.equals(userName)) {
                currentUser = user;
                int actualIndex = Integer.parseInt(friendIndex) - 1;
                currentUser.friends.remove(actualIndex);
            }
        }
    }

    public static void main(String[] args) {

    }
}
