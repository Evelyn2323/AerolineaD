package com.example.AerolineaD.models;

import org.springframework.stereotype.Repository;
import jakarta.persistence.*;

@Entity
@Table(name = "productos")
@Repository
public class aerolineaMo {

    private Integer prioridad;

    public Integer getPrioridad() {
        return prioridad;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String NombreAerolinea;
    private String Nvuelo;
    private int Destino;

    public Long getId() {
        return id;
    }

    public String getNombreAerolinea() {
        return NombreAerolinea;
    }
    public void setNombreAerolinea(String nombreAerolinea) {
        NombreAerolinea = nombreAerolinea;
    }
    public String getNvuelo() {
        return Nvuelo;
    }
    public void setNvuelo(String nvuelo) {
        Nvuelo = nvuelo;
    }
    public int getDestino() {
        return Destino;
    }
    public void setDestino(int destino) {
        Destino = destino;
    }

 

}
