package proyecto;

import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class CargarGas extends JPanel {
    int posx;
    int posy;
    public CargarGas(){
        
        posx = 666;
        posy = 442;
    }
    
    Rectangle2D area(){
        return new Rectangle2D.Double(posx, posy, 5, 20);
    }      
    
}
