package wsyconan.client;

import wsyconan.image.ClientMetaData;
import wsyconan.image.RawImage;
import wsyconan.image.Image;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    final static int port = 80;
    public static void main(String[] args){
        try (Socket socket = new Socket("127.0.0.1", port)){
            ObjectOutputStream objectOS = new ObjectOutputStream(socket.getOutputStream());
            Image image= new Image(new RawImage(new byte[]{1,2,3}),
                    new ClientMetaData("My Cat 1"));
            objectOS.writeObject(image);
            objectOS.writeObject(image);
            objectOS.flush();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
