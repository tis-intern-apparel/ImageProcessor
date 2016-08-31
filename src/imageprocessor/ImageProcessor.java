package imageprocessor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by garicchi on 16/08/31.
 */
public class ImageProcessor {
    public static void Binarization(File image) throws IOException {

        BufferedImage read= ImageIO.read(image);
        int w = read.getWidth(),h=read.getHeight();
        BufferedImage write =
                new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        for(int y=0;y<h;y++){
            for(int x=0;x<w;x++){
                int c = read.getRGB(x, y);
                int r = r(c);
                int g = g(c);
                int b = b(c);
                int elem = _grayScale(r,g,b);
                if(elem > 127){
                    elem = 255;
                }else{
                    elem = 0;
                }
                int rgb = rgb(elem,elem,elem);
                write.setRGB(x,y,rgb);
            }
        }

        File f2 = new File(image.getAbsolutePath()+"_process.jpg");
        ImageIO.write(write, "jpg", f2);
    }

    public static void GrayScale(File image) throws IOException {

        BufferedImage read= ImageIO.read(image);
        int w = read.getWidth(),h=read.getHeight();
        BufferedImage write =
                new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        for(int y=0;y<h;y++){
            for(int x=0;x<w;x++){
                int c = read.getRGB(x, y);
                int r = r(c);
                int g = g(c);
                int b = b(c);
                int elem = _grayScale(r,g,b);
                int rgb = rgb(elem,elem,elem);
                write.setRGB(x,y,rgb);
            }
        }

        File f2 = new File(image.getAbsolutePath()+"_process.jpg");
        ImageIO.write(write, "jpg", f2);
    }

    private static int _grayScale(int r,int g,int b){
        // 合成比率 http://www7a.biglobe.ne.jp/~fairytale/article/program/graphics.html
        double rRate = 0.34;
        double gRate = 0.33;
        double bRate = 0.33;
        // 合成
        int elem = (int)Math.round(r*rRate + g*gRate + b*bRate);

        elem = (elem > 255) ? 255 : elem;
        return elem;
    }

    public static int a(int c){
        return c>>>24;
    }
    public static int r(int c){
        return c>>16&0xff;
    }
    public static int g(int c){
        return c>>8&0xff;
    }
    public static int b(int c){
        return c&0xff;
    }
    public static int rgb(int r,int g,int b){
        return 0xff000000 | r <<16 | g <<8 | b;
    }
    public static int argb(int a,int r,int g,int b){
        return a<<24 | r <<16 | g <<8 | b;
    }
}
