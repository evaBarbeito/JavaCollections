/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.eva.hashset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *  
 */
public class exercici3 {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<Integer>(Arrays.asList(1, 2, 3));
        Set<Integer> b = new HashSet<Integer>(Arrays.asList(3, 4, 5));
        
        System.out.println("El conjunt 'a' original és: " + a);
        System.out.println("El conjunt 'b' original és: " + b);
        System.out.println();

        Set<Integer> unio = unio(a, b);
        System.out.println("El conjunt unio és: " + unio);

        Set<Integer> interseccio = interseccio(a, b);
        System.out.println("El conjunt intersecció és: " + interseccio);

        Set<Integer> resta = resta(a, b);
        System.out.println("El conjunt resta és: " + resta);

        boolean subconjunt = subconjunt(a, b);
        System.out.println("El conjunt subconjunt és: " + subconjunt);
        
        Set<Integer> diferenciaSimetrica = diferenciaSimetrica(a, b);
        System.out.println("El conjunt diferencia simetrica és: " + diferenciaSimetrica);
    }

    
    public static <T> Set<T> unio(Set<T> a, Set<T> b) {
        Set<T> unio = new HashSet<T>();
        unio.addAll(a);
        unio.addAll(b);
        return unio;
    }

 
    public static <T> Set<T> interseccio(Set<T> a, Set<T> b) { //22
        Set<T> interseccio = new HashSet<T>();
        interseccio.addAll(a);
        interseccio.retainAll(b);
        return interseccio;
    }

 
    public static  <T> Set<T> resta(Set<T> a, Set<T> b){   //23
        Set<T> resta = new HashSet<T>();
        resta.addAll(a);
        resta.removeAll(b);
        return resta;
    }


    public static  <T> Boolean subconjunt(Set<T> a, Set<T> b){
        return a.containsAll(b);
    }

 
    public static <T> Set<T> diferenciaSimetrica (Set<T>a, Set<T> b){
        return resta(unio(a,b), interseccio(a,b));
    } 
}
