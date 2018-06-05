package datos;
/*
 * @author Jorge Andres Cordoba
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {
    
    public boolean crearArchivo(String nombre) throws FileNotFoundException, IOException{
        File archivo = new File("src\\persistencia\\"+nombre+".txt");
        
        return archivo.createNewFile();
    }
    
    public void escribirArchivo(String nombre,ArrayList<String> datos) throws IOException{
        
        File archivo = new File("src\\persistencia\\"+nombre+".txt");
       
        try (FileWriter escribir = new FileWriter(archivo,true)) {
            
            for (int i = 0; i < datos.size(); i++) {
                escribir.write(datos.get(i));
                
            }
            escribir.write("\n");
            escribir.close();
        }
         
    }
    
     public ArrayList<String> leerArchivo(String nombre) throws FileNotFoundException, IOException {
        String cadena;
        ArrayList<String> datos = new ArrayList<>();
        
        FileReader f = new FileReader("src\\persistencia\\"+nombre+".txt");
        BufferedReader b = new BufferedReader(f);
        int i = 0;
        while((cadena = b.readLine())!=null) {
            datos.add(cadena);
            i++;
        }
        b.close();
        
        return datos;
    }
     
    public boolean existeArchivo(String nombre){
        File archivo = new File("src\\persistencia\\"+nombre+".txt");
        
        return archivo.exists();
    }
}
