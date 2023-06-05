package com.example.AzentBACK.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Float precio;
    private String activo;
    private Long categoriaId;
}
