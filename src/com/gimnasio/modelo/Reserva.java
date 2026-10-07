package com.gimnasio.modelo;

public class Reserva {
    private final String horario;
    private final int personas;
    private final double costo;

    public Reserva(String horario, int personas, double costo) {
        this.horario = horario;
        this.personas = personas;
        this.costo = costo;
    }

    public String getHorario() {
        return horario;
    }

    public int getPersonas() {
        return personas;
    }

    public double getCosto() {
        return costo;
    }

    public String descripcionPersonas() {
        return personas + (personas == 1 ? " persona" : " personas");
    }

    @Override
    public String toString() {
        return horario + " | " + descripcionPersonas() + " | " + Gimnasio.dinero(costo);
    }
}

