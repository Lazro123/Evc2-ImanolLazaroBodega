package com.idat.EC2ImanolLazaroBodega.Service;

import java.util.List;

import com.idat.EC2ImanolLazaroBodega.Model.Cliente;

public interface ClienteService {

	void guardarCliente(Cliente cliente);
	void actualizarCliente(Cliente cliente);
	void eliminarCliente(Integer id);
	List<Cliente> listarCliente();
	Cliente obtenerCliente(Integer id);
	
	
	
}

