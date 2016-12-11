package Runnables;

import Processes.Child;

/**
 * Created by sitora on 12.12.16.
 */
public class ChildRunnable implements Runnable {
    public void run() {
        Child child = new Child();
        child.getMessage("Thread" + Thread.currentThread().getName() + " send me a message!");
    }
}
