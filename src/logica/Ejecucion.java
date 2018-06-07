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
        String[] camposAux = consulta.split(",");
        System.out.println("CONSULTA \n"+consulta);
        
        ArrayList<String> campos = new ArrayList<>();
        campos = limpiarVector(camposAux);
       
        campos = dividirCampos(campos);
        
        for (int i = 0; i < campos.size(); i++) {
            System.out.println("["+i+"]"+campos.get(i));
        }
        
        return campos;
     
    }
       
    private ArrayList<String> dividirCampos(ArrayList<String> aux){
        ArrayList<String> campos = new ArrayList<>();
        ArrayList<String> camposAux;
        
        for (int i = 0; i < aux.size(); i++) {
            String[] vector = aux.get(i).split(" ");
            
            camposAux = limpiarVector(vector);
            camposAux = limpiarArray(camposAux);
            
            if (camposAux.size() > 0) {
                campos.add(camposAux.get(0)+"-"+camposAux.get(1)+",");
            }
            
            
        }
   
        return campos;
    }
     
 
    //fin create
    
    
    // METODOS PARA VALIDAR LA CONSULTA SELECT 
    
    public ArrayList<String> generarconsulta1 (String nombreTabla) throws IOException
    {
        return archivo.leerArchivo(nombreTabla);
    }
    
    
    public boolean validarSelect(String cadena) throws IOException{
        String[] nombre = cadena.split(" ");
        
        if(archivo.existeArchivo(nombre[1]))
        {
            return true;
        }
        else
            return false;
        
    }
    public boolean validarAsterisco(String cadena)
    {
        String[] select = cadena.split(" ");
        if(select[1].equals("*"))
            return true;
        else
            return false;
    }
    
    //FIN METODOS PARA VALIDAR CONSULTA SELECT 
    
    
    
    
    private ArrayList<String> limpiarVector(String[] vector){
        ArrayList<String> partes = new ArrayList<>();
        
        for (int i = 0; i < vector.length; i++) {
            if (vector[i].length() > 0){
                partes.add(vector[i]);
            }           
        }
        return partes;
    }
    
    private ArrayList<String> limpiarArray(ArrayList<String> aux){
        ArrayList<String> partes = new ArrayList<>();
        
        for (int i = 0; i < aux.size(); i++) {
            if (aux.get(i).length() > 0 && aux.get(i).equals("\n") == false){
                partes.add(aux.get(i));
            }           
        }
        return partes;
    }
    
}
