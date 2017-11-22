package proyecto;

import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Enemigo {   
    int posx;
    int posy;
    Image enem; 
    
    public Enemigo(int posx,int posy){
        this.posx=posx;
        this.posy=posy;       
        try{
            enem = ImageIO.read(new File("src/imagenes/enemm.png"));
        }
        catch(IOException e){
            System.out.println("No se encontro la imagen");
        }  
    }
    Rectangle2D area(){
        return new Rectangle2D.Double(posx, posy, 55, 46);
    }   
}
