package Runnables;

import Processes.Parent;

/**
 * Created by sitora on 12.12.16.
 */
public class ParentRunnable implements Runnable{
    public void run() {
        Parent parent = new Parent();
        parent.getMessage("Thread" + Thread.currentThread().getName() + " send me a message!");
    }
}
