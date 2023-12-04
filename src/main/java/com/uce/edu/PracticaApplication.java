package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.matriculacion.repository.modelo.Propietario;
import com.uce.edu.matriculacion.repository.modelo.Vehiculo;
import com.uce.edu.matriculacion.service.IMatriculacionService;
import com.uce.edu.matriculacion.service.IPropietarioService;
import com.uce.edu.matriculacion.service.IVehiculoService;

@SpringBootApplication
public class PracticaApplication implements CommandLineRunner {

	@Autowired
	private IMatriculacionService iMatriculacionService;

	@Autowired
	private IVehiculoService iVehiculoService;

	@Autowired
	private IPropietarioService iPropietarioService;

	public static void main(String[] args) {
		SpringApplication.run(PracticaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMarca("chevrolet");
		vehiculo.setPlaca("PDG-589");
		vehiculo.setPrecio(new BigDecimal(5000));
		vehiculo.setTipo("Pesado");
		System.out.println(vehiculo);
		this.iVehiculoService.guardar(vehiculo);

		vehiculo.setPlaca("PIG-178");
		vehiculo.setTipo("liviano");
		System.out.println(vehiculo);
		this.iVehiculoService.actualizar(vehiculo);
		
		Propietario propietario = new Propietario();
		propietario.setNombre("kevin");
		propietario.setApellido("Hurtado");
		propietario.setCedula("1724693112");
		propietario.setFechaNacimiento(LocalDateTime.of(1997, 12, 9, 12, 50));
		this.iPropietarioService.guardar(propietario);
		
		this.iMatriculacionService.valorMatricula(vehiculo);
		
		
		

	}

}
