package com.idat.EC2ImanolLazaroBodega.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.idat.EC2ImanolLazaroBodega.Model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

}
