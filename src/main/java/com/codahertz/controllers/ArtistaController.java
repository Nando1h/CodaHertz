package com.codahertz.controllers;

import com.codahertz.models.Artista;
import com.codahertz.repositories.ArtistaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artistas")
public class ArtistaController {

    private final ArtistaRepository repository;

    public ArtistaController(ArtistaRepository repository) {
        this.repository = repository;
    }

    // GET all
    @GetMapping
    public List<Artista> listar() {
        return repository.findAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public ResponseEntity<Artista> obtener(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST (alta)
    @PostMapping
    public ResponseEntity<Artista> crear(@RequestBody Artista artista) {
        artista.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(artista));
    }

    // PUT (cambio)
    @PutMapping("/{id}")
    public ResponseEntity<Artista> actualizar(@PathVariable Long id, @RequestBody Artista artista) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        artista.setId(id);
        return ResponseEntity.ok(repository.save(artista));
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
