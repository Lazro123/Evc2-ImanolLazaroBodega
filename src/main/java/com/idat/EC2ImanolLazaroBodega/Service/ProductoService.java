package com.idat.EC2ImanolLazaroBodega.Service;

import java.util.List;

import com.idat.EC2ImanolLazaroBodega.Model.Productos;

public interface ProductoService {

	void guardarProductos(Productos productos);
	void actualizarProductos(Productos productos);
	void eliminarProductos(Integer id);
	List<Productos> Productos();
	Productos obtenerProductos(Integer id);
	
	
	
}
