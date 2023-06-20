/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.m5a.usuarios.model.vm;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author carlos
 */
@Data
@AllArgsConstructor
public class Asset {
    
    private byte[] content;
    private String contentType;

}
