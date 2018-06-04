package logica;
/*
 * @author Jorge Andres Cordoba
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Archivo {
    
    public static boolean crearArchivo(String nombre) throws FileNotFoundException, IOException{
        File archivo = new File("src\\persistencia\\"+nombre+".txt");
        
        return archivo.createNewFile();
    }
    
    public static void escribirArchivo(String nombre) throws IOException{
        String saludo="\n JAJAJAJAJA";
        File archivo = new File("src\\persistencia\\"+nombre+".txt");
       
        try (FileWriter escribir = new FileWriter(archivo,true)) {
            escribir.write(saludo);
            escribir.close();
        }
        
        
    }
    
    
    public static void leerArchivo(){
        
        
        
    }



}
