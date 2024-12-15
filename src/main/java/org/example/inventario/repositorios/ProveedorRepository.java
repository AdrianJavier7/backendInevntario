package org.example.inventario.repositorios;

import org.example.inventario.modelos.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    Proveedor findByNombre(String nombre);
}
