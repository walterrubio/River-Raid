package proyecto;

import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 * Clase que indica la posicion original de la barra del combustible
 * @author walter.rubio y Jose Valduz
 */
public class CargarGas extends JPanel {
    int posx;
    int posy;
    /**
     * @param posx Inicializa la posicion del objeto en el eje x
     * @param posy Inicializa la posicion del objeto en el eje y
     */
    public CargarGas(){
        
        posx = 666;
        posy = 442;
    }
    /**
     * 
     * @return Retorna el area de la barra del combustible
     */
    Rectangle2D area(){
        return new Rectangle2D.Double(posx, posy, 5, 20);
    }      
    
}
