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
public class EditarProductos {
    
    private JPanel panelEditar;
    private final static String EMPTY_STRING = "";

    public EditarProductos() {
        if (this.panelEditar == null){
            this.panelEditar = new JPanel();
        }
    }

    public EditarProductos(JPanel panel) {
        this.panelEditar = panel;
    }
    
    public void limpiarCampos() {
        JPanel panelEditable = null;
        for (Component c : this.panelEditar.getComponents()) {
            if (c instanceof JTextField) { 
                ((JTextField) c).setText(EMPTY_STRING);
            }
            if(c instanceof JPanel){
                panelEditable = (JPanel) c;
                
                for (Component inner : panelEditable.getComponents()) {
                    if (inner instanceof JTextField) { 
                        ((JTextField) inner).setText(EMPTY_STRING);
                    }                    
                }
                
            }
        }
    }
    
    public void mostrarUnProducto(ArrayList<Producto> productosTabla) {
        
        Producto productoEditable = null;
        JPanel panelEditable = null;
        
        for (Component c : panelEditar.getComponents()) {

            if (c instanceof JTextField) { 
               if ( ((JTextField) c).getName().equals("id") ) {
                   
                   if( ((JTextField) c).getText().isEmpty() ){
                       return;
                   }
                   if(productosTabla.size() <= 0) {
                       JOptionPane.showMessageDialog(null, "¡No hay datos que mostrar!.");
                       limpiarCampos();
                       return;
                   }
                   
                   int indice = Integer.parseInt( ((JTextField) c).getText() );
                   
                   if(indice > productosTabla.size()) {
                       JOptionPane.showMessageDialog(null, "¡No hay datos que mostrar!.");
                       limpiarCampos();
                       return;
                   }
                   if(indice <= 0){
                       JOptionPane.showMessageDialog(null, "¡No hay productos con ese numero!.");
                       limpiarCampos();
                       return;
                   }
                   productoEditable = productosTabla.get(indice -1);                           
               }
            }
            
            if(c instanceof JPanel){
                panelEditable = (JPanel) c;
            }
            
         }//end for1
        
        for (Component innerPanel : panelEditable.getComponents()) {

            if (innerPanel instanceof JTextField) { 
                switch ( ((JTextField) innerPanel).getName() ) {
                    case "nombreEditar":
                      ((JTextField) innerPanel).setText( productoEditable.getNombre() );
                      break;
                    case "descripcionEditar":
                        ((JTextField) innerPanel).setText( productoEditable.getDescripcion() );
                      break;
                    case "cantidadEditar":
                        // NumberFormatException
                        ((JTextField) innerPanel).setText( String.valueOf( productoEditable.getCantidad())  );
                        break;
                    case "precioEditar":
                        ((JTextField) innerPanel).setText( String.valueOf( productoEditable.getPrecio() )  );
                        break;
                     default: break;
                }
            }
        }// end for2
        
    }// end unProducto

    public boolean unProducto(DefaultTableModel modelo, ArrayList<Producto> productosTabla) {
        Producto productoEditable = null;
        JPanel panelEditable = null;
        int indice = 0;
        
        if( validarCamposAntesDeModificarlos() ) {

            for (Component c : panelEditar.getComponents()) {
                if (c instanceof JTextField) { 
                    if ( ((JTextField) c).getName().equals("id") ) {
                        indice = Integer.valueOf( ((JTextField) c).getText() );
                        productoEditable = productosTabla.get(indice -1);
                   }                   
                }
                if(c instanceof JPanel){
                    panelEditable = (JPanel) c;
                }    
            }// end for 1
            
            for (Component innerPanel : panelEditable.getComponents()) {
                if (innerPanel instanceof JTextField) { 
                    switch ( ((JTextField) innerPanel).getName() ) {
                        case "nombreEditar":
                            productoEditable.setNombre( ((JTextField) innerPanel).getText() );
                            break;
                        case "descripcionEditar":
                            productoEditable.setDescripcion(((JTextField) innerPanel).getText() );
                            break;
                        case "cantidadEditar":
                            // NumberFormatException
                            productoEditable.setCantidad( Integer.parseInt(((JTextField) innerPanel).getText()) );
                            break;
                        case "precioEditar":
                            productoEditable.setPrecio( Integer.parseInt(((JTextField) innerPanel).getText()) );                                
                            break;
                         default: break;
                    }//end switch
                }
            }// end for 2
            
            final Object[] row = new Object[]{String.valueOf(indice), productoEditable.getNombre(), String.valueOf(productoEditable.getPrecio()), String.valueOf(productoEditable.getCantidad()), productoEditable.getDescripcion()};
            productosTabla.add(indice - 1, productoEditable);
            productosTabla.remove(indice);
            modelo.insertRow(indice - 1, row);
            modelo.removeRow(indice);

        } else {
            JOptionPane.showMessageDialog(null, "¡Ingrese un numero de producto!.");
            return false;
        }
        return true;
    }
    
    private boolean validarCamposAntesDeModificarlos(){
        
        for (Component c : panelEditar.getComponents()) {
            if (c instanceof JTextField) { 
               if ( ((JTextField) c).getName().equals("id") ) {
                    if( ((JTextField) c).getText().isEmpty() ){
                       return false;
                   }
               }
            }
        }
        
        return true;
    }
    
}
