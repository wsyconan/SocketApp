package wsyconan.client;

import wsyconan.image.ClientMetaData;
import wsyconan.image.RawImage;
import wsyconan.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Main {
    final static int port = 80;

    public static void main(String[] args){
        String filename = "cat.jpg";
        String dir = "input/";
        try (Socket socket = new Socket("127.0.0.1", port)){
            ObjectOutputStream objectOS = new ObjectOutputStream(socket.getOutputStream());
            File file = new File(dir+filename);
            if(file.isFile()){
                FileInputStream fileInputStream = new FileInputStream(file);
                Image image = new Image(new RawImage(fileInputStream.readAllBytes()),
                        new ClientMetaData(filename));
                objectOS.writeObject(image);
                objectOS.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
