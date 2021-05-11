package wsyconan.image;

import java.io.Serializable;

public class RawImage implements Serializable {
    byte[] file;

    public RawImage(byte[] file){
        super();
        this.file = file;
    }

    public byte[] getFile(){
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
