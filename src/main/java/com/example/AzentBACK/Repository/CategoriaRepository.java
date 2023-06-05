package com.example.AzentBACK.Repository;

import com.example.AzentBACK.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria,Long> {
}
