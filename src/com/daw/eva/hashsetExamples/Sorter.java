/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.eva.hashsetExamples;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;


public class Sorter {
    public static void main(String[] args) {
    	
    	
    	SortedSet set=new TreeSet();
    	
    	set.add("b");
    	set.add("c");
    	set.add("a");
    	
    	Iterator i=set.iterator();
    	while (i.hasNext()) {
         
            System.out.println(i.next());
        }
    	System.out.println();
    	
        // TreeSet is an implementation of SortedSet
        SortedSet<Employee> setEmpleats = new TreeSet<Employee>(); //ordre sorted ascending order, o interfície Comparable per a objectes

        //descendingIterator

        setEmpleats.add(new Employee("Ashraf", 60));
        setEmpleats.add(new Employee("Sara", 50));
        setEmpleats.add(new Employee("Mohamed", 10));
        setEmpleats.add(new Employee("Esraa", 20));
        setEmpleats.add(new Employee("Bahaa", 40));
        setEmpleats.add(new Employee("Dalia", 30));
        setEmpleats.add(new Employee("Pepito de los Palotes", 10)); //No se añade porque el compareTo() es respecto
                                                                    //a la edad y ya hay un elemento con edad = 10.

        // Iterating over the employees in the setEmpleats
        System.out.println("Set després d'afegir els empleats (amb ordenació perquè és un TreeSet):");
        Iterator<Employee> it = setEmpleats.iterator();
        while (it.hasNext()) {
            // Get employee name and age
            Employee epm = (Employee) it.next();
            System.out.println("Empleat " + epm.getName() + ", edat: " + epm.getAge());
        }

        // Test comparator(), comparator will be null as we are using the Comparable interface, Comparator:interficie que implementa mètode compare(o1,o2)
        // System.out.println("LLista ordenada en funció d'un Comparator:");
        //ColorComparator colorComparator = new ColorComparator();
        //Collections.sort(fruits, colorComparator);
        
        System.out.println();
        System.out.println("Employee Set Comparator: " + setEmpleats.comparator());

        // Test first()
        System.out.println();
        System.out.println("Primer empleat: " + setEmpleats.first().getName() + ", edat: " + setEmpleats.first().getAge());

        // Test last()
        System.out.println();
        System.out.println("Últim empleat: " + setEmpleats.last().getName() + ", edat: " + setEmpleats.last().getAge());

        
        // Test headSetEmpleats()
        System.out.println();
        System.out.println("setEmpleats.headSet(new Employee(\"Dalia\", 30)):");
        SortedSet<Employee> headSetEmpleats = setEmpleats.headSet(new Employee("Dalia", 30));
        // Iterating over the employees in the headSetEmpleats
        Iterator<Employee> headSetEmpleatsIt = headSetEmpleats.iterator();
        while (headSetEmpleatsIt.hasNext()) {
            // Get employee name and age
            Employee epm = (Employee) headSetEmpleatsIt.next();
            System.out.println("Empleat " + epm.getName() + ", edat: " + epm.getAge());
        }

        // Test subSetEmpleats()
        System.out.println();
        System.out.println("setEmpleats.subSet(new Employee(\"Mohamed\", 10), new Employee(\"Sara\", 50)):");
        SortedSet<Employee> subSetEmpleats = setEmpleats.subSet(new Employee("Mohamed", 10), new Employee("Sara", 50));
        // Iterating over the employees in the subSetEmpleats
        Iterator<Employee> subSetEmpleatsIt = subSetEmpleats.iterator();
        while (subSetEmpleatsIt.hasNext()) {
            // Get employee name and age
            Employee epm = (Employee) subSetEmpleatsIt.next();
            System.out.println("Empleat " + epm.getName() + ", edat: " + epm.getAge());
        }

        // Test tailSetEmpleats()
        System.out.println();
        System.out.println("setEmpleats.tailSet(new Employee(\"Bahaa\", 40)):");
        SortedSet<Employee> tailSetEmpleats = setEmpleats.tailSet(new Employee("Bahaa", 40));
        // Iterating over the employees in the tailSetEmpleats
        Iterator<Employee> tailSetEmpleatsIt = tailSetEmpleats.iterator();
        while (tailSetEmpleatsIt.hasNext()) {
            // Get employee name and age
            Employee epm = (Employee) tailSetEmpleatsIt.next();
            System.out.println("Empleat " + epm.getName() + ", edat: " + epm.getAge());
        }
    }   
}
