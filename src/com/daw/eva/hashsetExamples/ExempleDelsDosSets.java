package com.daw.eva.hashsetExamples;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;





public class ExempleDelsDosSets {

	public static void main(String[] args) {

		HashSet<Dog> hashSetDog = new HashSet<Dog>();//no preserva ordre d'inserció, LinkedHashSet, preserva ordre inserció
		
		hashSetDog.add(new Dog(2));
		hashSetDog.add(new Dog(1));
		hashSetDog.add(new Dog(3));
		hashSetDog.add(new Dog(5));
		hashSetDog.add(new Dog(4));
		
		
		Iterator<Dog> hashSetDogIt = hashSetDog.iterator(); //no serveix
		
		while (hashSetDogIt.hasNext()) {
                    System.out.print(hashSetDogIt.next().getNum() + " ");
                    System.out.println();
		}

		//Possible sortida: 5 3 2 1 4 (ningú et pot garantir l'ordre de sortida)

		System.out.println();
		System.out.println("---------------------");

		LinkedHashSet<Dog> linkedHashSetDog = new LinkedHashSet<Dog>();
		linkedHashSetDog.add(new Dog(2));
		linkedHashSetDog.add(new Dog(1));
		linkedHashSetDog.add(new Dog(3));
		linkedHashSetDog.add(new Dog(5));
		linkedHashSetDog.add(new Dog(4));
		
		Iterator<Dog> linkedHashSetDogIt = linkedHashSetDog.iterator();
		
		while (linkedHashSetDogIt.hasNext()) {
                    System.out.print(linkedHashSetDogIt.next().getNum() + " ");
                    System.out.println();
		}

		//Sortida: 2 1 3 5 4  (l'ordre de sortida és l'ordre d'entrada, FIFO)
	}
}
