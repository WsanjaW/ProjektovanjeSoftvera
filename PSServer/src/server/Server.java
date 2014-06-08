/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aleksandar
 */
public class Server {
    
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("pokrenut");
            while (true) {                
                Socket klientSocket = serverSocket.accept();
                Klijent k = new Klijent(klientSocket);
                k.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
