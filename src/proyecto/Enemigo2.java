package proyecto;

import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
/**
 * Clase que genera el Enemigo del mapa
 * @author walter.rubio
 */
public class Enemigo2 {   
    int posx;
    int posy;
    Image enem2; 
    
    /**
     * Inicializa la posicion en el ejex x y en el eje y del Enemigo 2
     * @param posx
     * @param posy 
     */    
    public Enemigo2(int posx,int posy){
        this.posx=posx;
        this.posy=posy;
        
        try{
            enem2 = ImageIO.read(new File("src/imagenes/enemm2.png"));
        }
        catch(IOException e){
            System.out.println("No se encontro la imagen");
        }  
    /**
     * Genera el area del Enemigo 1 para detectar colisiones
     * @return Area del Enemigo 2
     */        
    }
    Rectangle2D area(){
        return new Rectangle2D.Double(posx, posy, 55, 46);
    }
    
}