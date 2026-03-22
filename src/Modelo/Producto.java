/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author chris
 */
public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int cantidad;

/*
 * Crea un producto “vacío” (valores por defecto: 0, null, etc.). 
 * Útil si primero construyes el objeto y luego rellenas con setters o leyendo 
 * de la interfaz.
 */
    public Producto() {
    }

/*
 * Para cuando ya tienes id 
 * (por ejemplo fila leída de la base de datos o edición de un registro existente).
 */
    public Producto(int id, String nombre, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

/*
 *  Para un producto nuevo: nuestra base de datos el id es auto_increment, 
 * solo se asigna nombre, precio y cantidad. El id queda en 0 hasta que se actualice 
 * al guardar o al leer lo que devolvió la BD.
 */ 
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

//Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
