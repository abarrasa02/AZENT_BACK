package com.example.AzentBACK.ProviderImpl;

import com.example.AzentBACK.DTO.ProductoDTO;
import com.example.AzentBACK.Entity.Producto;
import com.example.AzentBACK.Provider.ProductoProvider;
import com.example.AzentBACK.Repository.ProductoRepository;
import com.example.AzentBACK.Utils.MessageResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductoProviderImpl implements ProductoProvider {

    @Autowired
    ProductoRepository productoRepository;
    public ModelMapper modelMapper=new ModelMapper();
    public MessageResponseDto<String>addProducto(ProductoDTO productoDto){
        try {
            Producto producto=modelMapper.map(productoDto,Producto.class);

            Long contNombre=productoRepository.contNombre(producto.getNombre());
            if(contNombre>0){
                return MessageResponseDto.fail("No se puede añadir un producto con el mismo nombre");
            }
            productoRepository.save(producto);
            return  MessageResponseDto.success("Se ha añadido correctamente el producto");

        }catch (Exception e){
            return MessageResponseDto.fail("No se ha podido añadir un nuevo producto");
        }
    }
    public MessageResponseDto<String>deleteProducto(Long id){
        try {
            Optional<Producto> producto=productoRepository.findById(id);
            if(!producto.isPresent()){
                return MessageResponseDto.fail("No se ha podido eliminar el producto");
            }
            productoRepository.deleteById(id);
            return MessageResponseDto.success("Se ha eliminado el producto correctamente");
        }catch (Exception e){
            return MessageResponseDto.fail("Se ha producido un error al intentar eliminar el producto");
        }
    }

    public MessageResponseDto<String>updateProducto(Long id,ProductoDTO productoDto){
        try {
            Producto producto=modelMapper.map(productoDto,Producto.class);
            Optional<Producto>producto1=productoRepository.findById(id);
            if (!producto1.isPresent()){
                return  MessageResponseDto.fail("No se ha encontrado el producto");
            }
            producto.setId(id);
            productoRepository.save(producto);
            return  MessageResponseDto.success("Se ha modificado el producto correctamente");
        }catch (Exception e){
            return MessageResponseDto.fail("No se ha podidod modificar el producto");
        }
    }

    public MessageResponseDto<List<ProductoDTO>>getProductos(){
        try {
            List<Producto>list=productoRepository.findAll();
            List<ProductoDTO>dtoList=new ArrayList<>();
            for (Producto a : list){
                dtoList.add(modelMapper.map(a, ProductoDTO.class));
            }
            return MessageResponseDto.success(dtoList);
        }catch (Exception e){
            return MessageResponseDto.fail("Error:No se han podido recoger los productos");
        }
    }
    public MessageResponseDto<Producto>findById(Long id){
        try {
            Optional<Producto>producto=productoRepository.findById(id);
            if (!producto.isPresent()){
                return  MessageResponseDto.fail("No se encontrado el producto");
            }
            return  MessageResponseDto.success(producto.get());

        }catch (Exception e){
            return MessageResponseDto.fail("No se ha encontrado el producto");
        }
    }
}