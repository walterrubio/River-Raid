package proyecto;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
/**
 *Clase que indica la posicion original de las balas en la pantalla 
 * @author walter.rubio y Jose Valduz
 */
public class Balas extends JPanel {
    int posx;
    int posy;
    
    public Balas(){        
        int posx=5000;
        int posy=5000;
        
    }  
    /**
     * Detecta el area de bala, mas adelante usada para la deteccion de colisiones
     * @return Retoar el area de las balas
     */
    Rectangle2D area(){
        return new Rectangle2D.Double(posx, posy, 5, 20);
    }             
}
