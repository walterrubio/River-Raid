/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author jose.valduz
 */
public class Framejug extends JFrame{

    public Framejug() {
        super.setTitle("River Raid");
        super.setSize(700,500);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icono=new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage();
        super.setIconImage(icono);
        Inicio i = new Inicio();
        Instrucciones inst = new Instrucciones();

       
    }
    public void correr(){
        Jugar jug = new Jugar();
        jug.t.start();

        
        add(jug);   
        

        super.setVisible(true);
    }
    
}
