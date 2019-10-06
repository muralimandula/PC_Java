import java.util.*;

public final class User {
    String userName;
    User[] connections;
    int noOfConnections;
    int connectionsCapacity;

    User(final String name) {
        userName = name;
        connections = new User[20];
        noOfConnections = 0;
        connectionsCapacity = 20;
    }

    User(final String name, final String n) {
        userName = name;
        connections = new User[20];
        noOfConnections = 0;
        connectionsCapacity = 20;
    }
    
    User(final String name,final User[] userFriends, final int n) {
        userName = name;
        connections = userFriends;
        noOfConnections = n;
        connectionsCapacity = 20;
    }

    public String getUserName() {
        return this.userName;
    }

    public void addFriend(final User user) {
        connections[noOfConnections] = user;
        noOfConnections++;

        if (noOfConnections == connectionsCapacity){
            connections = java.util.Arrays.copyOf(connections, connectionsCapacity * 2);
            connectionsCapacity = connectionsCapacity * 2;
        }
    }

    /*
     *to string
     */
    public String toString() {
        String out =  userName + " : ";

        if (noOfConnections > 0) {
            out += "[";

            for (int i = 0; i < noOfConnections - 1; i++) {
                out += connections[i].userName + ", ";
            }
            out += connections[noOfConnections - 1].userName + "]";
        }

        return out;
    }


}