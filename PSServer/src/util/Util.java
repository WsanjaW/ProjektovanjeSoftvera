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

    public String getPort() {
        String driver = null;
        try {
            inputStream = new FileInputStream(propFile);
            prop.load(inputStream);
            driver = prop.getProperty("port");
            //   inputStream.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return driver;
    }

    public String getDriver() {
        String driver = null;
        try {
            inputStream = new FileInputStream(propFile);
            prop.load(inputStream);
            driver = prop.getProperty("mysql_driver");
            //   inputStream.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return driver;
    }

    public String getConnectionUrl() {
        String url = null;
        try {
            inputStream = new FileInputStream(propFile);
            prop.load(inputStream);
            url = prop.getProperty("mysql_url") + prop.getProperty("mysql_db") + "?user=" + prop.getProperty("mysql_user") + "&password=" + prop.getProperty("mysql_password");
            //   inputStream.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return url;
    }

    public void setDriver(String driver) {
        try {
            output = new FileOutputStream(propFile);
            prop.setProperty("mysql_driver", driver);
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

    public void setUser(String user) {
        try {
            output = new FileOutputStream(propFile);
            prop.setProperty("mysql_user", user);
            prop.store(output, null);
            output.close();
        } catch (IOException ex) {
            throw new RuntimeException("Greska pri cuvanju konfiguracije");
        }
    }

    public void setPassword(String password) {
        try {
            output = new FileOutputStream(propFile);
            prop.setProperty("mysql_password", password);
            prop.store(output, null);
            output.close();
        } catch (IOException ex) {
            throw new RuntimeException("Greska pri cuvanju konfiguracije");
        }
    }

    public String getUser() {
        String user = null;
        try {
            inputStream = new FileInputStream(propFile);
            prop.load(inputStream);
            user = prop.getProperty("mysql_user");
            //   inputStream.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public String getPassword() {
        String pass = null;
        try {
            inputStream = new FileInputStream(propFile);
            prop.load(inputStream);
            pass = prop.getProperty("mysql_password");
            //   inputStream.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return pass;
    }
}
