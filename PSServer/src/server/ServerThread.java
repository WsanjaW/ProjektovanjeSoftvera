/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JLabel;
import util.Util;

/**
 *
 * @author Sanja
 */
class ServerThread implements Runnable {

    JLabel serverLabel;
    JButton pokreniB;
    boolean kraj;
    public ServerThread(JLabel serverLabel,JButton pokreniB) {
        this.serverLabel = serverLabel;
        this.pokreniB = pokreniB;
        this.kraj = false;
    }

    @Override
    public void run() {
        try {
            int port = Integer.parseInt(Util.getInstance().getPort());
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("pokrenut");
            serverLabel.setText("Server pokrenut");
            pokreniB.setEnabled(false);
            while (!kraj) {                
                Socket klientSocket = serverSocket.accept();
                KlijentNit k = new KlijentNit(klientSocket);
                k.start();
            }
            serverSocket.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void zaustavi() {
        kraj = true;
    }

}
