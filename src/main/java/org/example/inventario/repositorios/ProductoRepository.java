package org.example.inventario.repositorios;

import org.example.inventario.modelos.Producto;
import org.example.inventario.modelos.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {


    Producto findByNombre(String nombre);
    List<Producto> findByProveedor_Id(Integer id);

    List<Producto> findByCategoria(String nombre);
}
