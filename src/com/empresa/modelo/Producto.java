/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.modelo;

import java.io.Serializable;

/**
 *
 * @author Darina Michelle Escobar López
 * @author Axel Nicolás Marin Marinez
 * @author Kury Juárez Garcia
 * @author Humberto Garcia Bacilio
 * @author Miguel Ángel Rodríguez Núñez
 * @author Fabián Enrique Moreno Noriega
 */
public class Producto implements Serializable {
    
    
    // propiedades del producto
    private Integer id;
    private String descripcion;
    private String nombre;
    private Integer cantidad;
    private Integer precio;

    
    // constructor

    public Producto(Integer id, String descripcion, String nombre, Integer cantidad, Integer precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    public Producto(){
    }

    // getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

}
