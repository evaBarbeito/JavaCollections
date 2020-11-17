package com.daw.eva.hashsetExamples;

import java.util.HashSet;
import java.util.Set;

public class ExempleSet {
    public static void main(String[] args) {
        Set<Integer> setA = new HashSet<Integer>();
        Set<Integer> setB = new HashSet<Integer>();

        setA.add(1);
        setA.add(2);
        setA.add(3);

        setB.add(3);
        setB.add(4);
        setB.add(5);

//        setA.addAll(setB);
//        setA.removeAll(setB);
//        System.out.println("A: "+setA);
        
        setA.retainAll(setB);//intersecció
        System.out.println("A: "+setA);
    }
}
