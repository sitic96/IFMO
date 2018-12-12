package processors;

import java.util.TreeSet;

/**
 * Created by sitora on 02.10.16.
 */
public class SRTProcessor {
    private boolean isBusy;
    private int countOfProcesses = 0;
    private long workTime = 0;
    private TreeSet<Process> processes;

    public SRTProcessor() {
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
            int timeToSleep;
            Process currentProcess;
            while (processes.size() > 0) {
                synchronized (processes) {
                    currentProcess = processes.pollFirst();
                    timeToSleep = currentProcess.getLength();
                }
                for (int i = 10; i < timeToSleep; i += 10) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (processes) {
                        if (processes.size() != 0) {
                            if (timeToSleep - i > processes.first().getLength()) {
                                currentProcess.setLength(timeToSleep - i);
                                processes.add(currentProcess);
                                break;
                            }
                        } else {
                            if (timeToSleep - i <= 0) {
                                System.out.println("Empty!");
                                break;
                            }
                        }
                    }
                    if (timeToSleep - i == 10) {
                        workTime += System.currentTimeMillis() - currentProcess.getRecivedTime();
                        countOfProcesses++;
                    }
                }
            }
            isBusy = false;
            System.out.println("Mean time for SRTProcessor is " + (workTime / countOfProcesses));
        }).start();
    }
}
