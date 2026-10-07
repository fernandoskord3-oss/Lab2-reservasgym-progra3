package com.gimnasio.modelo;

public abstract class Persona {
    protected String nombre;
    protected String carnet;
    protected String correo;

    public Persona(String nombre, String carnet, String correo) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String presentarse() {
        return nombre + " (Carnet: " + carnet + ")";
    }

    // Método abstracto: cada rol calcula su cuota de forma distinta
    public abstract double calcularCuotaMensual();
}

