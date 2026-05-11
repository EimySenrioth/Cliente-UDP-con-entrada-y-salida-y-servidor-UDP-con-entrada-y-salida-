package udp_envio_recepcion;
import java.net.*;

public class ServerUDPEnviarRecibir {
    public static void main(String args[]) throws Exception {
        // Puerto 9091 para evitar conflictos con los anteriores
        DatagramSocket serverSocket = new DatagramSocket(9091);
        byte[] buffer = new byte[1024];
        
        System.out.println("Servidor UDP (Enviar/Recibir) iniciado en el puerto 9091...");
        
        while(true) {
            DatagramPacket packetRecibido = new DatagramPacket(buffer, buffer.length);
            serverSocket.receive(packetRecibido);
            
            String mensaje = new String(packetRecibido.getData(), 0, packetRecibido.getLength());
            System.out.println("Mensaje recibido: " + mensaje);
            
            String respuesta = "Hola Cliente";
            byte[] datosRespuesta = respuesta.getBytes();
            
            InetAddress clientAddress = packetRecibido.getAddress();
            int clientPort = packetRecibido.getPort();
            
            DatagramPacket packetRespuesta = new DatagramPacket(
                datosRespuesta, datosRespuesta.length, clientAddress, clientPort
            );
            serverSocket.send(packetRespuesta);
        }
    }
}
