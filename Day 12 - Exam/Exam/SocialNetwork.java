/**
 * This class implements all the methods of the SocialNetrorkInterface 
 * You are free to add your own behaviours to this class.
 * 
 * @author Siva Sankar
 */

import java.util.Arrays;

public class SocialNetwork {

    // String[] userNames;
    /**
     * users indicates the actual users in the network
     */
    User[] users;

    /**
     * The size indicates the numebr of users in the network
     */
    int size;
    int capacity;
    /**
     * Initializes the default values of the social network.
     */
    public SocialNetwork() {
        // TODO
        // Your code goes here
        this.users = new User[20];
        this.size = 0;
        this.capacity = 20;
    }

    /**
     * This method takes the string as a parameter which is used
     * to create a network. do nothing if the string is empty.
     * 
     * @param str to be used to create a network.
     */
    public void createDataStructure(String str) {
        // TODO
        // Your code goes here
        if (str != "") {

            String[] tokens = str.split(";");

            for (String eachtoken : tokens) {
                String[] users = eachtoken.split(" is connected to ");

                String userName = users[0];
                String[] userFriends = users[1].split(",");

                User[] userFriendObjects = new User[20];
                for(int i = 0; i < userFriends.length; i++) {
                    userFriendObjects[i] = new User(userFriends[i]);
                }

                User gotUser = getUser(userName);

                if (gotUser == null) {

                    User userObj = new User(userName, userFriendObjects, userFriends.length);
                    addUser(userObj);

                } else {

                    for (User var : userFriendObjects) {
                        if (var != null) {
                            gotUser.addFriend(var);
                        } else {
                            break;
                        }
                    }
                }

                for (User var : userFriendObjects) {

                    if (var == null) {
                        break;

                    } else if (getUser(var.getUserName()) == null) {
                        addUser(var);
                    } else {
                        
                    }
                }

                
            }

        }
    }
    

    private boolean searchUser(User user) {
        if(user == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (user.equals(users[i]) || user.getUserName().equals(users[i].getUserName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Please don't modify the follwoing code.
     * This method returns the User based on the userName.
     * 
     * @param userName the string to be used to search for the user.
     * @return the User object based on the userName. 
     * Returns null otherwise
     */
    public User getUser(String userName) {
        for (int i = 0; i < size; i++) {
            if (userName.equals(users[i].getUserName())) {
                return users[i];
            }
        }
        return null;
    }

    /**
     * This method adds a new User (object) that is passed as 
     * argument to the social network if the user is not currently 
     * on the social network.
     * @param userA to be added to the social network.
     */
    public void addUser(User userA) {
        // TODO
        // Your code goes here
        // return;
        // System.out.println(userA);
        // System.out.println(searchUser(userA));
        if (!searchUser(userA)) {
            this.users[size] = userA;
            // this.userNames[size] = userA.userName;
            this.size++;
            if (this.size == this.capacity) {
                this.users = java.util.Arrays.copyOf(users, this.capacity * 2);
                this.capacity = this.capacity * 2;
            }
        }
    }

    /**
     * This method takes two users (objects) as arguments and 
     * connects them on the network. userA and userB are 
     * the users that are passed as parameters to this function, 
     * then add userB to userA’s connections
     * 
     * Note: Both userA and userB should be there on the network.
     * if anyone of them are not on the network, then do nothing.
     * 
     * @param userA the userB is to be added to userA connections
     * @param userB to be added to userA connections
     */
    public void addConnection(User userA, User userB) {
        // TODO
        // Your code goes here

        if (searchUser(userA) && searchUser(userB)) {
            userA.addFriend(userB);
        }
    }

    /**
     * This method takes a user object as an argument that returns the 
     * connections of this user. Return null if the user is not in 
     * the network.
     * 
     * @param userA the user object used to return the 
     * connections of this user.
     * 
     * @return the list of connections of userA. otherwise return null
     */
    public User[] getConnections(User userA) {
        // TODO
        // Your code goes here
        if(userA != null) {
            if(searchUser(userA)) {
                return userA.connections;
            } else {
                return null;
            }
        }
        return null;
    }

    /**
     * This method returns the common connections of userA and userB.
     * Note: both userA and userB should be on the network. if anyone 
     * of them is not in the network, then return null
     * 
     * @param userA the first user
     * @param userB the second user
     * 
     * @return the common connections of both userA and userB if they 
     * both are in the network, otherwise return null
     */
    public User[] getCommonConnections(User userA, User userB) {
        // TODO
        // Your code goes here

        // System.out.println(userA);
        // System.out.println(userB);
        User[] commonConnections = new User[10];
        int i = 0;

        if (searchUser(userA) && searchUser(userB)) {
            // System.out.println("Im working here -----------------------");
            for (User user1 : userA.connections) {
                for (User user2 : userB.connections) {
                    if ((user1 != null && user2 != null ) && user1.getUserName().equals(user2.getUserName())) {
                        // System.out.println(user1);
                        commonConnections[i++] = user1;
                    }
                }
            }
            // System.out.println(commonConnections);
            return commonConnections;
        } else {
            return null;
        }
    }

    /**
     * This reutrns the String version of the social network.
     * 
     * @return the String version of the network, return an empty string
     * if there are no users in the network.
     */
    public String toString() {
        // System.out.println(size + "---------");
        if (this.size == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for (i = 0; i < size-1; i++) {
            sb.append(users[i] + "\n");
        }
        sb.append(users[i]);
        // System.out.println(sb.toString());
        return sb.toString();
    }
}