package com.gimnasio.modelo;

public class Administrador extends Persona {
    private String area;

    public Administrador(String nombre, String carnet, String correo, String area) {
        super(nombre, carnet, correo);
        this.area = area;
    }

    @Override
    public double calcularCuotaMensual() {
        return 0.0; // el administrador no paga cuota
    }

    @Override
    public String toString() {
        return presentarse() + " | Área: " + area
                + " | Cuota mensual: " + Gimnasio.dinero(calcularCuotaMensual());
    }
}

