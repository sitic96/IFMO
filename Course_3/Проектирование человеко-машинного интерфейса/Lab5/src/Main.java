import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        try {
            String line;
            Process p = Runtime.getRuntime().exec("ps -e");
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            System.out.println("=======ALL PROCESSES=======");
            while ((line = input.readLine()) != null) {
                System.out.println(line); //<-- Parse data here.
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println("=======ALL THREADS IN JVM=======");
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        for (Thread th:threadSet){
            System.out.println(th.toString());
        }
    }
}
