
package proyecto;

import java.awt.TextField;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextArea;

/**
 *
 * @author jose.valduz
 */
public class CrearDoc {
    String Archivo="Data.txt";
        private JTextArea texto;

    public CrearDoc() throws FileNotFoundException, IOException {
        try {
            File f = new File("Datos.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            br.close();
            fr.close();
            } catch (IOException ex) {
           
        }
          
    }
    public void Rellenar(String linea) throws IOException{
          File f = new File("Datos.txt");
            FileWriter fw = new FileWriter(f,true);
            BufferedWriter bw = new BufferedWriter(fw);
            fw.append(linea+" ");
            fw.close();
    }
    public void Rellenar(int Puntuacion) throws IOException{
          File f = new File("Datos.txt");
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);
            fw.append(Puntuacion+"\r\n");
            bw.newLine(); 
            fw.close();
    }
    public int Contarlineas() throws FileNotFoundException, IOException{
        File f = new File("Datos.txt");
            FileReader fw = new FileReader(f);
            BufferedReader bw = new BufferedReader(fw);
            int numlineas=0;
            while((bw.readLine())!=null){
                numlineas++;
            }
            fw.close();
            System.out.println(numlineas);
            return numlineas;
    }
    public String Imprimirlineas() throws FileNotFoundException, IOException{
        String Datoslineas = null;
         File f = new File("Datos.txt");
            FileReader fw = new FileReader(f);
            BufferedReader bw = new BufferedReader(fw);
            Datoslineas=bw.readLine();
            texto=new JTextArea("Mejore Jugadores: ",50,150);
            texto.setSize(500,500);
           // texto.setEditable(false);
            while(Datoslineas!=null){
                System.out.println(Datoslineas+"");
                texto.setText(texto.getText()+Datoslineas);
                Datoslineas=bw.readLine();
            }
           
            fw.close();
        return Datoslineas;  
    }

    public JTextArea getTexto() {
        return texto;
    }
    
}
