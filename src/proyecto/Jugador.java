package proyecto;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Jugador {
    
    Image jugador;
    int posx;
    int posy;
    int num_vidas;
    int puntuacion;
    int gasolina;
    
    public Jugador(){
        posx = 330;
        posy = 418;
        num_vidas = 4;
        puntuacion = 0;
        gasolina = 1000;
        
        try{
            jugador = ImageIO.read(new File("src/Imagenes/jugador.png"));
        }
        catch(IOException e){
            System.out.println("No se encontro la imagen");
        }        
    }
    
    Rectangle2D area(){
        return new Rectangle2D.Double(posx, posy, 40, 51);
    }

    public int getPuntuacion() {
        return puntuacion;
    }
    
}
