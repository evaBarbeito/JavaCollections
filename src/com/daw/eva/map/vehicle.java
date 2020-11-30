/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.eva.map;

import java.util.Calendar;

/**
 *
 * @author 
 */
public class vehicle {
    String color;
    String marca;
    String model;
    Calendar any;

    
    public vehicle() {
    }

    
    public vehicle(String color, String marca, String model, Calendar any) {
        this.color = color;
        this.marca = marca;
        this.model = model;
        this.any = any;
    }
    
    
    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }
    
    public String getModel() {
        return model;
    }

    public Calendar getAny() {
        return any;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public void setModel(String model) {
        this.model = model;
    }

    public void setAny(Calendar any) {
        this.any = any;
    }

    
    @Override
    public String toString() {
        return "vehicle {" + "color=" + color + ", marca=" + marca + ", model=" + model + ", any=" + any.get(Calendar.YEAR) + '}';
    }
    
    
    
}
