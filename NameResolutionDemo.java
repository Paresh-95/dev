import java.net.InetAddress;
import java.net.UnknownHostException;

public class NameResolutionDemo {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java NameResolutionDemo <hostname>");
            System.exit(1);
        }

        String hostname = args[0];

        try {

            InetAddress inetAddress = InetAddress.getByName(hostname);

            String ipAddress = inetAddress.getHostAddress();
            String canonicalHostName = inetAddress.getCanonicalHostName();
            boolean isReachable = inetAddress.isReachable(5000); 

            System.out.println("Hostname: " + hostname);
            System.out.println("Canonical Hostname: " + canonicalHostName);
            System.out.println("IP Address: " + ipAddress);
            System.out.println("Is Reachable: " + isReachable);

        }  catch (UnknownHostException e) {
            System.err.println("Hostname could not be resolved: " + hostname);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
