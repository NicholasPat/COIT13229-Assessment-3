package client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.*;

import common.model.Account;
/**
 * This class is used like a session handler, or a cookie. It will hold current
 * information sent from the server plus any other flags needed. 
 * 
 * @author Brodie Lucht 
 */
public class Session {
    /* Session Information */
    private Account user;
    private PublicKey publicKey;
    
    /* Connection */
    private static final int serverPort = 6811;
    private static final String hostName = "localhost" ; 
    
    private Socket socket ; 
    public ObjectOutputStream objOut; 
    public ObjectInputStream objIn;
    private final static Session instance = new Session();
    
    public static Session getSession() {
        return instance;
    }
    
    /**
     * Upon initializing the program, will attempt connecting to the server and if 
     * it fails, then throw an error and then exit the program
     */
    public Session() { 
        initialiseConnection();
    }
    
    /** 
     * Starts up the connection to the server, if fails, simply returns a generic 
     * IO error 
     */
    public void initialiseConnection() { 
        try {
            //Generate Socket and the Input / Output Data Streams 
            socket = new Socket(hostName, serverPort);
            objOut =new ObjectOutputStream( socket.getOutputStream() );
            objIn = new ObjectInputStream( socket.getInputStream() );
            
            //If PublicKey is not set, then request it. 
            if (publicKey == null) {
                objOut.writeObject("PublicKey");
                setPublicKey();
            }

        } catch (UnknownHostException e){ System.out.println("Sock:"+e.getMessage()); 
        } catch (EOFException e){  System.out.println("EOF: Did not recieve responce from server.");
        } catch (IOException e){ System.out.println("IO:"+e.getMessage());
        }
    }
    
    /**
     * Get the Public Key from the server and set the publicKey variable 
     */
    private void setPublicKey() { 
        try { 
            publicKey = (PublicKey) objIn.readObject();
            
            //Bottom code: Only necessary for Data streams. 
            
            //dataOut.writeUTF("Public key please") ; 
            //int pubKeyLength = objIn.readInt() ; 
            //byte[] bytesPublicKey = new byte[pubKeyLength] ; 
            //objIn.readFully(bytesPublicKey, 0, pubKeyLength) ; 
            
            //X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(bytesPublicKey) ; 
            //KeyFactory keyFactory = KeyFactory.getInstance("RSA") ; 
            
            //publicKey = keyFactory.generatePublic(pubKeySpec) ; 
        } catch (IOException e) {System.out.println("IO:"+e.getMessage());
        } catch (ClassNotFoundException e) {System.out.println("CNF:"+e.getMessage());
        }
    }

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }  
}
