package com.example.AzentBACK.Repository;

import com.example.AzentBACK.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    @Query("SELECT COUNT(u) FROM Usuario u where u.email=:email AND u.contrasena=:contrasena")
    Long loginSuccess(@Param("email")String email, @Param("contrasena")String contrasena);


    @Query("SELECT count (u) FROM Usuario u where u.email=:email")
    Long contEmail (@Param("email")String email);
}
