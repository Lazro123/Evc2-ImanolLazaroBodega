package com.idat.EC2ImanolLazaroBodega.Service;

import java.util.List;

import com.idat.EC2ImanolLazaroBodega.Model.Bodega;

public interface BodegaService {

	void guardarBodega(Bodega bodega);
	void actualizarBodega(Bodega bodega);
	void eliminarBodega(Integer id);
	List<Bodega> listarBodega();
	Bodega obtenerBodegaId(Integer id);
}
