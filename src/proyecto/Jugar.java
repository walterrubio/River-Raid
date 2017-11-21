package proyecto;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Jugar extends JPanel{
/*String Datos="";*/
    float cont_tiempo;
    Image pastoi, pastod, mar, barragas;    
    Jugador j;
    Enemigo e;
    Enemigo2 e2;    
    Gasolina gas;
    CargarGas cg;
    CrearDoc Guardar;
    Balas b;
    AudioClip s_expj, s_expe, s_shot, s_reload, s_expg;
    Timer t, tt, ttt;
    Random n;

    
    ActionListener escuchante3 = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ee) {
            
                if(e.posx>=144)
                    e.posx-=10;
                
                if(e.posx<=143){
                    ttt.stop();
                    tt.start();}
            
              repaint(); 
        }
    };    
    
    ActionListener escuchante2 = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ee) {
                
                if(e.posx<=495)
                    e.posx+=10;
                
                if(e.posx>=494){
                    tt.stop();
                    ttt.start();}
                
                if(e2.posx<0){
                    e2.posx=610;
                    e2.posy=Aleatorio2();
                }                
            
              repaint(); 
        }
    };
    
    ActionListener escuchante = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            boolean ha = e.area().intersects(j.area());
            boolean be = e.area().intersects(b.area());
            boolean be2 = e2.area().intersects(b.area());            
            boolean ga = gas.area().intersects(j.area());
            boolean bg = b.area().intersects(gas.area());
           
            e.posy+=5;
            b.posy-=20;
            gas.posy++;
            j.gasolina-=2; 
            cont_tiempo+=0.02;
            
            e2.posx-=5;            
            
            System.out.println("Vidas"+j.num_vidas);
            System.out.println("Gas"+j.gasolina);
            System.out.println("Tiempo"+cont_tiempo);            
            //System.out.println(j.gasolina);
            
            if(e.posy>=500){              
               e.posy=-50;
               e.posx = Aleatorio();                                                    
            }
            
            if(ha==true){
               e.posy=-50;
               e.posx = Aleatorio();
               j.num_vidas--;   
               s_expj.play();                
            }
            
            if(be==true){
               b.posy=-50;
               e.posy=-50;
               e.posx = Aleatorio();             
               j.puntuacion+=100;
               s_expe.play();               
            }
            
            if(be2==true){
               b.posy=-50;
               e2.posx=610;
               e2.posy=Aleatorio2();       
               j.puntuacion+=150;
               s_expe.play();               
            }              
            
            if(ga==true){
                gas.posx = Aleatorio();
                gas.posy=-100;
                j.gasolina=1000;
                s_reload.play();                
            }
            
            if(gas.posy>=500){              
               gas.posy=-50;
               gas.posx = Aleatorio();                                                    
            }
            
            if(bg==true){
                b.posy=-50;
                gas.posy=-50;
                gas.posx = Aleatorio();
                if(j.puntuacion>0)
                j.puntuacion-=50;                
            }
            
            if(e.posy==5)   
                tt.start();
            
            if(j.gasolina<0){ //------------------------------------------
                j.num_vidas--;//------------------------------------------
                j.gasolina=1000;//------------------------------------------
                s_expj.play();//------------------------------------------
            }
            
            if(j.gasolina>450)
                cg.posx=666;            
            
            if(j.gasolina<450)
                cg.posx=640;
                
            if(j.gasolina<300)
                cg.posx=615;                
                
            if(j.gasolina<150)
                cg.posx=590;                
                
            if(j.gasolina<0)
                cg.posx=565;
            
            if(j.num_vidas==0){
                JOptionPane.showMessageDialog(null, "Perdiste: "+j.puntuacion+"pts");
                System.exit(0);                
            }

            if(cont_tiempo>=3){
                JOptionPane.showMessageDialog(null, "Ganaste: "+j.puntuacion+"pts");                                                
            }
            
                        if(j.num_vidas==0){
                try {
                    PedirUsuario user= new PedirUsuario();
                    String Usua;
                    Usua=user.User();
                    Guardar=new CrearDoc();
                    int puntu =j.puntuacion;
                    String puntuacion=String.valueOf(puntu);
                    String datof=Usua+"-"+puntuacion;
                    Guardar.Rellenar(datof);
                } catch (IOException ex) {
                    Logger.getLogger(Jugar.class.getName()).log(Level.SEVERE, null, ex);
                }
             
             
            System.exit(0);
            }


            repaint();
        }
    };
    public Jugar() {

        setLayout(null);

        j = new Jugador();
        e = new Enemigo(Aleatorio(),0);  
        e2 = new Enemigo2(610,Aleatorio2());
        b = new Balas();
        gas = new Gasolina(Aleatorio(),0);
        cg = new CargarGas();
        
        super.setSize(700, 500);
        super.setLocation(0, 0);
        super.setBackground(Color.BLUE);
        super.addKeyListener(teclas);
        super.setFocusable(true);

        s_expj = java.applet.Applet.newAudioClip(getClass().getResource("/proyecto/s_expj.wav"));//------------------------------------------
        s_shot = java.applet.Applet.newAudioClip(getClass().getResource("/proyecto/s_shot.wav"));//------------------------------------------
        s_expe = java.applet.Applet.newAudioClip(getClass().getResource("/proyecto/s_expe.wav"));//------------------------------------------
        s_expg = java.applet.Applet.newAudioClip(getClass().getResource("/proyecto/s_expg.wav"));  //------------------------------------------
        s_reload = java.applet.Applet.newAudioClip(getClass().getResource("/proyecto/s_reload.wav"));
        try {
            pastoi = ImageIO.read(new File("src/imagenes/pasto.jpg"));
        } catch (IOException e) {
            System.out.println("No se encontro la imagen");
        }

        try {
            pastod = ImageIO.read(new File("src/imagenes/pasto.jpg"));
        } catch (IOException e) {
            System.out.println("No se encontro la imagen");
        }

        try {
            mar = ImageIO.read(new File("src/imagenes/mar22.jpg"));
        } catch (IOException e) {
            System.out.println("No se encontro la imagen");
        }
        
        try {
            barragas = ImageIO.read(new File("src/imagenes/barragas.png"));
        } catch (IOException e) {
            System.out.println("No se encontro la imagen");
        }         
        
        t = new Timer(20, escuchante);
        tt = new Timer(20, escuchante2);
        ttt = new Timer(20, escuchante3);
        cont_tiempo = 0;        

        
        super.setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(mar, 0, -1, this);
        g2.drawImage(j.jugador, j.posx, j.posy, this);
        g2.drawImage(pastoi, 0, -1, this);
        g2.drawImage(pastod, 550, -1, this);
        g2.fill(cg.area());
        g2.drawImage(barragas, 565, 435, this);        
        g2.drawImage(e.enem, e.posx, e.posy, this);
        g2.drawImage(e2.enem2, e2.posx, e2.posy, this);          
        g2.fill(b.area());
        g2.drawImage(gas.fuel, gas.posx, gas.posy, this);  

        
        

    }
    public int Aleatorio(){
        int aleatorio=(int)(Math.random()*(495-144+1)+144);
        return aleatorio;
    }
    public int Aleatorio2(){
        int aleatorio=(int)(Math.random()*(300-0+1)+0);
        return aleatorio;
    }     

    KeyListener teclas = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                j.posx += 6;
                if (j.posx > 520) {
                    s_expj.play();
                    j.posx = 330;
                    j.num_vidas--;
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                j.posx -= 6;
                if (j.posx < 131) {
                    s_expj.play();
                    j.posx = 330;
                    j.num_vidas--;
                    System.out.println(j.num_vidas);
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
                    b.posx=j.posx+18;
                    b.posy=j.posy-15;
                    s_shot.play();                    
                
            } 
            if (ke.getKeyCode() == KeyEvent.VK_UP) {
                e.posy+=10;
                gas.posy+=5;
            } 
            
            /*if(j.num_vidas==0){
                try {
                    PedirUsuario user= new PedirUsuario();
                    String Usua=user.User();
                    Guardar=new CrearDoc();
                    int puntu =j.puntuacion;
                    String puntuacion=String.valueOf(puntu);
                    String datof=Usua+"-"+puntuacion;
                    Guardar.Rellenar(datof);
                } catch (IOException ex) {
                    Logger.getLogger(Jugar.class.getName()).log(Level.SEVERE, null, ex);
                }
             
             
            System.exit(0);
            }*/
            repaint();
        }
        @Override
        public void keyReleased(KeyEvent ke) {
        }
    };
  /*  public void GuardarDatos(String datos){
        //debe ser cuando haya terminado el juego, ahora solo debe guardarse en un documento, hacer metodo en el que al terminar el juego lea el ultimo puntaje, y si es mayor los organize y lo añada
        Jugador j=new Jugador();
        Inicio i=new Inicio();
        String Datos;
        Datos=datos+"-"+j.getPuntuacion();
        System.out.println(Datos);
    }*/

}

