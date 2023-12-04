package com.uce.edu.matriculacion.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.matriculacion.repository.modelo.Matriculacion;

@Repository
public class MatriculacionRepositoryImpl implements IMatricularRepository {

	public static List<Matriculacion> base = new ArrayList<Matriculacion>();

	@Override
	public Matriculacion seleccionar(String placa) {
		// TODO Auto-generated method stub
		for (Matriculacion matriculacion : base) {
			if (matriculacion.getVehiculo().getPlaca().equals(placa)) {
				Matriculacion mat = new Matriculacion();
				mat.setFechaMatricula(matriculacion.getFechaMatricula());
				mat.setPropietario(matriculacion.getPropietario());
				mat.setValorMatricula(matriculacion.getValorMatricula());
				mat.setVehiculo(matriculacion.getVehiculo());

				return mat;

			}

		}

		return null;
	}

	public Matriculacion seleccionarEliminar(String placa) {
		for (Matriculacion matriculacion : base) {
			if (matriculacion.getVehiculo().getPlaca().equals(placa)) {
				return matriculacion;

			}

		}

		return null;

	}

	@Override
	public void insertar(Matriculacion matricular) {
		// TODO Auto-generated method stub
		base.add(matricular);

	}

	@Override
	public void actualizar(Matriculacion matricular) {
		// TODO Auto-generated method stub
		this.eliminar(matricular.getVehiculo().getPlaca());
		this.insertar(matricular);

	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		Matriculacion matriculacion = new Matriculacion();
		base.remove(matriculacion);

	}

}
