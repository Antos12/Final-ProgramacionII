package com.colmena.videojuegos.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="videojuegos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Videojuego {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String titulo;
   private String descripcion;
   private String imagen;
   private float precio;
   private boolean stock;
   private  Date fechaLanzamiento;
   private  boolean activo = true;

   @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_estudio", nullable = false)
    private Estudio estudio;

   @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "fk_categoria", nullable = false)
    private Categoria categoria;

}
