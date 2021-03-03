package co.edu.reto1.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Cancion implements Serializable {
    private int song;
    private String nombre;
    private String album;
}
