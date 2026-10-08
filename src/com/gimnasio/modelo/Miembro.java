package com.gimnasio.modelo;

import java.util.ArrayList;
import java.util.List;

public class Miembro extends Persona implements Reservable {
    protected final List<Reserva> reservas = new ArrayList<>();

    public Miembro(String nombre, String carnet, String correo) {
        super(nombre, carnet, correo);
    }

    @Override
    public double calcularCuotaMensual() {
        return Gimnasio.CUOTA_MENSUAL;
    }

    public double calcularCuotaDiaria() {
        return Gimnasio.CUOTA_DIARIA;
    }

    // Sobrecarga 1: reserva individual (1 persona)
    @Override
    public void reservar(String horario) {
        reservar(horario, 1);
    }

    // Sobrecarga 2: reserva para varias personas (misma clase, distinta firma)
    public void reservar(String horario, int cantidadPersonas) {
        if (cantidadPersonas < 1) {
            System.out.println(nombre + ": la reserva debe ser para al menos 1 persona");
            return;
        }
        if (buscarReserva(horario) != null) {
            System.out.println(nombre + " ya tiene una reserva en " + horario);
            return;
        }
        // Costo = pase diario del socio + un adicional por cada persona extra
        double costo = calcularCuotaDiaria()
                + (cantidadPersonas - 1) * Gimnasio.PRECIO_PERSONA_ADICIONAL;
        Reserva reserva = new Reserva(horario, cantidadPersonas, costo);
        reservas.add(reserva);
        System.out.println(nombre + " reservó " + reserva);
    }

    @Override
    public void cancelar(String horario) {
        Reserva reserva = retirarReserva(horario);
        if (reserva == null) {
            System.out.println(nombre + " no tiene reserva en " + horario);
            return;
        }
        double penalizacion = reserva.getCosto() * Gimnasio.PORCENTAJE_PENALIZACION;
        double reembolso = reserva.getCosto() - penalizacion;
        System.out.println(nombre + " canceló " + horario
                + " | Reserva de " + reserva.descripcionPersonas()
                + ": " + Gimnasio.dinero(reserva.getCosto())
                + " | Penalización: " + Gimnasio.dinero(penalizacion)
                + " | Reembolso: " + Gimnasio.dinero(reembolso));
    }

    public double calcularTotalReservas() {
        double total = 0;
        for (Reserva r : reservas) {
            total += r.getCosto();
        }
        return total;
    }

    public int cantidadReservas() {
        return reservas.size();
    }

    protected Reserva buscarReserva(String horario) {
        for (Reserva r : reservas) {
            if (r.getHorario().equals(horario)) {
                return r;
            }
        }
        return null;
    }

    protected Reserva retirarReserva(String horario) {
        Reserva reserva = buscarReserva(horario);
        if (reserva != null) {
            reservas.remove(reserva);
        }
        return reserva;
    }

    @Override
    public String toString() {
        return presentarse()
                + " | Cuota mensual: " + Gimnasio.dinero(calcularCuotaMensual())
                + " | Cuota diaria: " + Gimnasio.dinero(calcularCuotaDiaria());
    }
}
