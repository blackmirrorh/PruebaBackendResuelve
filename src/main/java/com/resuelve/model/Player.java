package com.resuelve.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {

	@JsonProperty("nombre")
	private String nombre;
	
	@JsonProperty("nivel")
	private String nivel;
	
	@JsonProperty("goles")
	private int goles;
	
	@JsonProperty("sueldo")
	private double sueldo;
	
	@JsonProperty("bono")
	private double bono;
	
	@JsonProperty("sueldo_completo")
	private double sueldoCompleto;
	
	@JsonProperty("equipo")
	private String equipo;
}
