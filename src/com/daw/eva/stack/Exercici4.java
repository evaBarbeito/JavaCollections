package com.daw.eva.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;



public class Exercici4 {
	
	
//	Donada una cua, fes una funció per obtenir els elements a la inversa. Implementa una versió utilitzant un iterador,
//	i una versió sense utilitzar iterador. Ambdós casos funcionaran per qualsevol implementació de cua? 

    public static void main(String[] args) {
        Deque<String> cua1 = new LinkedList<String>();
        Deque<String> cua2 = new ArrayDeque<>();

        cua1.addAll(Arrays.asList("1","2","3","4"));
        cua2.addAll(Arrays.asList("1","2","3","4"));

        System.out.println("Cua original: " + cua1);
        System.out.println("Cua invertida amb iterator: " + invertirCua(cua1));
        System.out.println("Cua invertida sense iterator: " + invertirCua2(cua2));
    }


    /**
     * A teoria hem vist la LinkedList i ArrayDeque com implementacions de cua, com que volem utilitzar
     * una funció genèrica que ens serveixi per aquests dos casos de Cua,veiem que una manera d'iterar els elements
     * a la inversa és utilitzant descendingIterator. La interfície comuna que implementen i té aquesta operació es 
     * Deque per això s'ha utilitzat com a paràmetre d'entrada. Com a paràmetre de sortida podem haver escollit 
     * qualsevol de les dues implementacions
     */
    public static <T> Queue<T> invertirCua(Deque<T> cua){
        //Com "cua" és un objecte (s'ha creat amb un new) es passa per referència i no per valor.
        Queue<T> q = new LinkedList<T>();
        
        Iterator<T> it = cua.descendingIterator();
        while (it.hasNext()){
            q.add(it.next());
        }
        return q;
    }


    /**
     * En aquest cas per invertir la cua el que volem es retornar una pila, per això canvia el paràmetre de sortida
     */
    public static <T> Deque<T> invertirCua2(Deque<T> cua){
        Deque<T> pila = new ArrayDeque<T>();
        
        int mida = cua.size();
        for (int i = 0; i < mida; i++) {
            pila.push(cua.removeFirst());
        }

        return pila;
    }

}
