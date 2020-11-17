/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.eva.hashsetExamples;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


public class SetDemo {
    public static void main(String[] args) {
        int count[] = {34, 22, 10, 60, 30, 22};
        Set<Integer> setIntegers = new HashSet<Integer>();
        
        for (int i = 0; i < count.length; i++){
            setIntegers.add(count[i]);
        }
        System.out.println("setIntegers: " + setIntegers);
        
        //El 2n 22 no entra en el set perquè el hashCode dels 2 números 22 és el mateix
        //i llavors es fa servir el equals() per a poder-los diferenciar i el equals()
        //diu que són el mateix número.
        
        
        Set<Persona> hashSetPersones = new HashSet<Persona>();
        hashSetPersones.add(new Persona("Pepito_10", 10, "rojo"));
        hashSetPersones.add(new Persona("Pepito_20", 20, "rojo"));
        hashSetPersones.add(new Persona("Manolito_50", 50, "rojo"));
        hashSetPersones.add(new Persona("Pepito_10", 10, "azul"));
        hashSetPersones.add(new Persona("Pepito_10", 50, "rojo"));    //no hi ha ordre, aleatori, 
        
        System.out.println();
        System.out.println("hashSetPersones: ");
        for (Persona personaTmp : hashSetPersones) {
            System.out.println("Persona: " + personaTmp.getName() + ", edat " + personaTmp.getAge() + ", color " + personaTmp.getColor());
        }
        
        
        Set<Persona> linkedHashSetPersones = new LinkedHashSet<Persona>();//preserva ordre d'inserció
        linkedHashSetPersones.add(new Persona("Pepito_10", 10, "rojo"));
        linkedHashSetPersones.add(new Persona("Pepito_20", 20, "rojo"));
        linkedHashSetPersones.add(new Persona("Manolito_50", 50, "rojo"));
        linkedHashSetPersones.add(new Persona("Pepito_10", 10, "azul"));
        linkedHashSetPersones.add(new Persona("Pepito_10", 50, "rojo"));
        
        System.out.println();
        System.out.println("linkedHashSetPersones: ");
        for (Persona personaTmp : linkedHashSetPersones) {
            System.out.println("Persona: " + personaTmp.getName() + ", edat " + personaTmp.getAge() + ", color " + personaTmp.getColor());
        }

        
    }
}
