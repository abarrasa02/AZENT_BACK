package com.example.AzentBACK.Provider;

import com.example.AzentBACK.DTO.ProductoDTO;
import com.example.AzentBACK.Utils.MessageResponseDto;

import java.util.List;

public interface ProductoProvider {

    MessageResponseDto<String> addProducto(ProductoDTO productoDto);
    MessageResponseDto<String>deleteProducto(Long id);
    MessageResponseDto<String>updateProducto(Long id,ProductoDTO productoDto);

    MessageResponseDto<List<ProductoDTO>>getProductos();

    MessageResponseDto<ProductoDTO>findById(Long id);

}
