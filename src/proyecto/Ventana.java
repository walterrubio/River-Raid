package proyecto;

import java.applet.AudioClip;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana extends JFrame {
    AudioClip s_theme;
    public Ventana(){
        
        
        s_theme = java.applet.Applet.newAudioClip(getClass().getResource("/proyecto/s_theme.wav"));
        s_theme.loop();
        super.setTitle("River Raid");
        super.setSize(700,500);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icono=new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage();
        super.setIconImage(icono);
        Inicio i = new Inicio();
        add(i);        
        super.setVisible(true);
    }

    public static void main(String[] args) {       
        new Ventana();
    }  
}


