package wsyconan.image;

import java.io.Serializable;

public class Image implements Serializable {
    private RawImage rawImage;
    private ClientMetaData clientMetaData;

    public Image(RawImage rawImage, ClientMetaData clientMetaData){
        super();
        this.rawImage = rawImage;
        this.clientMetaData = clientMetaData;
    }

    public RawImage getRawImage(){ return rawImage; }

    public void setRawImage(RawImage rawImage){ this.rawImage = rawImage;}

    public ClientMetaData getMetaDate(){return this.clientMetaData;}

    public void setClientMetaData(ClientMetaData clientMetaData){
        this.clientMetaData = clientMetaData;
    }

}
