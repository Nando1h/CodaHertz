package com.codahertz.controllers;

import com.codahertz.models.Cancion;
import com.codahertz.repositories.CancionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/canciones")
public class CancionController {

    private final CancionRepository repository;

    public CancionController(CancionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Cancion> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cancion> obtener(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cancion> crear(@RequestBody Cancion cancion) {
        cancion.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cancion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cancion> actualizar(@PathVariable Long id, @RequestBody Cancion cancion) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cancion.setId(id);
        return ResponseEntity.ok(repository.save(cancion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
