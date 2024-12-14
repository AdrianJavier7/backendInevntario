package org.example.inventario.modelos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario", schema = "inventario", catalog="postgres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email")
    private String email;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "rol")
    private String rol;

}
