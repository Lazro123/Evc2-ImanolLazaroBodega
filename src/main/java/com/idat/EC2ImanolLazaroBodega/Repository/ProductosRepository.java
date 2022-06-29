package com.idat.EC2ImanolLazaroBodega.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.idat.EC2ImanolLazaroBodega.Model.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos,Integer>{

}
