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
        String[] partes = consulta.split(" ");
        
        if(partes[0].equalsIgnoreCase("create")){
            System.out.println("es create");
        }else if (partes[0].equalsIgnoreCase("insert")){
            System.out.println("Insert");
        }else if(partes[0].equalsIgnoreCase("select")){
            System.out.println("Select");
        }else{
            JOptionPane.showMessageDialog(null, "No es una sentencia Valida!","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        for (int i = 0; i < partes.length; i++) {
            //System.out.println(partes[i]);
        }
        return true;
    }
}
