/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author jose.valduz
 */
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
