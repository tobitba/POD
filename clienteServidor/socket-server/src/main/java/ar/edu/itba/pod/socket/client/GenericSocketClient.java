package ar.edu.itba.pod.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/*La idea del Ej2 es implementar en el server todos los servicios del GenericService
* Para eso deberíamos analizar el request del cliente y ver que comando quiere ejecutar
* podríamos usar una máquina de estados
* No lo voy a hacer xd... (no lo hicimos en clase igual)*/
    public class GenericSocketClient {

        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public void startConnection(String ip, int port) throws IOException {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }

        public String sendMessage(String msg) throws IOException {
            out.println(msg);
            String resp = in.readLine();
            return resp;
        }

        public void stopConnection() throws IOException {
            in.close();
            out.close();
            clientSocket.close();
        }
    }
