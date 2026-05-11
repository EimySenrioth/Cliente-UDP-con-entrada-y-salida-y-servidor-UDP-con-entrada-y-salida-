//SERVER UDP para Multiples - Clientes
//(Solo recibe datos) - DatagramSocket.receive()
package udp;
import java.net.*;

public class Server0{
    public static void main(String args[]) throws Exception{
        DatagramSocket serverSocket = new DatagramSocket(9090);
        byte DatosRecibir[];

        while(true) {
            DatosRecibir = new byte[1024];
            System.out.println("\nEsperando....");
            DatagramPacket PaqueteRecibido = 
                    new DatagramPacket(DatosRecibir, DatosRecibir.length);
            serverSocket.receive(PaqueteRecibido);

            String DatosRecibidos = new String(PaqueteRecibido.getData());
            System.out.println("Recibiendo: " + DatosRecibidos);
        }
    }
}
