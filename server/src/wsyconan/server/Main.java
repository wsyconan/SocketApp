package wsyconan.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import wsyconan.image.Image;

public class Main {
    final static int port = 80;

    public static void main(String[] args) {
        Socket accpted;
        try(ServerSocket socket = new ServerSocket(port)){
            System.out.println("Waiting for connection...");
            accpted = socket.accept();
            System.out.println("Connection established");
            InputStream inputStream = accpted.getInputStream();
            ObjectInputStream objectIS = new ObjectInputStream(inputStream);
            Object inputObj = objectIS.readObject();
            if(!(inputObj instanceof Image)){
                System.out.println("Image.");
            } else {
                Image image = (Image) inputObj;
                System.out.println("Image name: " +
                        image.getMetaDate().getImageName());
            }
            String res = new String(inputStream.readAllBytes());
            //System.out.println("Received" + res);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
