# Sistema de Reservas para Gimnasio

Proyecto incremental de la asignatura Programación III (LG-016), ciclo 02-2026.
Universidad Pedagógica de El Salvador "Dr. Luis Alonso Aparicio".

## Descripción del proyecto

Sistema para gestionar la membresía y las reservas de un gimnasio: control de horarios, espacios disponibles y registro de clientes.

### Evolución del proyecto

- **Laboratorio I:** modelo inicial de clases y objetos del dominio (atributos, constructores, encapsulamiento).
- **Laboratorio II (actual):** ampliación con herencia, clases abstractas, polimorfismo (sobrecarga y sobrescritura) e interfaces, construidas sobre el mismo modelo.

### Jerarquía de clases

```
Persona (abstract)
├── Miembro
│   └── MiembroPremium
├── Entrenador
└── Administrador
```

- **`Persona`** (clase abstracta): atributos comunes (`nombre`, `carnet`, `correo`) y el método abstracto `calcularCuotaMensual()`, que cada subclase implementa a su manera.
- **`Miembro`**: paga la cuota mensual normal y la cuota diaria; guarda sus reservas (`Reserva`) e implementa la interfaz `Reservable`.
- **`MiembroPremium`** (extiende de `Miembro`, herencia multinivel): 20% de descuento en la cuota mensual y diaria; sobrescribe `cancelar(...)` para cancelar sin penalización y con reembolso total.
- **`Entrenador`**: no paga cuota; implementa `Reservable` para reservar horarios de clases.
- **`Administrador`**: no paga cuota; gestiona el sistema.
- **`Gimnasio`**: nombre de la empresa (PowerFit Gym) y tarifas del sistema.
- **`Reserva`**: horario, cantidad de personas y costo de una reserva.

### Tarifas (PowerFit Gym)

| Concepto | Valor |
|---|---|
| Cuota mensual normal | $30.00 |
| Cuota diaria (1 persona) | $3.00 |
| Persona adicional en una reserva | $2.00 por persona extra |
| Penalización al cancelar (miembro normal) | 50% del costo de la reserva |
| Descuento del miembro Premium | 20% en cuota mensual y diaria; cancelación sin penalización |

**Costo de una reserva** = cuota diaria del socio + (personas − 1) × $2.00.
Ejemplo: Ana reserva para 3 personas → $3.00 + 2 × $2.00 = $7.00. Si cancela, paga una penalización de $3.50 y se le reembolsan $3.50.

### Interfaz

- **`Reservable`**: define `reservar(String horario)` y `cancelar(String horario)`. Implementada por `Miembro` y `Entrenador`, y usada de forma polimórfica (`List<Reservable>`) en el controlador principal.

### Polimorfismo

- **Sobrecarga:** `Miembro.reservar(String horario)` y `Miembro.reservar(String horario, int cantidadPersonas)`.
- **Sobrescritura:** `cancelar(String horario)` se comporta distinto en `Miembro` (penalización del 50%) y en `MiembroPremium` (sin penalización). `MiembroPremium` también sobrescribe `calcularCuotaMensual()` y `calcularCuotaDiaria()` para aplicar su descuento.

## Equipo

| Integrante | Carnet | Concepto individual defendido | % de participación |
|---|---|---|---|
| Fernando Miguel Elías Soriano | ES-67880-24 | Herencia multinivel | Coevaluación: 100% |
| Melvin Alexander García Ramos | GR-67963-24 | Clases abstractas | Coevaluación: 100% |
| Edgardo Alexander Castellanos Paredes | CP-69742-25 | Polimorfismo por sobrecarga |Coevaluación: 100%|
Fernanda Aneliz Cortez Chavez | CC-69741-25 | Polimorfismo (Sobrecarga y Sobrescritura) | Coevaluación: 100%
| Isaías Humberto Mezquita García | MG-69776-25 | Interfaces | Coevaluación: 100% | 
| Cristina Eunice Gómez Canales | GC-69628-25 | Integración final del proyecto |Coevaluación: 100% |


## Requisitos

- JDK 21
- IntelliJ IDEA (Community Edition)

## Cómo compilar y ejecutar localmente

1. Clonar o abrir este repositorio en IntelliJ IDEA.
2. Verificar que el SDK del proyecto sea JDK 21 (`File > Project Structure > Project`).
3. Abrir la clase `Main.java` (en `src/.../Main.java`).
4. Ejecutar con el botón ▶ junto a `public static void main`, o `Run > Run 'Main.main()'`.
5. La consola debe mostrar el caso de uso de prueba con la jerarquía, el polimorfismo y la interfaz funcionando.

## Tablero Kanban

El avance del proyecto se registra semana a semana en el tablero Kanban del curso, con tarjetas trazables a los contenidos de las Unidades II y III (semanas 6 a 12).

Enlace al tablero: `https://github.com/fernandoskord3-oss/Lab2-reservasgym-progra3/blob/main/README.md`





