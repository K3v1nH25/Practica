package com.uce.edu.matriculacion.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.matriculacion.repository.IMatricularRepository;
import com.uce.edu.matriculacion.repository.IPropietarioRepository;
import com.uce.edu.matriculacion.repository.modelo.Matriculacion;
import com.uce.edu.matriculacion.repository.modelo.Vehiculo;

@Service
public class MatriculacionServiceImpl implements IMatriculacionService {
	
	@Autowired
	private IMatricularRepository iMatricularRepository;
	
	@Autowired
	private IPropietarioRepository iPropietarioRepository;

	
	

	
	@Override
	public Matriculacion buscar(String placa) {
		// TODO Auto-generated method stub
		return this.iMatricularRepository.seleccionar(placa);
	}

	@Override
	public void guardar(Matriculacion Matriculacion) {
		// TODO Auto-generated method stub
		this.iMatricularRepository.insertar(Matriculacion);

	}

	@Override
	public void actualizar(Matriculacion Matriculacion) {
		// TODO Auto-generated method stub
		this.iMatricularRepository.actualizar(Matriculacion);
		

	}

	@Override
	public void borrar(String placa) {
		// TODO Auto-generated method stub
		this.iMatricularRepository.eliminar(placa);

	}

	@Override
	public void valorMatricula(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		if (this.buscar(vehiculo.getPlaca())==null) {
			BigDecimal valorFinal= null;
			if(vehiculo.getTipo().toLowerCase().equals("pesado")) {
				BigDecimal valorPesado = new BigDecimal(0.15);
				System.out.println("Valor Pesado: "+ valorPesado);
				valorFinal= vehiculo.getPrecio().multiply(valorPesado);
				System.out.println("valor Final:"+valorFinal);
			}
			else if (vehiculo.getTipo().toLowerCase().equals("liviano")){
				BigDecimal valorLiviano = new BigDecimal(0.10);
				System.out.println("Valor liviano: "+ valorLiviano);
				valorFinal= vehiculo.getPrecio().multiply(valorLiviano);
				System.out.println("valor Final:"+valorFinal);
			}
			else {
				System.out.println("No entra en ningun tipo de Vehiculo");
			}

			BigDecimal valorMaximo = new BigDecimal(2000);

			if (valorFinal.compareTo(valorMaximo)==1) {
				BigDecimal descuento = valorFinal.multiply(new BigDecimal(0.07));
				System.out.println("Descuento: "+ descuento);
				valorFinal = valorFinal.subtract(descuento);
			}

			Matriculacion mat = new Matriculacion();
			mat.setFechaMatricula(LocalDateTime.now());
			mat.setValorMatricula(valorFinal);
			mat.setVehiculo(vehiculo);
			this.guardar(mat);
			System.out.println("Se guardo: "+ mat);


		}
		else {
			System.out.println("Este Vehiculo ya esta registrado en el sistema ");
		}


	}

}