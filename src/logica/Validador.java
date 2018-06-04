/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.swing.JOptionPane;

/**
 *
 * @author mavt9
 */
public class Validador {
    public boolean validarScriptInsertar (String consulta){
        String[] partesEnter = consulta.split("\n");
        String[] parteUno = partesEnter[0].split(" ");
        
      
        if(parteUno[0].equalsIgnoreCase("create")){
            System.out.println("es create");
        }else if (parteUno[0].equalsIgnoreCase("insert")){
            System.out.println("Insert");
        }else if(parteUno[0].equalsIgnoreCase("select")){
            System.out.println("Select");
        }else{
            JOptionPane.showMessageDialog(null, "No es una sentencia Valida!","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        return true;
    }
}
