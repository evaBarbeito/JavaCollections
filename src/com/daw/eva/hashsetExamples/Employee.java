/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.eva.hashsetExamples;

/**
 *
 *  
 */
public class Employee implements Comparable<Employee> {
    private String name;
    private int age;


    public Employee(String name, int age) {
            super();
            this.name = name;
            this.age = age;
    }

    public String getName() {
            return name;
    }

    public void setName(String name) {
            this.name = name;
    }

    public int getAge() {
            return age;
    }

    public void setAge(int age) {
            this.age = age;
    }


    @Override
    public int compareTo(Employee o) {
        //El TreeSet usa el compareTo() para saber como debe ordenar los elementos que contiene y 
        //los que se van añadiendo. 2 elementos no pueden ocupar la misma posición en el árbol. 
        //Si añadimos un elemento que va a ocupar una posición que ya está ocupada en el árbol, no 
        //se añadirá de manera automática.
        
        //ascending order
        return this.age - o.getAge();

        //descending order
        //return o.getAge() - this.age;
     }

//	@Override
//	public int compareTo(Employee o) {
//		return this.getName().compareTo(o.getName());
//	}

// 	@Override
// 	public int compareTo(Bean o) {
// 		return o.getName().compareTo(this.getName());
// 	}

}