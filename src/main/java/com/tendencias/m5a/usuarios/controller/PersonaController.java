/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.m5a.usuarios.controller;

import com.tendencias.m5a.usuarios.model.Persona;
import com.tendencias.m5a.usuarios.service.PersonaServiceImpl;
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
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    public PersonaServiceImpl personaServiceImpl;

    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> listaUsuarios() {
        return new ResponseEntity<>(personaServiceImpl.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona p) {
        return new ResponseEntity<>(personaServiceImpl.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Integer id, @RequestBody Persona p) {
        Persona persona = personaServiceImpl.findById(id);
        if (persona != null) {
            try {
                persona.setApellido(p.getApellido());
                persona.setCedula(p.getCedula());
                persona.setCelular(p.getCelular());
                persona.setCorreo(p.getCorreo());
                persona.setDireccion(p.getDireccion());
                persona.setInstruccion(p.getInstruccion());
                persona.setNombre(p.getNombre());
                persona.setFechanacimiento(p.getFechanacimiento());
                return new ResponseEntity<>(personaServiceImpl.save(persona), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Persona> elimiarPersona(@PathVariable Integer id) {
        personaServiceImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
