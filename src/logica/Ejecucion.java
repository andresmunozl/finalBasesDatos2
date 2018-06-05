package logica;

import datos.Archivo;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * @author Jorge Andres Cordoba
 */
public class Ejecucion {

    Archivo archivo = new Archivo();
    
    //inicio Create
    public void crearTabla(String lineaNombre,String consultaAux) throws IOException{
        String nombre = nombreTabla(lineaNombre);
        
        if (archivo.existeArchivo(nombre)) {
            System.out.println("EL ARCHIVO YA EXISTE");
            archivo.escribirArchivo(nombre, dividirConsulta(consultaAux));
            
        }
        else{
            archivo.crearArchivo(nombre);
            
            archivo.escribirArchivo(nombre, dividirConsulta(consultaAux));
            System.out.println("ya");
        }       
    }
    
    
    private String nombreTabla(String consulta){
        String[] partesAux = consulta.split(" ");
        ArrayList<String> partes = limpiarVector(partesAux);
        String nombre = partes.get(2);
        
        return nombre;
    }
    
    private ArrayList<String> dividirConsulta(String consulta){
        String[] camposAux = consulta.split("\n");
        String llavePrimaria = "";
        ArrayList<String> campos = new ArrayList<>();
 
        for (int i = 0; i < camposAux.length; i++) {
            
            if (!camposAux[i].equals("(") && !camposAux[i].equals(")") && camposAux[i].contains("(") == false) {
                campos.add(camposAux[i]);
            }
            
            if (camposAux[i].contains("(") && camposAux[i].contains(")")) {
                llavePrimaria = camposAux[i].substring(camposAux[i].indexOf('(')+1,camposAux[i].indexOf(')')) ;
            }
            
        }
        
        campos = dividirCampos(campos);
        for (int i = 0; i < campos.size(); i++) {
            System.out.println("["+i+"]"+campos.get(i));
        }
        
        
        return campos;
    }
       
    private ArrayList<String> dividirCampos(ArrayList<String> aux){
        ArrayList<String> campos = new ArrayList<>();
        ArrayList<String> camposAux = new ArrayList<>();
        
        
        for (int i = 0; i < aux.size(); i++) {
            String[] vector = aux.get(i).split(" ");
            camposAux = limpiarVector(vector);
            
            campos.add(camposAux.get(0)+"-"+camposAux.get(1));
        }
               
        return campos;
    }
    
    
    
    
 
    //fin create
    
    
    
    
    
    
    private ArrayList<String> limpiarVector(String[] vector){
        ArrayList<String> partes = new ArrayList<>();
        
        for (int i = 0; i < vector.length; i++) {
            if (vector[i].length() > 0){
                partes.add(vector[i]);
            }           
        }
        return partes;
    }
    
}
