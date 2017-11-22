package proyecto;

import java.awt.*;
import javax.swing.*;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Top extends JPanel{
    
    Image portada;
    JLabel usu;
    PedirUsuario p;
    JButton b_volver;
    /*private String[] datosd=null;*/
    public Top() throws IOException{
        
        setLayout(null);
        super.setSize(700,500);
        super.setLocation(0,0);
        p = new PedirUsuario();
        
        try{
            portada = ImageIO.read(new File("src/imagenes/screen_cred.jpg"));
        }
        catch(IOException e){
            System.err.println("No se encontro la imagen: "+e);
        }

        //usu = new JLabel(p.t_usu.getText());
        usu=new JLabel();
        usu.setBounds(255, 205, 200, 20);
        CrearDoc doc1=new CrearDoc();
        doc1.Imprimirlineas();
        usu.add(doc1.getTexto());
        /*datosd=doc1.Imprimirlineas();
        for (int i = 0; i < doc1.Contarlineas(); i++) {
            System.out.println(datosd[i]);
        }*/
        b_volver = new JButton("Volver");
        b_volver.setBounds(25, 420, 70, 35);
        b_volver.setBackground(Color.YELLOW);
        b_volver.addActionListener(escuchante);
        
        add(usu);
        add(b_volver);
              
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
            
            Top.super.removeAll();
            Top.super.add(i);
            Top.super.revalidate();
            Top.super.repaint();
        }
    }; 
}
