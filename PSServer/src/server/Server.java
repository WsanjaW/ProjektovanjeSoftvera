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
 * Pokretanje servera
 * 
 * @author Sanja
 */
public class Server {
    
    
    public static  void pokreniServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("pokrenut");
            while (true) {                
                Socket klientSocket = serverSocket.accept();
                KlijentNit k = new KlijentNit(klientSocket);
                k.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
