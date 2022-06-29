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

import com.idat.EC2ImanolLazaroBodega.Model.Productos;
import com.idat.EC2ImanolLazaroBodega.Service.ProductoService;

@Controller
@RequestMapping(path = "/productos/v1")
public class ProductoController {
	
	@Autowired
	private ProductoService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<Productos>> listar() {
		
		return new ResponseEntity<List<Productos>>(service.Productos(), HttpStatus.OK);
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Productos productos) {
		service.guardarProductos(productos);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		
		Productos productos = service.obtenerProductos(id);
		
		if(productos !=null) {
		service.eliminarProductos(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Productos productos) {
		
		Productos producto =service.obtenerProductos(productos.getIdProducto());
	
	if(producto !=null) {
	    service.actualizarProductos(productos);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Productos> obtenerId(@PathVariable Integer id) {
		
		Productos productos =service.obtenerProductos(id);
	
		if(productos !=null) {
			return new ResponseEntity<Productos>(service.obtenerProductos(id),(HttpStatus.OK));
	}
	
		return new ResponseEntity<Productos>(HttpStatus.NOT_FOUND);
	}

}