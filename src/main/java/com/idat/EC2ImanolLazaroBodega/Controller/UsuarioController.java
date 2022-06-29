package com.idat.EC2ImanolLazaroBodega.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.EC2ImanolLazaroBodega.Model.Bodega;
import com.idat.EC2ImanolLazaroBodega.Model.Productos;
import com.idat.EC2ImanolLazaroBodega.Model.Usuario;
import com.idat.EC2ImanolLazaroBodega.Service.BodegaService;
import com.idat.EC2ImanolLazaroBodega.Service.UsuarioService;

@Controller
@RequestMapping(path = "/usuario/v1")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<Usuario>> listar() {
		
		return new ResponseEntity<List<Usuario>>(service.Usuario(), HttpStatus.OK);
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Usuario usuario) {
		service.guardarUsuario(usuario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		
		Usuario usuario = service.obtenerUsuario(id);
		
		if(usuario !=null) {
		service.eliminarUsuario(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Usuario usuario) {
		
		Usuario usuarios =service.obtenerUsuario(usuario.getIdUsuario());
	
	if(usuario !=null) {
	    service.actualizarUsuario(usuario);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> obtenerId(@PathVariable Integer id) {
		
		Usuario usuario =service.obtenerUsuario(id);
	
		if(usuario !=null) {
			return new ResponseEntity<Usuario>(service.obtenerUsuario(id),(HttpStatus.OK));
	}
	
		return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
	}

}