package com.gimnasio.modelo;

import java.util.Locale;

// Datos de la empresa y tarifas del sistema
public final class Gimnasio {
    public static final String NOMBRE = "PowerFit Gym";

    public static final double CUOTA_MENSUAL = 30.0;            // membresía normal por mes
    public static final double CUOTA_DIARIA = 3.0;              // pase por día (1 persona)
    public static final double PRECIO_PERSONA_ADICIONAL = 2.0;  // cada persona extra en una reserva
    public static final double PORCENTAJE_PENALIZACION = 0.50;  // 50% del costo al cancelar (miembro normal)

    private Gimnasio() {
    }

    public static String dinero(double monto) {
        return "$" + String.format(Locale.US, "%.2f", monto);
    }
}


