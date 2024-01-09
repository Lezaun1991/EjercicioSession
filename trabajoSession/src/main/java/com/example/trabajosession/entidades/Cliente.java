package com.example.trabajosession.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    private String nombre;
    private String apellidos;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    private TipoGenero tipoGenero;
    private EstadoCivil estadoCivil;
    private TipoNacionalidad nacionalidad;
    private DepartamentosTrabajo puesto;
    private double salario;
    private String comentarios;
    private String cuentaBancaria;

}
