package com.daw.eva.generics;

import com.daw.eva.hashset.Persona;

public class DemoGenerics<T,Y> {

	T obj;
	Y message;
	
	//fa el codi més eficient, treballa només amb tipus de referència (Integer, String)
	// no amb tipus primitius (char) 
	public DemoGenerics(T obj, Y m) {
		//super();
		this.obj = obj;
		this.message=m;
	}


	public Y getMessage() {
		return message;
	}


	public void setMessage(Y message) {
		this.message = message;
	}


	public T getObj() {
		return obj;
	}


	public void setObj(T obj) {
		this.obj = obj;
	}


	public static void main(String[] args) {
		
		DemoGenerics <Integer,String> demoA= new DemoGenerics<Integer,String>(22,"hola");
		
		Persona p1= new Persona("Eva", "44444444", 99);
		Persona p2= new Persona("Peter", "5555555", 100);
		
		DemoGenerics <Persona,Persona> demoB= new DemoGenerics<Persona,Persona>(p1,p2);
		
		System.out.println(p1.getNom()+ ", " +p2.getNom());
		
		DemoGenerics<Integer,String> demo= new DemoGenerics<Integer,String>(100,"hi");
		
		DemoGenerics<String,Integer> demo1= new DemoGenerics<String,Integer>("Hello Generics",26);
		
		
		System.out.println(demoA.getObj()+ ", " + demoA.getMessage() + "\n" + demo.getObj() + "\n" + 
		demo1.getObj() + ", " + demo1.getMessage());
		
		
		//exemple de lambda i interfície genèrica funcional
		Message<String> message;
		message= (m) ->{
			return m;
		};
		System.out.println(message.displayMessage("Hello there"));
		
		Message<Integer> message1;
		message1= (m) ->{
			return m*m;
		};
		System.out.println(message1.displayMessage(100));
		
	}

}


