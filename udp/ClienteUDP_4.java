package udp;
import java.net.*;
import java.util.Scanner;

public class ClienteUDP_4 {
    public static void main(String args[]) throws Exception {
        Scanner Teclado = new Scanner(System.in);
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte DatosEnviar[];
        byte DatosRecibir[];
        
        System.out.println("Cliente UDP (Entrada y Salida) iniciado.");
        
        while(true) {
            System.out.println("Ingresa un mensaje para el servidor (o 'salir' para terminar): ");
            String CadenaEnviar = Teclado.nextLine();
            
            if (CadenaEnviar.equalsIgnoreCase("salir")) break;
            
            DatosEnviar = CadenaEnviar.getBytes();
            DatagramPacket PaqueteSalida = new DatagramPacket(
                DatosEnviar, DatosEnviar.length, IPAddress, 9090
            );
            clientSocket.send(PaqueteSalida);
            
            DatosRecibir = new byte[1024];
            DatagramPacket PaqueteRecibido = new DatagramPacket(DatosRecibir, DatosRecibir.length);
            clientSocket.receive(PaqueteRecibido);
            
            String respuesta = new String(PaqueteRecibido.getData());
            System.out.println("Respuesta del servidor: " + respuesta);
        }
        clientSocket.close();
        System.out.println("Cliente cerrado.");
    }
}
