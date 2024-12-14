package org.example.inventario.dto;

import lombok.Data;

@Data
public class ProductoDTO {

    private Integer id;
    private String nombre;
    private Integer cantidad;
    private Double precio;
    private String descripcion;
    private String imagen;
    private String categoria;
    private String proveedor;

}
