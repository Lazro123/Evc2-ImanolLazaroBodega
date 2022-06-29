package com.idat.EC2ImanolLazaroBodega.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC2ImanolLazaroBodega.Model.Usuario;
import com.idat.EC2ImanolLazaroBodega.Repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired 
	private UsuarioRepository repository;
	@Override
	public void guardarUsuario(com.idat.EC2ImanolLazaroBodega.Model.Usuario usuario) {
		// TODO Auto-generated method stub
		repository.save(usuario);
	}

	@Override
	public void actualizarUsuario(com.idat.EC2ImanolLazaroBodega.Model.Usuario usuario) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(usuario);
	}

	@Override
	public void eliminarUsuario(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<com.idat.EC2ImanolLazaroBodega.Model.Usuario> Usuario() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Usuario obtenerUsuario(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}