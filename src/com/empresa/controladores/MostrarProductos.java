/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.controladores;

import com.empresa.modelo.Producto;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Team 1
 */
public class MostrarProductos {
    
    
    private JPanel panelMostrar;

    public MostrarProductos() {
        if (this.panelMostrar == null){
            this.panelMostrar = new JPanel();
        }
    }

    public MostrarProductos(JPanel panel) {
        this.panelMostrar = panel;
    }
    
    public void cantidadProductos(ArrayList<Producto> productosTabla) {
        for (Component c : panelMostrar.getComponents()) { 
            if (c instanceof JTextField) { 
               ((JTextField) c).setText("" + productosTabla.size() );      
            }
         }
    }
}
