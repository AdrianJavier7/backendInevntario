package org.example.inventario.controladores;

import lombok.AllArgsConstructor;
import org.example.inventario.servicios.ProveedorService;
import org.springframework.web.bind.annotation.*;
import org.example.inventario.modelos.Proveedor;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
@AllArgsConstructor
public class ProveedorController {

    private final ProveedorService proveedorService;

    @GetMapping("/todos")
    public List<Proveedor> getAll() {
        return proveedorService.getProveedores();
    }

    @GetMapping("/{id}")
    public Proveedor getById(@PathVariable Integer id) {
        return proveedorService.getProveedorById(id);
    }

    @PostMapping("/guardar")
    public Proveedor save(@RequestBody Proveedor proveedor) {
        return proveedorService.saveProveedor(proveedor);
    }

    @PostMapping("/actualizar")
    public Proveedor update(Proveedor proveedor) {
        return proveedorService.updateProveedor(proveedor);
    }

    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable Integer id) {
        proveedorService.deleteProveedor(id);
    }

}
