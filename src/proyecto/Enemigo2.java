package proyecto;

import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Enemigo2 {   
    int posx;
    int posy;
    Image enem2; 
    
    public Enemigo2(int posx,int posy){
        this.posx=posx;
        this.posy=posy;
        /*posy = 0;
        posx = (int)(Math.random()*(495-144+1)+144);*/
        
        try{
            enem2 = ImageIO.read(new File("src/imagenes/enemm2.png"));
        }
        catch(IOException e){
            System.out.println("No se encontro la imagen");
        }  
    }
    
  /*  public Enemigo(int pox, int posy, JFrame frame )
    {
        frame
    }*/
    Rectangle2D area(){
        return new Rectangle2D.Double(posx, posy, 55, 46);
    }
    
}