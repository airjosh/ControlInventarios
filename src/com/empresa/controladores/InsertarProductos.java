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
 * @author Team 1
 */
public class InsertarProductos {
    
    private JPanel panelInsertar;
    private final static String EMPTY_STRING = "";


    public InsertarProductos() {
        if (this.panelInsertar == null){
            this.panelInsertar = new JPanel();
        }
    }

    public InsertarProductos(JPanel panel) {
        this.panelInsertar = panel;
    }

    public boolean validar( ) {
        
        boolean isCompleto = true;
       
        for (Component c : panelInsertar.getComponents()) {
            
             //System.out.println( "el componente es> " + c );
            if (c instanceof JTextField) { 
                if(((JTextField) c).getText().isEmpty()) {
                    isCompleto = false;
                }
            }
         }

        if (!isCompleto){
            JOptionPane.showMessageDialog(null, "No pueden existir campos vacios.");
        }
        return isCompleto;
    }

    public Producto accion() {
    
        Producto producto = new Producto();
        for (Component c : panelInsertar.getComponents()) {

            if (c instanceof JTextField) { 
                switch (((JTextField) c).getName()) {
                    case "nombreText":
                      producto.setNombre(((JTextField) c).getText() );
                      break;
                    case "descripcionText":
                        producto.setDescripcion(((JTextField) c).getText() );
                      break;
                    case "cantidadText":
                        // NumberFormatException
                        producto.setCantidad( Integer.parseInt(((JTextField) c).getText()) );
                        break;
                    case "precioText":
                        producto.setPrecio( Integer.parseInt(((JTextField) c).getText()) );
                        break;
                     default: break;
                  }
                
                
            }
         }
        return producto;
    }

    public void limpiarCampos() {
        for (Component c : this.panelInsertar.getComponents()) {
            if (c instanceof JTextField) { 
                ((JTextField) c).setText(EMPTY_STRING);
            }
        }
    }

    public void enModelo(DefaultTableModel modelo, ArrayList<Producto> productosTabla) {
        final Producto producto = productosTabla.get(productosTabla.size() - 1);
        int id = productosTabla.size();
        final Object[] row = new Object[]{String.valueOf(id), producto.getNombre(), 
                                          String.valueOf(producto.getPrecio()), 
                                          String.valueOf(producto.getCantidad()), 
                                          producto.getDescripcion()};
        modelo.addRow(row);
    }

}
