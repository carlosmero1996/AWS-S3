/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.m5a.usuarios.controller;

import com.tendencias.m5a.usuarios.model.Rol;
import com.tendencias.m5a.usuarios.service.RolServiceImpl;
import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author carlos
 */
@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    public RolServiceImpl rolServiceImpl;

    @GetMapping("/listar")
    public ResponseEntity<List<Rol>> listaRoles() {
        return new ResponseEntity<>(rolServiceImpl.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Rol> crearRol(@RequestBody Rol r) {
        return new ResponseEntity<>(rolServiceImpl.save(r), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Rol> actualizarRol(@PathVariable Integer id, @RequestBody Rol r) {
        Rol rol = rolServiceImpl.findById(id);
        if (rol != null) {
            try {
                rol.setNombre(r.getNombre());
                rol.setEstado(r.getEstado());
                rol.setDescripcion(r.getDescripcion());
                return new ResponseEntity<>(rolServiceImpl.save(rol), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Rol> elimiarRol(@PathVariable Integer id) {
        rolServiceImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
