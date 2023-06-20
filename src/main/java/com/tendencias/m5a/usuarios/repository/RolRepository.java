/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tendencias.m5a.usuarios.repository;

import com.tendencias.m5a.usuarios.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author carlos
 */
public interface RolRepository extends JpaRepository<Rol, Integer> {

    @Query(value = "Select * from rol r where r.nombre = :nombre", nativeQuery = true)
    public Rol buscarRol(String nombre);
}
