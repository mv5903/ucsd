///////////////////////////////////////////////////////////////////////////////
// Main Class File:    ServerQueueTester.java
// File:               ServerQueue.java
// Quarter:            CSE 8B Winter 2022
//
// Author:             Matthew Vandenberg
// Email:              mvandenberg@ucsd.edu
// Instructor's Name:  Gregory Miranda
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.ArrayList;

/**
 * A CONCRETE class that maintains a server queue.
 *
 * Bugs: None found.
 *
 * @author (YOUR NAME)
 */
public class ServerQueue {
    
    private String name;
    private ArrayList<User> queue;

    /**
     * Constructor to initialize a Server Queue.
     * The queue should be initialized to be an
     *  empty ArrayList.
     * 
     * DO NOT MODIFY THE CONSTRUCTOR DECLARATION.
     *
     * @param name - the name of the server.
     */
    public ServerQueue(String name) {
        this.name = name;
        this.queue = new ArrayList<User>();
    }

    /**
     * Clear the queue.
     * This is simply done by setting the queue
     *  to a new, empty ArrayList.
     * 
     * DO NOT MODIFY THE CONSTRUCTOR DECLARATION.
     */
    public void clearQueue() {
        this.queue.clear();
    }

    /**
     * Getter method to return the Server name.
     * 
     * @return the name of the server.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter method to return the queue.
     *
     * @return the queue.
     */
    public ArrayList<User> getQueue() {
        return this.queue;
    }

    /**
     * Appends a user to the queue.
     * 
     * DO NOT MODIFY THE CONSTRUCTOR DECLARATION.
     * 
     * @param user - user to append to queue.
     */
    public void appendToQueue(User user) {
        this.queue.add(user);
    }

    /**
     * Remove a user from the queue.
     * 
     * First, this method should check if there is a VIP user in the queue.
     * If there is a VIP user, then you should remove the first instance of
     *  a VIP user.
     * If there is no VIP user, then you should remove the user at the "0th
     *  index" of the queue.
     * 
     * DO NOT MODIFY THE CONSTRUCTOR DECLARATION.
     * 
     * @return the User (either VIP or BasicUser) that is removed from the
     *  queue.
     */
    public User removeFromQueue() {
        User toRemove = this.queue.get(0);
        for (User user: this.queue) {
            if (user.getPriority()) {
                toRemove = user;
            }
        }
        this.queue.remove(toRemove);
        return toRemove;
    }

    /**
     * Merge all the users from `q2` to `q1`.
     * 
     * After this method completes, `q1` should contain all users from `q1`
     *  and `q2`, and `q2` should be completely empty. 
     * 
     * DO NOT MODIFY THE CONSTRUCTOR DECLARATION.
     * 
     * @param q1 - ServerQueue to transfer all users to.
     * @param q2 - ServerQueue to transfer all users from.
     */
    public static void mergeQueue(ServerQueue q1, ServerQueue q2) {
        // Add all from q2 at end of q1
        for (User user: q2.getQueue()) {
            q1.appendToQueue(user);
        }
        // Clear q2
        q2.clearQueue();
    }

}
