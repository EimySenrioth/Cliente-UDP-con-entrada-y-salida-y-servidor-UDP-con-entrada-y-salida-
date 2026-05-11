package udp;
import java.net.*;

public class ServerUDP_3 {
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9090);
        byte DatosRecibir[];
        
        System.out.println("Servidor UDP (Entrada y Salida) esperando mensajes...");
        
        while(true) {
            DatosRecibir = new byte[1024];
            DatagramPacket PaqueteRecibido = new DatagramPacket(DatosRecibir, DatosRecibir.length);
            serverSocket.receive(PaqueteRecibido);
            
            String mensaje = new String(PaqueteRecibido.getData());
            System.out.println("Cliente dice: " + mensaje);
            
            String respuesta = "Hola Cliente";
            byte[] DatosEnviar = respuesta.getBytes();
            
            InetAddress clientAddress = PaqueteRecibido.getAddress();
            int clientPort = PaqueteRecibido.getPort();
            
            DatagramPacket PaqueteSalida = new DatagramPacket(
                DatosEnviar, DatosEnviar.length, clientAddress, clientPort
            );
            serverSocket.send(PaqueteSalida);
        }
    }
}
