package com.daw.eva.hashset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author 
 */
public class exercici1_i_2 {
    public static void main(String args[]) {
        ordreInsercio();
        
        //Poso cada bloc entre claudàtors perquè no l'àmbit de la variable no es comparteixi
        //i els valors de temps d'execució siguin més reals.
        {
        Set<Integer> numbers = new HashSet<Integer>();
        System.out.print("Milisegons en inserir 1.000.000 de nº's en un HashSet: ");
        insertElements(numbers);
        }
        {
        Set<Integer> numbers = new LinkedHashSet<Integer>();
        System.out.print("Milisegons en inserir 1.000.000 de nº's en un LinkedHashSet: ");
        insertElements(numbers);
        }
        {
        Set<Integer> numbers = new TreeSet<Integer>();
        System.out.print("Milisegons en inserir 1.000.000 de nº's en un TreeSet: ");
        insertElements(numbers);
        }
    }

    
    public static void ordreInsercio() {
        HashSet<String> colorsHashSet = new HashSet<String>();
        LinkedHashSet<String> colorsLinkedHashSet = new LinkedHashSet<String>();
        TreeSet<String> colorsTreeSet = new TreeSet<String>();

        for (String color : Arrays.asList("groc", "blau", "verd", "vermell")) {
            colorsHashSet.add(color);
            colorsLinkedHashSet.add(color);
            colorsTreeSet.add(color);
        }

        System.out.println("Cadena original:                    " + Arrays.asList("groc", "blau", "verd", "vermell").toString() + "\n");
        System.out.println("Order of elements in HashSet:       " + colorsHashSet);
        System.out.println("Order of elements in LinkedHashSet: " + colorsLinkedHashSet);
        System.out.println("Order of elements in TreeSet :      " + colorsTreeSet);
        System.out.println();
    }


    public static void insertElements(Set<Integer> s) {
        long finalTime;
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            s.add(i);
        }

        finalTime = System.nanoTime() - startTime;
        System.out.println(TimeUnit.MILLISECONDS.convert(finalTime, TimeUnit.NANOSECONDS));
    }    
}
