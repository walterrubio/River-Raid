package proyecto;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class Balas extends JPanel {
    int posx;
    int posy;
    
    public Balas(){        
        int posx=5000;
        int posy=5000;
        
    }  
    Rectangle2D area(){
        return new Rectangle2D.Double(posx, posy, 5, 20);
    }             
}
