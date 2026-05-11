package udp_envio_recepcion;
import java.net.*;
import java.util.Scanner;

public class ClienteUDPEnviarRecibir {
    public static void main(String args[]) throws Exception {
        Scanner teclado = new Scanner(System.in);
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress serverIP = InetAddress.getByName("localhost");
        int serverPort = 9091;
        
        System.out.println("Cliente UDP (Enviar/Recibir) iniciado.");
        
        while(true) {
            System.out.print("Escribe un mensaje para el servidor (o 'salir'): ");
            String mensaje = teclado.nextLine();
            
            if (mensaje.equalsIgnoreCase("salir")) break;
            
            byte[] datosEnviar = mensaje.getBytes();
            DatagramPacket packetSalida = new DatagramPacket(
                datosEnviar, datosEnviar.length, serverIP, serverPort
            );
            clientSocket.send(packetSalida);
            
            byte[] bufferRecibir = new byte[1024];
            DatagramPacket packetEntrada = new DatagramPacket(bufferRecibir, bufferRecibir.length);
            clientSocket.receive(packetEntrada);
            
            String respuesta = new String(packetEntrada.getData(), 0, packetEntrada.getLength());
            System.out.println("Servidor responde: " + respuesta);
        }
        clientSocket.close();
        teclado.close();
        System.out.println("Cliente cerrado.");
    }
}
