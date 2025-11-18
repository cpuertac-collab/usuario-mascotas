/**JPA te permite guardar, 
 * leer, actualizar y borrar objetos Java en una base de datos sin tener que escribir SQL manual.
 */

package com.CEA.usuario_mascotas.adapter.config.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    private String id;

    private String nombre;
    private String email;
    private String claveHash;
    private String rol;

    public UsuarioEntity() {}

    public UsuarioEntity(String id, String nombre, String email,
                         String claveHash, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.claveHash = claveHash;
        this.rol = rol;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getClaveHash() { return claveHash; }
    public String getRol() { return rol; }

    public void setId(String id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }
    public void setClaveHash(String claveHash) { this.claveHash = claveHash; }
    public void setRol(String rol) { this.rol = rol; }
    
}
