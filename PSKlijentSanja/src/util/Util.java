/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author Sanja
 */
public class Util {

    private static Util instance;
    private String propFile;
    private InputStream inputStream;
    OutputStream output;
    private Properties prop;

    private Util() {
        propFile = "config.properties";
        prop = new Properties();
    }

    public static Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }

    public String getHost() {
        String host = null;
        try {
            inputStream = new FileInputStream(propFile);
            prop.load(inputStream);
            host = prop.getProperty("host");
         //   inputStream.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return host;

    }

    public int getPort() {
        int port = 0;
        try {

            inputStream = new FileInputStream(propFile);
            prop.load(inputStream);
            port = Integer.parseInt(prop.getProperty("port"));
            //inputStream.close();
        } catch (FileNotFoundException ex) {
             ex.printStackTrace();
        } catch (IOException ex) {
             ex.printStackTrace();
        }
        return port;
    }

    public void setHost(String host) {
        try {
            output = new FileOutputStream(propFile);
            prop.setProperty("host", host);
            prop.store(output, null);
            output.close();
        } catch (IOException ex) {
            throw new RuntimeException("Greska pri cuvanju konfiguracije");
        }

    }

    public void setPort(String port) {

        try {
            output = new FileOutputStream(propFile);
            prop.setProperty("port", port);
            prop.store(output, null);
            output.close();
        } catch (IOException ex) {
            throw new RuntimeException("Greska pri cuvanju konfiguracije");
        }
    }
}
