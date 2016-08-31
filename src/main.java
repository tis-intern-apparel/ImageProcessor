import java.io.File;
import java.io.IOException;
import imageprocessor.*;

/**
 * Created by garicchi on 16/08/31.
 */
public class main {
    public static void main(String args[]){
        try {
            ImageProcessor.GrayScale(new File("picture2.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
