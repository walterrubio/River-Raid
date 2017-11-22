package proyecto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CrearDoc {
    String Archivo="Data.txt";
        

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
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);
            fw.append(linea+"\r\n");
            bw.newLine(); 
            fw.close();
    }
    public void Contarlineas() throws FileNotFoundException, IOException{
        File f = new File("Datos.txt");
            FileReader fw = new FileReader(f);
            BufferedReader bw = new BufferedReader(fw);
            int numlineas=0;
            while((bw.readLine())!=null){
                numlineas++;
            }
            fw.close();
            System.out.println(numlineas);
    }
}
