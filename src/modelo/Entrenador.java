package com.gimnasio.modelo;

public class Entrenador extends Persona implements Reservable {
    private String especialidad;

    public Entrenador(String nombre, String carnet, String correo, String especialidad) {
        super(nombre, carnet, correo);
        this.especialidad = especialidad;
    }

    @Override
    public double calcularCuotaMensual() {
        return 0.0; // el entrenador no paga cuota
    }

    @Override
    public void reservar(String horario) {
        System.out.println(nombre + " reservó horario de clase: " + horario
                + " (" + especialidad + ")");
    }

    @Override
    public void cancelar(String horario) {
        System.out.println(nombre + " canceló su clase de " + horario);
    }

    @Override
    public String toString() {
        return presentarse() + " | Especialidad: " + especialidad;
    }
}

