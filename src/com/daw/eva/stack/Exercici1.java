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
    	miss.offer("2");//offer: encua, posa element a última posició de la llista
    	miss.offer("3");
    	miss.offer("4");
    	//no té mètodes per a apilar, com Deque, push, etc.
    	System.out.println("Exemple LinkedList com a implementació de queue");
    	while (miss.size()>0) {
    		System.out.println(miss.poll());  //recupera i elimina el cap de la cua, primer element de la llista
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
        stackDeque.offer(44);   //offer inserta a la primera posició (abaix de la pila), i push apila, posa a sobre de la pila
        
        printDeque(stackDeque, "Deque (pila) original:"); //les piles es recorren, consulten des del final cap endavant
        System.out.println(stackDeque);
        
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
    
//    public static void invertirPila(Deque<Integer> pila) {
//		Deque<Integer> pilaInvertida = new ArrayDeque<Integer>();
//		while (!pila.isEmpty()) {
//			pilaInvertida.add(pila.pollLast());
//		}
//		// while(!pila.isEmpty()) {
//		// pilaInvertida.push(pila.pop());
//		// }
//		System.out.println("Pila no generica: " + pilaInvertida);
//	}

    
    public static void invertirPilaNoGeneric(Deque<Integer> stack) {
        Deque<Integer> inversStack = new ArrayDeque<Integer>();
        Deque<Integer> cpStack = new ArrayDeque<Integer>();   //la copio per no perdre-la de cara a segona crida, invertirPila
        for (Integer elem:stack){
            cpStack.offer(elem);   //no era push, sino offer:encuar   push fa tractament de pila:apila
          //  System.out.println(elem.toString()); //4,3,2,1,44  es llegeix des del final, copiant-la des del final
        }
        
        
        while (!cpStack.isEmpty()) {
            inversStack.push(cpStack.pop());  //últim, el 4...pop & push, desapilar per apilar a l'altra
        }
        printDeque(inversStack, "Deque (pila) invertida amb mètode no genèric:");
        System.out.println(inversStack);
    }
    
    //Exercici 1
    public static <T> void invertirPila(Deque<T> stack) {
        Deque<T> inversStack = new ArrayDeque<T>();
        while (!stack.isEmpty()) {
            inversStack.push(stack.pop());
      
        }
        printDeque(inversStack, "Deque (pila) invertida amb mètode genèric:");
        System.out.println(inversStack);
    }
    
    
    //public static  void printDeque(Deque<?> stack, String text) {
    public static <T> void printDeque(Deque<T> stack, String text) {
        System.out.println(text);
        for (Object elem:stack){
            System.out.println(elem.toString());
        }
    }

}