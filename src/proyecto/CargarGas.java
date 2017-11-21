/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author walter.rubio
 */
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
