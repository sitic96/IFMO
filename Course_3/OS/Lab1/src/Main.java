import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) throws UnknownHostException {
        // GetComputerName
        String computername = InetAddress.getLocalHost().getHostName();
        System.out.println("Computer name: " + computername);

        // GetUserName
        String username = System.getProperty("user.name");
        System.out.println("User name: " + username);

        // OS Version
        String osName = System.getProperty("os.name");
        System.out.println("OS name: " + osName);

        //OS Version
        String osVersion = System.getProperty("os.version");
        System.out.println("OS Version: " + osVersion);

        // OS Arch
        String osArch = System.getProperty("os.arch");
        System.out.println("OS Architecture: " + osArch);

        // Processors count
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("Processors count: " + processors);

        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();

        // Memory info
        System.out.println("Free memory: " + runtime.freeMemory() / 1024);
        System.out.println("Allocated memory: " + runtime.totalMemory() / 1024);
        System.out.println("Max memory: " + runtime.maxMemory() / 1024);
        System.out.println("Total memory: " + (freeMemory + (maxMemory - allocatedMemory)) / 1024);
    }
}
