package com.daw.eva.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;



public class Exercici1 {
	
//	
//	Fes una funció que es digui invertirPila que donada una pila ens retorni una pila en ordre invers.
//	Fes l'exercici per piles concretes per exemple Integers, i després prova-ho de fer genèricament.
	
    public static void main(String[] args) {
        
    	
    	Queue<String> miss=new LinkedList<String>(); //admet nulls, arraydeque és més ràpida
    	miss.offer("1");
    	miss.offer("2");
    	miss.offer("3");
    	miss.offer("4");
    	System.out.println("Exemple LinkedList com a implementació de queue");
    	while (miss.size()>0) {
    		System.out.println(miss.poll());  //recupera i elimina el cap de la cua
    	}
    	System.out.println();
    	
    	Deque<Integer> stackDeque = new ArrayDeque<Integer>();
        
        Integer elem1 = new Integer(1);
        Integer elem2 = new Integer(2);
        Integer elem3 = new Integer(3);
        Integer elem4 = new Integer(4);
        
        stackDeque.push(elem1);
        stackDeque.push(elem2);
        stackDeque.push(elem3);
        stackDeque.push(elem4);
        
        printDeque(stackDeque, "Deque (pila) original:");
        
        System.out.println();
    
        invertirPilaNoGeneric(stackDeque);
        System.out.println();
        invertirPila(stackDeque);    
        
        System.out.println();
        displayMessage("Exemple de mètode genèric a una classe normal, no genèrica");
        displayMessage(12345);
        
    }
    
    //https://moodle.escoladeltreball.org/pluginfile.php/47410/mod_resource/content/2/M03%20Block%202%20-%20UF5%20-%20NF1%20-%20teoria%200.pdf
    
    //exemple de mètode genèric dins d'una classe normal
    public static <T> void displayMessage(T m) {
    	
    	System.out.println(m);
    }

    //exemple de generic bounded types
    //per si volem restringir els tipus a passar a classes o mètodes genèrics
    // p.ex només números, no strings...  Number:float, Integer, double
    // veure classe demoGenericsBounded <T extends Numer > {
    
    
    
    public static void invertirPilaNoGeneric(Deque<Integer> stack) {
        Deque<Integer> inversStack = new ArrayDeque<Integer>();
        Deque<Integer> cpStack = new ArrayDeque<Integer>();
        for (Integer elem:stack){
            cpStack.push(elem);
        }
        
        //cpStack=stack;
        System.out.println(stack);
        
        while (!cpStack.isEmpty()) {
            inversStack.push(cpStack.pop());
        }
        printDeque(inversStack, "Deque (pila) invertida amb mètode no genèric:");
        System.out.println(stack);
    }
    
    //Exercici 1
    public static <T> void invertirPila(Deque<T> stack) {
        Deque<T> inversStack = new ArrayDeque<T>();
        while (!stack.isEmpty()) {
            inversStack.push(stack.pop());
      
        }
        printDeque(inversStack, "Deque (pila) invertida amb mètode genèric:");
    }
    
    //public static  void printDeque(Deque<?> stack, String text) {
    public static <T> void printDeque(Deque<T> stack, String text) {
        System.out.println(text);
        for (Object elem:stack){
            System.out.println(elem.toString());
        }
    }

}