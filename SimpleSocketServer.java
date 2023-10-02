import java.io.*;
import java.net.*;

public class SimpleSocketServer {
    public static void main(String[] args) {
        try {
            // Create a server socket that listens on port 8080
            ServerSocket serverSocket = new ServerSocket(8080);

            System.out.println("Server is listening on port 8080...");

            // Accept client connections
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client connected: " + clientSocket);

            // Create input and output streams for communication with the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read data from the client and send a response
            String message = in.readLine();
            System.out.println("Received from client: " + message);

            // Send a response back to the client
            out.println("Hello, client! Your message was: " + message);

            // Close the socket and streams
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
