package proyecto;

import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import static proyecto.TiposLetras.letras;
import static proyecto.bounds.limite;

public class Inicio extends JPanel implements bounds,TiposLetras{  
    Instrucciones i;
    Image portada;
    JButton b_jugar, b_inst, b_top, b_creditos, b_salir;
   
    public Inicio(){
        
        setLayout(null);       
        i = new Instrucciones();       
        super.setLocation(0, 0);
        super.setSize(700,500);
        
        try{
            portada = ImageIO.read(new File("src/imagenes/riverraid.png"));
        }
        catch(IOException e){
            System.err.println("No se encontro la imagen: "+e);
        }
      
        b_jugar = new JButton("Jugar");
        b_jugar.setBounds(xbutton, 50, anchobutton, altbutton);
        b_jugar.setBackground(Color.yellow);
        b_jugar.addMouseListener(escuchante);        
        
        b_inst = new JButton("Instrucciones");
        b_inst.setBounds(xbutton, 125, anchobutton, altbutton);
        b_inst.setBackground(Color.YELLOW);
        b_inst.addMouseListener(escuchante);
        
        b_top = new JButton("Top 10");
        b_top.setBounds(xbutton, 300, anchobutton, altbutton);
        b_top.setBackground(Color.ORANGE);
        b_top.addMouseListener(escuchante);        
        
        b_creditos = new JButton("Creditos");
        b_creditos.setBounds(xbutton, 370, anchobutton, altbutton);
        b_creditos.setBackground(Color.PINK);
        b_creditos.addMouseListener(escuchante);        
        
        b_salir = new JButton("Salir");
        b_salir.setBounds(xbutton, 430, anchobutton, altbutton);
        b_salir.setBackground(Color.RED);
        b_salir.addMouseListener(escuchante);        
                
        add(b_jugar);
        add(b_inst);
        add(b_top);
        add(b_creditos);
        add(b_salir);
        
        super.setVisible(true);      
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;       
        g2.drawImage(portada, 0, 0, this);
    }   
    MouseListener escuchante = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent ae) {
            if(ae.getSource()==b_jugar){                 
                 PedirUsuario ped = null;
                try {
                    ped = new PedirUsuario();
                } catch (IOException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }

                 Inicio.super.removeAll();
                 Inicio.super.add(ped);
                 Inicio.super.revalidate();
                 Inicio.super.repaint();

             }
             if(ae.getSource()==b_inst){                 
                 Instrucciones inst = new Instrucciones();

                 Inicio.super.removeAll();
                 Inicio.super.add(inst);
                 Inicio.super.revalidate();
                 Inicio.super.repaint();

             } 
             if(ae.getSource()==b_top){
                 Top t = null;
                try {
                    t = new Top();
                } catch (IOException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }

                 Inicio.super.removeAll();
                 Inicio.super.add(t);
                 Inicio.super.revalidate();
                 Inicio.super.repaint();                   

             } 
             if(ae.getSource()==b_creditos){
                 Creditos cred = new Creditos();

                 Inicio.super.removeAll();
                 Inicio.super.add(cred);
                 Inicio.super.revalidate();
                 Inicio.super.repaint();                  

             }
             if(ae.getSource()==b_salir){
                 System.exit(0);
             }}

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent ae) {
            
        }

        @Override
        public void mouseEntered(MouseEvent ae) {
            if(ae.getSource()==b_jugar){                 
                b_jugar.setBackground(Color.YELLOW.darker());
             }
             if(ae.getSource()==b_inst){                 
                b_inst.setBackground(Color.YELLOW.darker());
             } 
             if(ae.getSource()==b_top){
                b_top.setBackground(Color.ORANGE.darker());
             } 
             if(ae.getSource()==b_creditos){
                b_creditos.setBackground(Color.PINK.darker());
             }
             if(ae.getSource()==b_salir){
                b_salir.setBackground(Color.RED.darker());
             }
        }

        @Override
        public void mouseExited(MouseEvent ae) {
            if(ae.getSource()==b_jugar){                 
                b_jugar.setBackground(Color.YELLOW);
             }
             if(ae.getSource()==b_inst){                 
                b_inst.setBackground(Color.YELLOW);
             } 
             if(ae.getSource()==b_top){
                b_top.setBackground(Color.ORANGE);
             } 
             if(ae.getSource()==b_creditos){
                b_creditos.setBackground(Color.PINK);
             }
             if(ae.getSource()==b_salir){
                b_salir.setBackground(Color.RED);
             }
        }
    };
    /*ActionListener escuchante = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
              if(ae.getSource()==b_jugar){                 
                  PedirUsuario ped = new PedirUsuario();
                  
                  Inicio.super.removeAll();
                  Inicio.super.add(ped);
                  Inicio.super.revalidate();
                  Inicio.super.repaint();
                  
              }
              if(ae.getSource()==b_inst){                 
                  Instrucciones inst = new Instrucciones();
                  
                  Inicio.super.removeAll();
                  Inicio.super.add(inst);
                  Inicio.super.revalidate();
                  Inicio.super.repaint();
                  
              } 
              if(ae.getSource()==b_top){
                  Top t = new Top();
                  
                  Inicio.super.removeAll();
                  Inicio.super.add(t);
                  Inicio.super.revalidate();
                  Inicio.super.repaint();                   
                  
              } 
              if(ae.getSource()==b_creditos){
                  Creditos cred = new Creditos();
                  
                  Inicio.super.removeAll();
                  Inicio.super.add(cred);
                  Inicio.super.revalidate();
                  Inicio.super.repaint();                  
                  
              }
              if(ae.getSource()==b_salir){
                  System.exit(0);
              }                                 
        }
        
    };   */
}

