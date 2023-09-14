package org.zabalburu.GestionTareas.dao.modelo;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tarea {
	@EqualsAndHashCode.Include
	private Integer id;
	private Empleado empleado;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	
}
