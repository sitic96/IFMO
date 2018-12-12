package processors;

import java.util.TreeSet;

/**
 * Created by sitora on 01.10.16.
 */
public class SPNProcessor {
    private long workTime = 0;
    private int countOfProcesses = 0;
    private boolean isBusy;
    private TreeSet<Process> processes;

    public SPNProcessor() {
        isBusy = false;
        processes = new TreeSet<>();
    }

    public void addProcess(Process process) {
        synchronized (processes) {
            process.setRecivedTime(System.currentTimeMillis());
            processes.add(process);
        }
        if (!isBusy) {
            doWork();
        }
    }

    private void doWork() {
        new Thread(() -> {
            isBusy = true;
            Process currentProcess = null;
            int timeToSleep = 0;
            while (processes.size() > 0) {
                synchronized (processes) {
                    if (processes.size() != 0) {
                        currentProcess = processes.pollFirst();
                        //System.out.println("Process #" + processes.first().getName() + " Length = " + processes.first().getLength());
                        timeToSleep = currentProcess.getLength();
                    }
                }
                try {
                    Thread.sleep(timeToSleep);
                    countOfProcesses++;
                    workTime += System.currentTimeMillis() - currentProcess.getRecivedTime();
                    //System.out.println("Process #" + currentProcess.getName() + " served for " + (System.currentTimeMillis() - currentProcess.getRecivedTime()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Mean time for SPNProcessor is " + (workTime / countOfProcesses));
            isBusy = false;
        }).start();
    }
}
