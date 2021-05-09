package wsyconan.image;

import java.io.Serializable;

public class ClientMetaData implements Serializable {
    private String imageName;

    public ClientMetaData(String imageName){
        super();
        this.imageName = imageName;
    }

    public String getImageName(){ return this.imageName; }

    public void setImageName(String imageName){ this.imageName = imageName; }

}
