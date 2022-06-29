package com.idat.EC2ImanolLazaroBodega.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC2ImanolLazaroBodega.Model.Productos;
import com.idat.EC2ImanolLazaroBodega.Repository.ProductosRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
	@Autowired 
	private ProductosRepository repository;
	@Override
	public void guardarProductos(com.idat.EC2ImanolLazaroBodega.Model.Productos productos) {
		// TODO Auto-generated method stub
		repository.save(productos);
	}

	@Override
	public void actualizarProductos(com.idat.EC2ImanolLazaroBodega.Model.Productos productos) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(productos);
	}

	@Override
	public void eliminarProductos(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<com.idat.EC2ImanolLazaroBodega.Model.Productos> Productos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Productos obtenerProductos(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
}