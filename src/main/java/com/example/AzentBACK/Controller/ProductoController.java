package com.example.AzentBACK.Controller;

import com.example.AzentBACK.DTO.ProductoDTO;
import com.example.AzentBACK.Provider.ProductoProvider;
import com.example.AzentBACK.Utils.MessageResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoProvider productoProvider;

    @PostMapping("/add")
    public MessageResponseDto<String>addProducto(@RequestBody ProductoDTO productoDto){
        try {
            return productoProvider.addProducto(productoDto);
        }catch (Exception e){
            return MessageResponseDto.fail("No se ha podido añadir el producto correctamente");
        }
    }
    @DeleteMapping("/delete/{id}")
    public MessageResponseDto<String>deleteProducto(@PathVariable Long id){
        try {
            return  productoProvider.deleteProducto(id);
        }catch (Exception e){
            return MessageResponseDto.fail("No se ha podido eliminar el producto");
        }
    }
    @PatchMapping("/edit/{id}")
    public  MessageResponseDto<String>updateProducto(@PathVariable("id")Long id,@RequestBody ProductoDTO productoDto){
        try {
            return productoProvider.updateProducto(id,productoDto);
        }catch (Exception e){
            return MessageResponseDto.fail("No se ha podido modificar el producto correctamente");
        }
    }

    @GetMapping("/all")
    public MessageResponseDto<List<ProductoDTO>>getProductos(){
        try {
            return productoProvider.getProductos();
        }catch (Exception e){
            return MessageResponseDto.fail("Error al recoger los productos");
        }
    }
    @GetMapping("/producto/{id}")
    public MessageResponseDto<ProductoDTO>findById(@PathVariable("id")Long id){
        try {
            return productoProvider.findById(id);
        }catch (Exception e){
            return MessageResponseDto.fail("No se ha encontrado el producto");
        }
    }




}