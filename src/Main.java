
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            InetAddress equipo = InetAddress.getLocalHost();

            System.out.println("EQUIPO LOCAL");
            System.out.println("Nombre: " + equipo.getHostName());
            System.out.println("IP: " + equipo.getHostAddress());

        } catch (UnknownHostException e) {
            System.out.println("No se ha podido obtener el equipo local.");
        }

        String dominio;

        do {
            System.out.println("\nIntroduce un dominio (o salir para terminar):");
            dominio = sc.nextLine();

            if (!dominio.equalsIgnoreCase("salir")) {

                try {
                    InetAddress[] direcciones = InetAddress.getAllByName(dominio);

                    System.out.println("\nDirecciones IP de " + dominio + ":");

                    for (InetAddress ip : direcciones) {

                        if (ip.getAddress().length == 4) {
                            System.out.println("IPv4: " + ip.getHostAddress());

                        } else if (ip.getAddress().length == 16) {
                            System.out.println("IPv6: " + ip.getHostAddress());
                        }
                    }

                } catch (UnknownHostException e) {
                    System.out.println("Error: el dominio no existe o no se ha podido encontrar.");
                }
            }

        } while (!dominio.equalsIgnoreCase("salir"));

        System.out.println("\nPrograma finalizado.");

        sc.close();
    }
}
