package com.example.AzentBACK.ProviderImpl;

import com.example.AzentBACK.DTO.CategoriaDTO;
import com.example.AzentBACK.Entity.Categoria;
import com.example.AzentBACK.Provider.CategoriaProvider;
import com.example.AzentBACK.Repository.CategoriaRepository;
import com.example.AzentBACK.Utils.MessageResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CategoriaProviderImpl  implements CategoriaProvider {

    @Autowired
    CategoriaRepository categoriaRepository;


    private ModelMapper modelMapper=new ModelMapper();
    public MessageResponseDto<List<Categoria>> getAllCategorias(){
        try {
            List<Categoria>listCategorias=categoriaRepository.findAll();
            if(listCategorias.isEmpty()){
                return MessageResponseDto.fail("No se ha encontrado categorias");
            }else {
                return MessageResponseDto.success(listCategorias);
            }
        }catch (Exception e){
            return MessageResponseDto.fail("No se ha encontrado categorias");
        }
    }
    public MessageResponseDto<String>addCategoria(CategoriaDTO cat){
        try {
            Categoria categoria=new Categoria();
            categoria=modelMapper.map(cat,Categoria.class);
            categoriaRepository.save(categoria);
            return MessageResponseDto.success("Se ha añadido un categoria correctamente");
        }catch (Exception e){
            return  MessageResponseDto.fail("No se ha podido añadir una nueva categorias");
        }
    }
    public MessageResponseDto<String>deleteCategoria(Long id){
        try {
            Optional<Categoria> categoria=categoriaRepository.findById(id);
            if (categoria.isPresent()){
                categoriaRepository.delete(categoria.get());
                return MessageResponseDto.success("Se ha eliminado la categoria correctamente");
            }else{
                return  MessageResponseDto.success("No se ha podido eliminar la categoria");
            }
        }catch (Exception e){
            return MessageResponseDto.fail("No se ha podido encontrar la categoria");
        }
    }
    public MessageResponseDto<String>updateCategoria(Long id, CategoriaDTO categoriaDTO){
        try {
            Categoria categoria=modelMapper.map(categoriaDTO,Categoria.class);
            Optional<Categoria> categoria1=categoriaRepository.findById(id);
            if (!categoria1.isPresent()){
                return MessageResponseDto.fail("No se ha encontrado esa categoria");
            }
            categoria.setId(id);
            categoriaRepository.save(categoria);
            return MessageResponseDto.success("Se ha modificado la categoria correctamente");
        }catch (Exception e){
            return MessageResponseDto.fail("No se ha podido modificar la categoria correctamente");
        }
    }
    public MessageResponseDto<CategoriaDTO>findById(Long id){
        try {
            Optional<Categoria>categoria=categoriaRepository.findById(id);
            if (!categoria.isPresent()){
                return MessageResponseDto.fail("No se ha encontrado la categoria");
            }
            return MessageResponseDto.success(modelMapper.map(categoria,CategoriaDTO.class));
        }catch (Exception e){
            return MessageResponseDto.fail("No se ha encontrado la categoria");
        }
    }
}