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

import com.idat.EC2ImanolLazaroBodega.Model.Cliente;
import com.idat.EC2ImanolLazaroBodega.Service.ClienteService;

@Controller
@RequestMapping(path = "/cliente/v1")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<Cliente>> listar() {
		
		return new ResponseEntity<List<Cliente>>(service.listarCliente(), HttpStatus.OK);
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Cliente cliente) {
		service.guardarCliente(cliente);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		
		Cliente cliente = service.obtenerCliente(id);
		
		if(cliente !=null) {
		service.eliminarCliente(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Cliente cliente) {
		
		Cliente clientes =service.obtenerCliente(cliente.getIdCliente());
	
	if(cliente !=null) {
	    service.actualizarCliente(cliente);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> obtenerId(@PathVariable Integer id) {
		
		Cliente Cliente =service.obtenerCliente(id);
	
		if(Cliente !=null) {
			return new ResponseEntity<Cliente>(service.obtenerCliente(id),(HttpStatus.OK));
	}
	
		return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
	}

}