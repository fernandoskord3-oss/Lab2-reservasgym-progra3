package com.gimnasio.modelo;

// Herencia multinivel: MiembroPremium -> Miembro -> Persona
public class MiembroPremium extends Miembro {
    private static final double DESCUENTO = 0.20; // 20% de descuento

    public MiembroPremium(String nombre, String carnet, String correo) {
        super(nombre, carnet, correo);
    }

    @Override
    public double calcularCuotaMensual() {
        return super.calcularCuotaMensual() * (1 - DESCUENTO);
    }

    @Override
    public double calcularCuotaDiaria() {
        return super.calcularCuotaDiaria() * (1 - DESCUENTO);
    }

    // Sobrescritura de nuevo: el premium cancela sin penalización y con reembolso total
    @Override
    public void cancelar(String horario) {
        Reserva reserva = retirarReserva(horario);
        if (reserva == null) {
            System.out.println(nombre + " (Premium) no tiene reserva en " + horario);
            return;
        }
        System.out.println(nombre + " (Premium) canceló " + horario
                + " | Reserva de " + reserva.descripcionPersonas()
                + ": " + Gimnasio.dinero(reserva.getCosto())
                + " | Sin penalización | Reembolso: " + Gimnasio.dinero(reserva.getCosto()));
    }

    @Override
    public String toString() {
        return presentarse() + " | PREMIUM"
                + " | Cuota mensual: " + Gimnasio.dinero(calcularCuotaMensual())
                + " | Cuota diaria: " + Gimnasio.dinero(calcularCuotaDiaria());
    }
}

