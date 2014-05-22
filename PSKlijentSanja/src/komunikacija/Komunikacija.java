/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import transfer.TransferObjekat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Aleksandar
 */
public class Komunikacija {

    private static Komunikacija instance;
    private Socket soket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    private Komunikacija() throws IOException {
        soket = new Socket("127.0.0.1", 8189);
        out = new ObjectOutputStream(soket.getOutputStream());
        in = new ObjectInputStream(soket.getInputStream());
    }
    
    public static Komunikacija getInstance() throws IOException{
        if (instance == null) {
            instance = new Komunikacija();
        }
        return instance;
    }

    public void posalji(TransferObjekat transfer) throws IOException {
        out.writeObject(transfer);
    }

    public TransferObjekat primi() throws IOException, ClassNotFoundException {
        return (TransferObjekat) in.readObject();
    }

}
