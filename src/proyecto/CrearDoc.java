
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
 * Clase que se utiliza la rellenar el archivo .txt con el usuario y la puntuacion
 * @author walter.rubio y Jose Valduz
 */
public class CrearDoc {
    String Archivo="Data.txt";
        private JTextArea texto;
/**
 * Genera el archivo
 * @throws FileNotFoundException Se utiliza en caso de que no se encuentre el documento
 * @throws IOException Se utiliza en caso de que no exista el documento
 */
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
    /**
     * guarda el usuario dentro dentro archivo
     * @param linea Usuario que proviene del JTextFiel
     * @throws IOException Se utiliza en caso de que no exista el documento
     */
    public void Rellenar(String linea) throws IOException{
          File f = new File("Datos.txt");
            FileWriter fw = new FileWriter(f,true);
            BufferedWriter bw = new BufferedWriter(fw);
            fw.append(linea+" ");
            fw.close();
    }
    /**
     * Guarda la puntuacion dentro del archivo
     * @param Puntuacion El valor de la puntuacion obtenida
     * @throws IOException Se utiliza en caso de que no exista el documento
     */
    public void Rellenar(int Puntuacion) throws IOException{
          File f = new File("Datos.txt");
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);
            fw.append(Puntuacion+"\r\n");
            bw.newLine(); 
            fw.close();
    }
    /**
     * Cuenta las lineas que tiene el documento
     * @return Retorna el numero de lineas que tiene el documento
     * @throws FileNotFoundException Se utiliza en caso de que no se encuentre el archivo
     * @throws IOException Se utiliza en caso de que no exista el archivo
     */
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
    /**
     * Muestra dentro del JTextArea el usuario y la puntuacion
     * @return Los datos que posee la linea
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public String Imprimirlineas() throws FileNotFoundException, IOException{
        String Datoslineas = null;
         File f = new File("Datos.txt");
            FileReader fw = new FileReader(f);
            BufferedReader bw = new BufferedReader(fw);
            Datoslineas=bw.readLine();
            texto=new JTextArea("Mejore Jugadores: ",50,150);
            texto.setSize(500,500);
            while(Datoslineas!=null){
                System.out.println(Datoslineas+"");
                texto.setText(texto.getText()+Datoslineas);
                Datoslineas=bw.readLine();
            }
           
            fw.close();
        return Datoslineas;  
    }
    /**
     * 
     * @return Devuelve el JTextArea 
     */
    public JTextArea getTexto() {
        return texto;
    }
    
}
