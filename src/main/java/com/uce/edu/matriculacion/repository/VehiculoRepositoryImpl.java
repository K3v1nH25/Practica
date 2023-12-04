package com.uce.edu.matriculacion.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.matriculacion.repository.modelo.Vehiculo;

@Repository
public class VehiculoRepositoryImpl implements IVehiculoRepository {

	public static List<Vehiculo> base = new ArrayList<Vehiculo>();

	@Override
	public Vehiculo selecionar(String placa) {
		// TODO Auto-generated method stub
		for (Vehiculo vehiculo : base) {
			if (vehiculo.getPlaca().equals(placa))
				;
			Vehiculo ve = new Vehiculo();
			ve.setMarca(vehiculo.getMarca());
			ve.setPlaca(vehiculo.getPlaca());
			ve.setPrecio(vehiculo.getPrecio());
			ve.setTipo(vehiculo.getTipo());
			return ve;

		}
		return null;
	}

	public Vehiculo selecionarEliminar(String placa) {
		for (Vehiculo vehiculo : base) {
			if (vehiculo.getPlaca().equals(placa))
				;
			return vehiculo;

		}
		return null;
	}

	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		base.add(vehiculo);

	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.eliminar(vehiculo.getPlaca());
		this.insertar(vehiculo);

	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		Vehiculo vehiculo = new Vehiculo();
		base.remove(vehiculo);

	}

}
