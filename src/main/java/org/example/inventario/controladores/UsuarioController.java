package org.example.inventario.controladores;

import lombok.AllArgsConstructor;
import org.example.inventario.dto.LoginDTO;
import org.example.inventario.modelos.Usuario;
import org.example.inventario.servicios.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/todos")
    public List<Usuario> getAll() {
        return usuarioService.getUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable Integer id) {
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody LoginDTO usuario) {
        return usuarioService.login(usuario);
    }

    @PostMapping("/guardar")
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @PostMapping("/actualizar")
    public Usuario update(Usuario usuario) {
        return usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable Integer id) {
        usuarioService.deleteUsuario(id);
    }


}
