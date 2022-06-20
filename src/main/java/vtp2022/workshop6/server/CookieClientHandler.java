package vtp2022.workshop6.server;

import java.io.IOError;
import java.io.IOException;
import java.net.Socket;

public class CookieClientHandler implements Runnable{

    private Socket socket;
    private String cookieFile;

    public CookieClientHandler(Socket s, String cookieFile){
        this.socket = s;
        this.cookieFile = cookieFile;
    }

    @Override
    public void run(){
        System.out.println("Starting a client thread");
        try{
            NetworkIO netIO = new NetworkIO(socket);
            String req = "";
            while(!req.equals("exit")){
                req = netIO.read();
                System.out.printf("[client] %s\n", req);
                if(req.trim().equals("exit"))
                    break; 
                // TODO implement the random cookie then return the string
                //client
                netIO.write("");   
            }

            netIO.close();
            socket.close();
            System.out.println("Exiting the thread!");
        }catch(IOException e){
            //TODO Auto-generated catch block
            e.printStackTrace();

        }
    }
    
}
