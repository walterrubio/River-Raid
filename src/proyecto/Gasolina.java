package proyecto;

import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Gasolina {
    int posx;
    int posy;
    Image fuel;
    public Gasolina(int posx,int posy){
        this.posx=posx;
        this.posy=posy;
        
            try{
            fuel = ImageIO.read(new File("src/imagenes/fuel.png"));
        }
        catch(IOException e){
            System.out.println("No se encontro la imagen");
        }  
    }
    
        Rectangle2D area(){
        return new Rectangle2D.Double(posx, posy, 55, 46);
    }
}
