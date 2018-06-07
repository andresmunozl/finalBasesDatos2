package logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author mavt9
 */
public class Validador {
    
    Ejecucion ejecutar = new Ejecucion();
    
    public boolean validarScript (String consulta) throws IOException{
        
        if(consulta.length() > 0){
            String[] partesEnter = consulta.split("\n");
            String[] parteUnoAux = partesEnter[0].split(" ");

           
            
            ArrayList<String> parteUno = limpiarVector(parteUnoAux);

            if(parteUno.get(0).equalsIgnoreCase("create")){
                ejecutar.crearTabla(partesEnter[0],consulta.substring(consulta.indexOf('(')+1,consulta.length()-1));
                
            }else if (parteUno.get(0).equalsIgnoreCase("insert")){
                System.out.println("Insert");
            }else if(parteUno.get(0).equalsIgnoreCase("select")){
                System.out.println("Select");
                if(ejecutar.validarSelect(partesEnter[1])){
                    boolean bandAsterisco =  ejecutar.validarAsterisco(partesEnter[0]);
                    boolean tieneWhere = false;
                    if(partesEnter.length > 2)
                        tieneWhere = true;
                    
                    ArrayList<String> resultado;
                    
                    if(bandAsterisco && !tieneWhere)
                    {
                        resultado = ejecutar.generarconsulta1(partesEnter[1]);
                    }
                    
                        JOptionPane.showMessageDialog(null, "Tiene Asterisco: "+bandAsterisco);
                        JOptionPane.showMessageDialog(null, "Tiene where: "+tieneWhere);
                        
                }else{
                    JOptionPane.showMessageDialog(null, "NO EXISTE TABLA SOLICITADA");
                }
                    
            }else{
                JOptionPane.showMessageDialog(null, "No es una sentencia Valida!","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "POR FAVOR DIGITE EL SCRIPT A EJECUTAR","PRECAUCION",JOptionPane.INFORMATION_MESSAGE);
        }
        return true;
    }
    
    private ArrayList<String> limpiarVector(String [] vector){
        ArrayList<String> partes = new ArrayList<>();
        
        for (int i = 0; i < vector.length; i++) {
            if (vector[i].length() > 0){
                partes.add(vector[i]);
            }           
        }
        return partes;
    }
    
}
