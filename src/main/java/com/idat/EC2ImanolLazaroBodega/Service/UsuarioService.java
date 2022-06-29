package com.idat.EC2ImanolLazaroBodega.Service;

import java.util.List;

import com.idat.EC2ImanolLazaroBodega.Model.Usuario;

	public interface UsuarioService {

		void guardarUsuario(Usuario usuario);
		void actualizarUsuario(Usuario usuario);
		void eliminarUsuario(Integer id);
		List<Usuario> Usuario();
		Usuario obtenerUsuario(Integer id);
		
		
		
	}

