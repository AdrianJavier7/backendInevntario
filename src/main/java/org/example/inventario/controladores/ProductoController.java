package org.example.inventario.controladores;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.inventario.dto.ProductoDTO;
import org.example.inventario.modelos.Producto;
import org.example.inventario.servicios.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping("/todosDTO")
    public List<ProductoDTO> getAllDTO() {
        return productoService.getProductosDTO();
    }

    @GetMapping("/nombreDTO/{nombre}")
    public ProductoDTO getByNameDTO(@PathVariable String nombre) {
        return productoService.getProductoDTOByNombre(nombre);
    }

    @GetMapping("/categoriaDTO/{nombre}")
    public List<ProductoDTO> getByCategoriaDTO(@PathVariable String nombre) {
        return productoService.getProductosDTOByCategoria(nombre);
    }

    @GetMapping("/proveedorDTO/{nombre}")
    public List<ProductoDTO> getByProveedorDTO(@PathVariable String nombre) {
        return productoService.getProductosDTOByProveedorNombre(nombre);
    }

    @PostMapping("/guardarDTO")
    public ProductoDTO saveDTO(@RequestBody ProductoDTO producto) {
        return productoService.saveProductoDTO(producto);
    }

    @GetMapping("/todos")
    public List<Producto> getAll() {
        return productoService.getProductos();
    }

    @GetMapping("/nombre/{nombre}")
    public Producto getByName(@PathVariable String nombre) {
        return productoService.getProductoByNombre(nombre);
    }

    @GetMapping("/categoria/{nombre}")
    public List<Producto> getByCategoria(@PathVariable String nombre) {
        return productoService.getProductosByCategoria(nombre);
    }

    @GetMapping("/proveedor/{id}")
    public List<Producto> getByProveedor(@PathVariable Integer id) {
        return productoService.getProductosByProveedor(id);
    }

    @GetMapping("/{id}")
    public Producto getById(@PathVariable Integer id) {
        return productoService.getProductoById(id);
    }

    @PostMapping("/guardar")
    public Producto save(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    @PostMapping("/actualizar")
    public Producto update(@RequestBody Producto producto) {
        return productoService.updateProducto(producto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable Integer id) {
        productoService.deleteProducto(id);
    }




}
