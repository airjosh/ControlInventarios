/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.controladores;

import com.empresa.modelo.Producto;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Darina Michelle Escobar López
 * @author Axel Nicolás Marin Marinez
 * @author Kury Juárez Garcia
 * @author Humberto Garcia Bacilio
 * @author Miguel Ángel Rodríguez Núñez
 * @author Fabián Enrique Moreno Noriega
 */
public class EliminarProductos {
    
    private JPanel panelEliminar;
    private final static String EMPTY_STRING = "";

    public EliminarProductos() {
        if (this.panelEliminar == null){
            this.panelEliminar = new JPanel();
        }
    }

    public EliminarProductos(JPanel panel) {
        this.panelEliminar = panel;
    }

    public void limpiarCampos() {
        for (Component c : this.panelEliminar.getComponents()) {
            if (c instanceof JTextField) { 
                ((JTextField) c).setText(EMPTY_STRING);
            }
        }
    }

    public boolean unProducto(DefaultTableModel modelo, ArrayList<Producto> productosTabla) {
       
        int indice = 0;
         
        for (Component c : this.panelEliminar.getComponents()) {
            if (c instanceof JTextField) { 
                 if ( ((JTextField) c).getName().equals("eliminarText") ) {
                     
                    if( ((JTextField) c).getText().isEmpty() ){
                            return false;
                    }
                     
                    indice = Integer.valueOf( ((JTextField) c).getText() );
                     
                    if(indice > productosTabla.size() || indice <= 0 ) {
                       JOptionPane.showMessageDialog(null, "¡No hay datos que mostrar!.");
                       limpiarCampos();
                       return false;
                    }
                     
                    productosTabla.remove(indice - 1);
                    modelo.removeRow(indice - 1);
                    
                 }
            }
        }
        
        return true;
        
    }
    
    
    
}
