package wsyconan.server;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import wsyconan.image.Image;

public class Handler implements Runnable {
    InputStream inputStream;
    OutputStream outputStream;
    final Path storage = Path.of("storage");
    Logger logger = LoggerFactory.getLogger(Handler.class);

    public Handler(InputStream inputStream, OutputStream outputStream) {
        super();
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream objectIS = new ObjectInputStream(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);
            Object inputObject = objectIS.readObject();
            if (!(inputObject instanceof Image)) {
                printWriter.println("You are not sending a Image");
            } else {
                Image image = (Image) inputObject;
                String name = System.currentTimeMillis() + "-" + image.getMetaDate().getImageName();
                Path filePath = storage.resolve(name);
                Files.write(filePath, image.getRawImage().getFile(), StandardOpenOption.CREATE);

                Thread.sleep(10000);
            }
            logger.info(Thread.currentThread().getName() + "got an Image.");
        } catch (ClassNotFoundException | IOException | InterruptedException e) {
            logger.error(e.getMessage());
        }
    }

}
