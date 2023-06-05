package com.example.AzentBACK.Repository;

import com.example.AzentBACK.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository  extends JpaRepository<Producto,Long> {

    @Query("select count(p) from Producto p where p.nombre=:nombre ")
    Long contNombre(@Param("nombre")String nombre);
}
