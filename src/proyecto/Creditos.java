package proyecto;

import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Creditos extends JPanel implements TiposLetras{   
    JTextArea t_cred, t_cred2, t_cred3, t_cred4;
    JButton b_volver;
    Image portada;
    
    public Creditos(){
        setLayout(null);
        super.setSize(700,500);
        super.setLocation(0,0);
        
        try{
            portada = ImageIO.read(new File("src/imagenes/screen_cred.jpg"));
        }
        catch(IOException e){
            System.err.println("No se encontro la imagen: "+e);
        }        
        
        t_cred = new JTextArea("UNIVERSIDAD NACIONAL EXPERIMENTAL DEL TACHIRA\n" +
"     DEPARTAMENTO DE INGENIERÍA EN INFORMÁTICA\n" +
"                   PROGRAMACIÓN I LAPSO 2017-1\n" +
"PROYECTO FINAL - 4 TA EVALUACIÓN 15% (100 PUNTOS)");
        
        t_cred.setOpaque(false);
        t_cred.setForeground(Color.black);
        t_cred.setFont(new Font("", Font.BOLD, 12));
        t_cred.setEditable(false);
        t_cred.setBounds(200, 20, 1000, 1000);
        
        t_cred2 = new JTextArea("Proyecto inspirado en el juego 'River Raid' diseñado en 1982 por la empresa Activision\n"+
                "para ser jugado en consolas y computadores personales de Atari Inc , tales como en\n"+
                "la consola Atari 2600 o en los microcomputadores de las series XL y XE.");    
       
        t_cred2.setOpaque(false);
        t_cred2.setForeground(Color.black);
        t_cred2.setFont(new Font("", Font.BOLD, 12));
        t_cred2.setEditable(false);        
        t_cred2.setBounds(100, 180, 1000, 1000);
        
        t_cred3 = new JTextArea("Desarrolladores:\n"+
                "José Valduz\n"+
                "Walter Rubio\n");
        
        t_cred3.setOpaque(false);
        t_cred3.setForeground(Color.black);
        t_cred3.setFont(new Font("", Font.BOLD, 12));
        t_cred3.setEditable(false);        
        t_cred3.setBounds(550, 370, 1000, 1000); 
        
        b_volver = new JButton("Volver");
        b_volver.setBounds(25, 420, 70, 35);
        b_volver.setBackground(Color.YELLOW);
        b_volver.addActionListener(escuchante);
               
        add(b_volver);
        add(t_cred);
        add(t_cred2);
        add(t_cred3);
        
    }  
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        g2.drawImage(portada, 0, 0, this);
    }     
    ActionListener escuchante = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
                  Inicio  i = new Inicio();
                  
                  Creditos.super.removeAll();
                  Creditos.super.add(i);
                  Creditos.super.revalidate();
                  Creditos.super.repaint();
        }
    };       
}