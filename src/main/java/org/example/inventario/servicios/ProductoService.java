package org.example.inventario.servicios;

import org.example.inventario.dto.ProductoDTO;
import org.example.inventario.modelos.Producto;
import org.example.inventario.repositorios.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProveedorService proveedorService;

    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    public Producto getProductoById(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto updateProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteProducto(Integer id) {
        productoRepository.deleteById(id);
    }

    public List<Producto> getProductosByCategoria(String nombre) {
        return productoRepository.findByCategoria(nombre);
    }

    public List<Producto> getProductosByProveedor(Integer id) {
        return productoRepository.findByProveedor_Id(id);
    }

    public Producto getProductoByNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    public List<ProductoDTO> getProductosDTO() {
       List<Producto> productos = productoRepository.findAll();
       List<ProductoDTO> productosDTO = new ArrayList<>();

         for(Producto producto: productos) {
              ProductoDTO productoDTO = new ProductoDTO();
              productoDTO.setId(producto.getId());
              productoDTO.setNombre(producto.getNombre());
              productoDTO.setPrecio(producto.getPrecio());
              productoDTO.setCantidad(producto.getCantidad());
              productoDTO.setDescripcion(producto.getDescripcion());
              productoDTO.setImagen(producto.getImagen());
              productoDTO.setCategoria(producto.getCategoria());
              productoDTO.setProveedor(producto.getProveedor().getNombre());
              productosDTO.add(productoDTO);
         }

         return productosDTO;
    }

    public ProductoDTO getProductoDTOById(Integer id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setCantidad(producto.getCantidad());
        productoDTO.setDescripcion(producto.getDescripcion());
        productoDTO.setImagen(producto.getImagen());
        productoDTO.setCategoria(producto.getCategoria());
        productoDTO.setProveedor(producto.getProveedor().getNombre());
        return productoDTO;
    }

    public List<ProductoDTO> getProductosDTOByCategoria(String nombre) {
        List<Producto> productos = productoRepository.findByCategoria(nombre);
        List<ProductoDTO> productosDTO = new ArrayList<>();

        for(Producto producto: productos) {
            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.setId(producto.getId());
            productoDTO.setNombre(producto.getNombre());
            productoDTO.setPrecio(producto.getPrecio());
            productoDTO.setCantidad(producto.getCantidad());
            productoDTO.setDescripcion(producto.getDescripcion());
            productoDTO.setImagen(producto.getImagen());
            productoDTO.setCategoria(producto.getCategoria());
            productoDTO.setProveedor(producto.getProveedor().getNombre());
            productosDTO.add(productoDTO);
        }

        return productosDTO;
    }

    public List<ProductoDTO> getProductosDTOByProveedorId(Integer id) {
        List<Producto> productos = productoRepository.findByProveedor_Id(id);
        List<ProductoDTO> productosDTO = new ArrayList<>();

        for(Producto producto: productos) {
            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.setId(producto.getId());
            productoDTO.setNombre(producto.getNombre());
            productoDTO.setPrecio(producto.getPrecio());
            productoDTO.setCantidad(producto.getCantidad());
            productoDTO.setDescripcion(producto.getDescripcion());
            productoDTO.setImagen(producto.getImagen());
            productoDTO.setCategoria(producto.getCategoria());
            productoDTO.setProveedor(producto.getProveedor().getNombre());
            productosDTO.add(productoDTO);
        }

        return productosDTO;
    }

    public List<ProductoDTO> getProductosDTOByProveedorNombre(String nombre) {
        List<Producto> productos = productoRepository.findByProveedor_Nombre(nombre);
        List<ProductoDTO> productosDTO = new ArrayList<>();

        for(Producto producto: productos) {
            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.setId(producto.getId());
            productoDTO.setNombre(producto.getNombre());
            productoDTO.setPrecio(producto.getPrecio());
            productoDTO.setCantidad(producto.getCantidad());
            productoDTO.setDescripcion(producto.getDescripcion());
            productoDTO.setImagen(producto.getImagen());
            productoDTO.setCategoria(producto.getCategoria());
            productoDTO.setProveedor(producto.getProveedor().getNombre());
            productosDTO.add(productoDTO);
        }

        return productosDTO;
    }

    public ProductoDTO getProductoDTOByNombre(String nombre) {
        Producto producto = productoRepository.findByNombre(nombre);
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setCantidad(producto.getCantidad());
        productoDTO.setDescripcion(producto.getDescripcion());
        productoDTO.setImagen(producto.getImagen());
        productoDTO.setCategoria(producto.getCategoria());
        productoDTO.setProveedor(producto.getProveedor().getNombre());
        return productoDTO;
    }

    public ProductoDTO saveProductoDTO(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setCantidad(productoDTO.getCantidad());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setImagen(productoDTO.getImagen());
        producto.setCategoria(productoDTO.getCategoria());
        producto.setProveedor(proveedorService.getProveedorByNombre(productoDTO.getProveedor()));
        producto = productoRepository.save(producto);
        productoDTO.setId(producto.getId());
        return productoDTO;
    }

}
