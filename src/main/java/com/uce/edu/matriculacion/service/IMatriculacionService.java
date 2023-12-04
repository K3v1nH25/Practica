package com.uce.edu.matriculacion.service;

import com.uce.edu.matriculacion.repository.modelo.Matriculacion;
import com.uce.edu.matriculacion.repository.modelo.Vehiculo;

public interface IMatriculacionService {

	public Matriculacion buscar(String placa);

	public void guardar(Matriculacion Matriculacion);

	public void actualizar(Matriculacion Matriculacion);

	public void borrar(String placa);

	public void valorMatricula(Vehiculo vehiculo);

}
