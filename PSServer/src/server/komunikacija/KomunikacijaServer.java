/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.TransferObjekat;

/**
 *
 * @author Aleksandar
 */
public class KomunikacijaServer {

   
    private Socket soket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public KomunikacijaServer(Socket s) throws IOException {
        soket = s;
        out = new ObjectOutputStream(soket.getOutputStream());
        in = new ObjectInputStream(soket.getInputStream());
    }

    public void posalji(TransferObjekat transfer) throws RuntimeException {
        try {
            out.writeObject(transfer);
        } catch (IOException ex) {
            throw new RuntimeException("Greska");
        }
    }

    public TransferObjekat primi() throws IOException, ClassNotFoundException {
        return (TransferObjekat) in.readObject();
    }

}
