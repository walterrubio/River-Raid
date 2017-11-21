package proyecto;

import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Instrucciones extends JPanel {
    
    Image portada;
    JTextArea inst;
    JButton b_volver;
    JLabel l_mov, l_disp, l_fuel, l_jugador, l_enem;
    
    public Instrucciones(){
        setLayout(null);
        super.setSize(700,500);
        super.setLocation(0,0);
      
        try{
            portada = ImageIO.read(new File("src/imagenes/screen_inst.jpg"));
        }
        catch(IOException e){
            System.err.println("No se encontro la imagen: "+e);
        }
        
        inst = new JTextArea("\t         El juego consiste acumular la mayor cantidad de puntos en un minuto,\n"+ 
                "               para acumular puntos hay que destruir los enemigos que aparezcan en el mapa evitando chocar\n"+
                "\t         contra las riveras del rio y evitando dispararle a los tanques de gasolina.");
        inst.setBounds(50,50,1000,1000);
        inst.setEditable(false);
        inst.setOpaque(false);
        inst.setFont(new Font("", Font.BOLD, 12));
        inst.setForeground(Color.black);
      
        b_volver = new JButton("Volver");
        b_volver.setBounds(25, 420, 70, 35);
        b_volver.setBackground(Color.YELLOW);
        b_volver.addActionListener(escuchante);
        
        l_mov = new JLabel("Movimiento");
        l_mov.setBounds(540,190,70,70);
        l_mov.setForeground(Color.black);
        
        l_disp = new JLabel("Disparar");
        l_disp.setBounds(390,225,70,70);
        l_disp.setForeground(Color.black);        
        
        l_jugador = new JLabel("Jugador");
        l_jugador.setBounds(260,205,70,70); 
        l_jugador.setForeground(Color.black);         
        
        l_fuel = new JLabel("Gasolina");
        l_fuel.setBounds(165,200,70,70); 
        l_fuel.setForeground(Color.black);          
        
        l_enem = new JLabel("Enemigo");
        l_enem.setBounds(465,350,70,70); 
        l_enem.setForeground(Color.black);          
      
        add(b_volver);
        add(inst);
        add(l_mov);
        add(l_disp);
        add(l_jugador);
        add(l_fuel);
        add(l_enem);
        
        super.setVisible(true);    
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
                  Inicio i = new Inicio();
                  
                  Instrucciones.super.removeAll();
                  Instrucciones.super.add(i);
                  Instrucciones.super.revalidate();
                  Instrucciones.super.repaint();
        }
    };     
}
