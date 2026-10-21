package com.codahertz.codahertz.controllers;

import com.codahertz.codahertz.models.Cancion;
import com.codahertz.codahertz.repositories.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/canciones")
public class CancionController {

    @Autowired
    private CancionRepository cancionRepository;

    // Método GET (Leer)
    @GetMapping
    public List<Cancion> obtenerCanciones() {
        return cancionRepository.findAll();
    }

    // Método POST (Crear)
    @PostMapping
    public Cancion guardarCancion(@RequestBody Cancion cancion) {
        return cancionRepository.save(cancion);
    }
}