package co.edu.reto1.model;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Artista implements Serializable {
    private int imagen;
    private String nombre;
    private  String descripcion;
    private Cancion cancion;
}
