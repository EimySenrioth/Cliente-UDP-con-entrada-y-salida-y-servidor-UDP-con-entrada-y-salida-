//Cliente para usar con Server0 multiples clientes
//(Solo manda Datos) - DatagramSocket.send()
package udp;
import java.net.*;
import java.util.Scanner;

public class Cliente1{
    public static void main(String args[]) throws Exception{
        Scanner Teclado = new Scanner(System.in);
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost"); //server
        //InetAddress IPAddress = InetAddress.getByName("Corei5Fco"); //server
        byte DatosEnviar[];
        boolean stop = false; String CadenaEnviar = "";

        //Enviando multiples paquetes al servidor
        while(!stop && !CadenaEnviar.equals("bye")){
            DatosEnviar = new byte[1024];
            System.out.println("Ingresa un texto o bye para salir: ");
            CadenaEnviar = Teclado.nextLine(); //Prepara datos enviar
            DatosEnviar = CadenaEnviar.getBytes(); //convertir a bytes los datos
            DatagramPacket PaqueteSalida = new DatagramPacket
                    (DatosEnviar, DatosEnviar.length, IPAddress, 9090);
            clientSocket.send(PaqueteSalida);
        }
        clientSocket.close();
    }
}
