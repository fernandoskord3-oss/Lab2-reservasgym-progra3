package com.gimnasio.modelo;

public interface Reservable {
    void reservar(String horario);
    void cancelar(String horario);
}

