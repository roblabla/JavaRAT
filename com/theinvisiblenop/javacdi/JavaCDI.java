package com.theinvisiblenop.javacdi;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class JavaCDI {
    private static Map<String, ClientManager> clients;
    private static final int port = 12365;
    private static wrongOutput(String problem) {
        // For now, this will simply send an IllegalArgumentException, but
        // in the end, I should probably send the line back to the server
        // for debugging purposes
        throw new IllegalArgumentException(problem);
    }
    public static main(String[] args) {
        Socket socket = new Socket(arg[1], port);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream, "UTF-8"));
        PrintStream out = new PrintStream(socket.getOutputStream(), "UTF-8");
        boolean running = true;
        System.setOut(out);
        while (running) {
            String[] output = in.readLine().split(":");
            if (output.length() < 1) {
                JavaCDI.wrongOutput("Deeeeeeerp");
                continue; 
            }
            // Create new session
            if (output[0] == "c") {
                if (output.length() != 3) {
                    JavaCDI.wrongOutput("Deeeeeeerp");
                    continue; 
                }
                // Create a new client with the engine output[2], and append that client to
                // the client list
                JavaCDI.clients.put(output[1], new ClientManager(output[2]));
            }
            // Run String
            if (output[0] == "rs") {
                if (output.length() != 3) {
                    JavaCDI.wrongOutput("derp");
                }
                if (JavaCDI.clients.get(output[1]) == null) {
                    JavaCDI.wrongOutput("anotherDerp");
                }
                JavaCDI.clients.get(output[1]).addToQueue(output[2]);
            }
            // TODO : Run File
        }
    }
}
