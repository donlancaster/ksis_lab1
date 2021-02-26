import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) throws UnknownHostException, SocketException {
        InetAddress addr1 = InetAddress.getLocalHost();
        System.out.println("My LANip: "+addr1.getHostAddress());


        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface i = interfaces.nextElement();
            System.out.println("Display name: " + i.getDisplayName());
            System.out.println("Name: " + i.getName());
            Enumeration<InetAddress> inetAddresses = i.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress addr = inetAddresses.nextElement();
                System.out.println("hostAddress: " + addr.getHostAddress());
            }

            byte[] mac = i.getHardwareAddress();
            // null if localhost
            if (mac != null) {
                for (byte b : mac) {
                    System.out.print(b);
                }
            }
            System.out.println();
        }

    }
}

