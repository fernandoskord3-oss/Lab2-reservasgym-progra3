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

    // Sobrescritura de nuevo: un premium cancela sin penalización
    @Override
    public void cancelar(String horario) {
        System.out.println(nombre + " (Premium) canceló " + horario
                + " | Sin penalización");
    }

    @Override
    public String toString() {
        return presentarse() + " | Cuota Premium: $" + calcularCuotaMensual();
    }
}
