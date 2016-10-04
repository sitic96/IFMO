import processors.Process;
import processors.SRTProcessor;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Process first = new Process(7, "first");
        Process second = new Process(4, "second");
        Process third = new Process(3, "third");

        SRTProcessor processor = new SRTProcessor();
        processor.addProcess(first);
        System.out.println("First added");
        Thread.sleep(30);
        processor.addProcess(second);
        System.out.println("Second added");
        Thread.sleep(30);
        //processor.addProcess(third);
        //System.out.println("Third added");

//        processor.addProcess(new Process(2, "two"));
//        processor.addProcess(new Process(4, "four"));
//        processor.addProcess(new Process(1, "one"));
//        processor.addProcess(new Process(3, "three"));
//        processor.addProcess(new Process(7, "seven"));
//        processor.addProcess(new Process(2, "two (again)"));
//        processor.addProcess(new Process(8, "eight"));
//        processor.addProcess(new Process(5, "five"));
//        processor.addProcess(new Process(6, "six"));
    }
}