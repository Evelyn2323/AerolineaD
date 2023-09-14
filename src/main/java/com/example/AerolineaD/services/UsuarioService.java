package com.example.AerolineaD.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AerolineaD.models.aerolineaMo;
import com.example.AerolineaD.repositories.aerolineaRepository;

@Service
public class UsuarioService {
    @Autowired
    aerolineaRepository amazonRepository;

    public ArrayList<aerolineaMo> obtenUsuarios() {
        return (ArrayList<aerolineaMo>) amazonRepository.findAll();
    }

    public aerolineaMo guardarUsuario(aerolineaMo usuario) {
        return amazonRepository.save(usuario);
    }

    public Optional<aerolineaMo> obtenerPorId(Long id) {
        return amazonRepository.findById(id);
    }

    public ArrayList<aerolineaMo> obtenerPorPrioridad(Integer primordial) {
        return (ArrayList<aerolineaMo>) amazonRepository.findByPrioridad(primordial);
    }

    public boolean eliminarUsuario(Long id) {
        try {
            amazonRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public aerolineaMo editarUsuario(Long id, aerolineaMo usuarioActualizado) {
        Optional<aerolineaMo> usuarioExistente = amazonRepository.findById(id);
    
        if (usuarioExistente.isPresent()) {
            aerolineaMo usuario = usuarioExistente.get();
            usuario.setNombreAerolinea(usuarioActualizado.getNombreAerolinea());
            usuario.setNvuelo(usuarioActualizado.getNvuelo());
            usuario.setDestino(usuarioActualizado.getDestino());
    
            return amazonRepository.save(usuario);
        } else {
            return null; // Puedes manejar esto de manera diferente según tus requisitos
        }
    }

}
