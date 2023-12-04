package com.uce.edu.matriculacion.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.matriculacion.repository.modelo.Matriculacion;


public interface IMatricularRepository {

	public Matriculacion seleccionar(String placa);

	public void insertar(Matriculacion matricular);

	public void actualizar(Matriculacion matricular);

	public void eliminar(String placa);

}
