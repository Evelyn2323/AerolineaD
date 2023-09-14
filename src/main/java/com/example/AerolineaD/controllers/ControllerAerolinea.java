package com.example.AerolineaD.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AerolineaD.models.aerolineaMo;
import com.example.AerolineaD.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class ControllerAerolinea {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<aerolineaMo> obtenerUsuarios() {
        return usuarioService.obtenUsuarios();
    }

    @PostMapping
    public aerolineaMo guardarUsuario(@RequestBody aerolineaMo usuario) {
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<aerolineaMo> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        Optional<aerolineaMo> usuario = usuarioService.obtenerPorId(id);
        if (usuario.isPresent()) {
            return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/prioridad")
    public ArrayList<aerolineaMo> obtenerUsuariosPorPrioridad(@RequestParam("prioridad") Integer prioridad) {
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<aerolineaMo> editarUsuario(@PathVariable("id") Long id, @RequestBody aerolineaMo usuarioActualizado) {
    aerolineaMo usuarioEditado = this.usuarioService.editarUsuario(id, usuarioActualizado);

    if (usuarioEditado != null) {
        return ResponseEntity.ok(usuarioEditado);
    } else {
        return ResponseEntity.notFound().build();
    }
}

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}
