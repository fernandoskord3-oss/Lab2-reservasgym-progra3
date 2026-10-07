package com.gimnasio.modelo;

public class Miembro extends Persona implements Reservable {
    protected static final double CUOTA_BASE = 25.0;
    protected static final double PENALIZACION_CANCELACION = 5.0;

    public Miembro(String nombre, String carnet, String correo) {
        super(nombre, carnet, correo);
    }

    @Override
    public double calcularCuotaMensual() {
        return CUOTA_BASE;
    }

    // Sobrecarga 1: reserva individual
    @Override
    public void reservar(String horario) {
        System.out.println(nombre + " reservó " + horario + " (1 persona)");
    }

    // Sobrecarga 2: reserva para un grupo (mismo nombre, distinta firma)
    public void reservar(String horario, int cantidadPersonas) {
        System.out.println(nombre + " reservó " + horario
                + " para " + cantidadPersonas + " personas");
    }

    @Override
    public void cancelar(String horario) {
        System.out.println(nombre + " canceló " + horario
                + " | Penalización: $" + PENALIZACION_CANCELACION);
    }

    @Override
    public String toString() {
        return presentarse() + " | Cuota: $" + calcularCuotaMensual();
    }
}
