package Processes;

import Runnables.ChildRunnable;
import Runnables.ParentRunnable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sitora on 11.12.16.
 */
public class Boss {
    private ChildRunnable childRunnable = new ChildRunnable();
    private ParentRunnable parentRunnable = new ParentRunnable();
    private int childCount, parentCount, sendMessagesCountToChildren, sendMessagesCountToParents;
    List<Thread> childThreads, parentThreads;

    public Boss(int childCount, int parentCount) {
        childThreads = new ArrayList<Thread>(childCount);
        parentThreads = new ArrayList<Thread>(parentCount);
        this.childCount = childCount;
        this.parentCount = parentCount;
        fillThreads();
    }

    private void fillThreads() {
        for (int i = 0; i < childCount; i++) {
            childThreads.add(new Thread(childRunnable, "Processes.Child #" + i));
        }
        for (int i = 0; i < parentCount; i++) {
            parentThreads.add(new Thread(parentRunnable, "Processes.Parent #" + i));

        }

        for (Thread t : childThreads) {
            if (sendMessagesCountToChildren < 3) {
                t.start();
                sendMessagesCountToChildren++;
            } else {
                break;
            }
        }

        for (Thread t : parentThreads) {
            if (sendMessagesCountToParents < 3) {
                t.start();
                sendMessagesCountToParents++;
            }
        }
    }
}
