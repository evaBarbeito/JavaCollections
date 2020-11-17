/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.eva.hashsetExamples;

import java.util.Objects;


public class Persona {
    private String name;
    private int age;
    private String color;
    
    
    public Persona(String nom, int edat, String color){
        super();
        this.name = nom;
        this.age = edat;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }
    
    
    

    @Override
    public int hashCode() {
        //Només té en compte els atributs "name" i "age" i no pas "color".
        //2's persones amb nom i/o edat diferent tenen un hasCode diferent i per tant són
        //diferents i no fa falta fer servir el equals() per a veure si són iguals.
        //2's persones amb el mateix nom i edat però diferent color seran iguals pel hashCode() perquè
        //donen el mateix hash, a llavors es farà servir equals() per a veure si són diferents.
        
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + this.age;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        //Diferenciarà 2's persones pel nom, edat i color. Si algun dels 3 atributs és diferent, dirà
        //que les 2's persones són diferents. Exemple:
        //       new Persona("Pepito_10", 10, "rojo") != new Persona("Pepito_10", 10, "azul"))
        //
        //Si comentem les linies que comparen el color, llavors dirà que 2's persones són iguals
        //si tenen el mateix nom i edat. Exemple:
        //       new Persona("Pepito_10", 10, "rojo") = new Persona("Pepito_10", 10, "azul"))
        
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        //if (!Objects.equals(this.color, other.color)) {
        //    return false;
        //}
        return true;
    }
    
    
    
}
