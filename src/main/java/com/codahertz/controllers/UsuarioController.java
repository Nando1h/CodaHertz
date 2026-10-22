package com.codahertz.controllers;

import com.codahertz.models.Usuario;
import com.codahertz.repositories.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    // GET all
    @GetMapping
    public List<Usuario> listar() {
        return repository.findAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtener(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST (alta)
    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario) {
        usuario.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
    }

    // PUT (cambio)
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        usuario.setId(id);
        return ResponseEntity.ok(repository.save(usuario));
    }

    // DELETE (baja)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
