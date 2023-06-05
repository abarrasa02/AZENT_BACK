package com.example.AzentBACK.Provider;

import com.example.AzentBACK.DTO.CategoriaDTO;
import com.example.AzentBACK.Entity.Categoria;
import com.example.AzentBACK.Utils.MessageResponseDto;

import java.util.List;

public interface CategoriaProvider {

    MessageResponseDto<List<Categoria>>getAllCategorias();
    MessageResponseDto<String> addCategoria(CategoriaDTO cat);

    MessageResponseDto<String>deleteCategoria(Long id);
    MessageResponseDto<String>updateCategoria(Long id, CategoriaDTO cat);

    MessageResponseDto<CategoriaDTO>findById(Long id);
}