class PedirUsuario extends JPanel{
    Image portada;
    JButton b_volver, b_aceptar;
    JTextField t_usu;
    
    public PedirUsuario() throws IOException{        
        setLayout(null);
        super.setSize(700,500);
        super.setLocation(0,0);
        CrearDoc doc2=new CrearDoc();
        doc2.Contarlineas();
        try{
            portada = ImageIO.read(new File("src/imagenes/screen_cred.jpg"));
        }
        catch(IOException e){
            System.err.println("No se encontro la imagen: "+e);
        }
        
        t_usu = new JTextField("Nickname",20);
        t_usu.setFont(letras);
        t_usu.setBounds(255, 205, 200, 70);
        t_usu.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                if(t_usu.getText().length()==limite){
                    ke.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }
        });
        
        b_aceptar = new JButton("Aceptar");
        b_aceptar.setBounds(300, 300, 90, 20);
        b_aceptar.setBackground(Color.yellow);
        b_aceptar.addActionListener(escuchante);
        
        b_volver = new JButton("Volver");
        b_volver.setBounds(25, 420, 70, 35);
        b_volver.setBackground(Color.yellow);
        b_volver.addActionListener(escuchante);
        
        add(t_usu);
        add(b_aceptar);
        add(b_volver);   
        CrearDoc doc1=new CrearDoc();
  
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
            
            if(ae.getSource()==b_aceptar){
                
                String user=t_usu.getText();
               // t_usu.setText(user); 
                Framejug jugabilidad=new Framejug();
                jugabilidad.correr();
                System.out.println(user);
                
                
            }
            
            if(ae.getSource()==b_volver){               
                  Inicio i = new Inicio();
                  b_volver.setBackground(Color.YELLOW);
                  PedirUsuario.super.removeAll();
                  PedirUsuario.super.add(i);
                  PedirUsuario.super.revalidate();
                  PedirUsuario.super.repaint();                               
            }
        }
    };  
    
public String User() throws IOException{
    String user = null;
    System.out.println(user);
    return user;
}

}
