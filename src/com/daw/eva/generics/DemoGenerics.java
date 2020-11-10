package com.daw.eva.generics;

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
		
		DemoGenerics <Integer,String>demoA= new DemoGenerics<Integer,String>(22,"hola");
		
		DemoGenerics<Integer,String> demo= new DemoGenerics<Integer,String>(100,"hi");
		
		DemoGenerics<String,Integer> demo1= new DemoGenerics<String,Integer>("Hello Generics",26);
		
		System.out.println(demoA.getObj()+ ", " + demoA.getMessage() + "\n" + demo.getObj() + "\n" + demo1.getObj() + ", " + demo1.getMessage());
		
	}

}
