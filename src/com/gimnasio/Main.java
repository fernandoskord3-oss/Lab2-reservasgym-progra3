package com.gimnasio;

import com.gimnasio.modelo.Administrador;
import com.gimnasio.modelo.Entrenador;
import com.gimnasio.modelo.Miembro;
import com.gimnasio.modelo.MiembroPremium;
import com.gimnasio.modelo.Persona;
import com.gimnasio.modelo.Reservable;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Miembro ana = new Miembro("Ana López", "C-001", "ana@correo.com");
        MiembroPremium carlos = new MiembroPremium("Carlos Pérez", "C-002", "carlos@correo.com");
        Entrenador marta = new Entrenador("Marta Ruiz", "C-003", "marta@correo.com", "CrossFit");
        Administrador luis = new Administrador("Luis Gómez", "C-004", "luis@correo.com", "Recepción");

        // Herencia + clase abstracta: arreglo polimórfico de Persona
        Persona[] personas = {ana, carlos, marta, luis};
        for (Persona p : personas) {
            System.out.println(p);
        }

        System.out.println();

        // Sobrecarga
        ana.reservar("Lunes 6:00 AM");
        ana.reservar("Lunes 6:00 AM", 3);

        // Sobrescritura: mismo método, comportamiento distinto por tipo real
        ana.cancelar("Lunes 6:00 AM");
        carlos.cancelar("Martes 7:00 AM");

        System.out.println();

        // Interfaz usada de forma polimórfica
        List<Reservable> reservables = new ArrayList<>();
        reservables.add(ana);
        reservables.add(marta);
        for (Reservable r : reservables) {
            r.reservar("Miércoles 5:00 PM");
        }
    }
}


