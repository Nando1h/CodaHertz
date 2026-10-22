package com.codahertz.controllers;

import com.codahertz.models.Genero;
import com.codahertz.repositories.GeneroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/generos")
public class GeneroController {

    private final GeneroRepository repository;

    public GeneroController(GeneroRepository repository) {
        this.repository = repository;
    }

    // GET all
    @GetMapping
    public List<Genero> listar() {
        return repository.findAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public ResponseEntity<Genero> obtener(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST (alta)
    @PostMapping
    public ResponseEntity<Genero> crear(@RequestBody Genero genero) {
        genero.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(genero));
    }

    // PUT (cambio)
    @PutMapping("/{id}")
    public ResponseEntity<Genero> actualizar(@PathVariable Long id, @RequestBody Genero genero) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        genero.setId(id);
        return ResponseEntity.ok(repository.save(genero));
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
