package com.gimnasio.modelo;

import java.util.ArrayList;
import java.util.List;

public class Entrenador extends Persona implements Reservable {
    private String especialidad;
    private final List<String> horarios = new ArrayList<>();

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
        horarios.add(horario);
        System.out.println(nombre + " reservó horario de clase: " + horario
                + " (" + especialidad + ")");
    }

    @Override
    public void cancelar(String horario) {
        if (horarios.remove(horario)) {
            System.out.println(nombre + " canceló su clase de " + horario);
        } else {
            System.out.println(nombre + " no tiene clase en " + horario);
        }
    }

    @Override
    public String toString() {
        return presentarse() + " | Especialidad: " + especialidad
                + " | Cuota mensual: " + Gimnasio.dinero(calcularCuotaMensual());
    }
}

