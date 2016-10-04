package processors;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by sitora on 03.10.16.
 */
public class SPNProcessorTest {
    private final SPNProcessor spnProcessor = new SPNProcessor();
    private final int PROCESSES_COUNT = 25;
    private final int MIN = 3;
    private final int MAX = 9;
    private ArrayList<Process> processes;


    @Before
    public void setUp() throws Exception {
        processes = new ArrayList<>(25);
        for (int i = 0; i < PROCESSES_COUNT; i++) {
            processes.add(new Process(ThreadLocalRandom.current().nextInt(MIN, MAX + 1), "" + i));
        }
    }

    @Test
    public void doTest() throws InterruptedException {
        for (Process process : processes) {
            spnProcessor.addProcess(process);
            Thread.sleep(ThreadLocalRandom.current().nextInt(1, 8) * 100);
        }
        Thread.sleep(10000);
    }

}