package com.gimnasio;

import com.gimnasio.modelo.Administrador;
import com.gimnasio.modelo.Entrenador;
import com.gimnasio.modelo.Gimnasio;
import com.gimnasio.modelo.Miembro;
import com.gimnasio.modelo.MiembroPremium;
import com.gimnasio.modelo.Persona;
import com.gimnasio.modelo.Reservable;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== " + Gimnasio.NOMBRE + " =====");
        System.out.println("Cuota mensual normal: " + Gimnasio.dinero(Gimnasio.CUOTA_MENSUAL)
                + " | Cuota diaria: " + Gimnasio.dinero(Gimnasio.CUOTA_DIARIA)
                + " | Persona adicional por reserva: "
                + Gimnasio.dinero(Gimnasio.PRECIO_PERSONA_ADICIONAL));

        Miembro ana = new Miembro("Ana López", "C-001", "ana@powerfit.com");
        Miembro diego = new Miembro("Diego Hernández", "C-002", "diego@powerfit.com");
        MiembroPremium carlos = new MiembroPremium("Carlos Pérez", "C-003", "carlos@powerfit.com");
        MiembroPremium sofia = new MiembroPremium("Sofía Martínez", "C-004", "sofia@powerfit.com");
        Entrenador marta = new Entrenador("Marta Ruiz", "C-005", "marta@powerfit.com", "CrossFit");
        Administrador luis = new Administrador("Luis Gómez", "C-006", "luis@powerfit.com", "Recepción");

        // Herencia + clase abstracta: arreglo polimórfico de Persona
        Persona[] personas = {ana, diego, carlos, sofia, marta, luis};
        System.out.println("\n--- Socios y personal ---");
        for (Persona p : personas) {
            System.out.println(p);
        }

        // Sobrecarga: reservar(horario) y reservar(horario, personas)
        System.out.println("\n--- Reservas ---");
        ana.reservar("Lunes 6:00 AM");
        ana.reservar("Martes 6:00 PM", 3);
        diego.reservar("Miércoles 7:00 AM", 2);
        carlos.reservar("Jueves 5:00 PM", 4);
        sofia.reservar("Viernes 8:00 AM");

        // Sobrescritura: cancelar() se comporta distinto según el tipo real
        System.out.println("\n--- Cancelaciones ---");
        ana.cancelar("Martes 6:00 PM");
        diego.cancelar("Miércoles 7:00 AM");
        carlos.cancelar("Jueves 5:00 PM");
        sofia.cancelar("Sábado 9:00 AM");

        // Interfaz usada de forma polimórfica
        System.out.println("\n--- Reservas por la interfaz Reservable ---");
        List<Reservable> reservables = List.of(diego, sofia, marta);
        for (Reservable r : reservables) {
            r.reservar("Sábado 10:00 AM");
        }

        System.out.println("\n--- Reservas activas por socio ---");
        Miembro[] socios = {ana, diego, carlos, sofia};
        for (Miembro m : socios) {
            System.out.println(m.getNombre() + ": " + m.cantidadReservas()
                    + " reserva(s) | Total: " + Gimnasio.dinero(m.calcularTotalReservas()));
        }
    }
}
