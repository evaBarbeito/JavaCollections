package com.daw.eva.generics;

public class DemoGenericsBounded<T extends Number> {

	T obj;

	
	 
	public DemoGenericsBounded(T obj) {
		//super();
		this.obj = obj;

	}


	public T getObj() {
		return obj;
	}


	public void setObj(T obj) {
		this.obj = obj;
	}


	public static void main(String[] args) {
		
		DemoGenericsBounded <Integer> demoA= new DemoGenericsBounded<Integer>(22);
		
		DemoGenericsBounded <Integer> demoAA= new DemoGenericsBounded<Integer>(34);
		
		DemoGenericsBounded<Double> demo1= new DemoGenericsBounded<Double>(26.10);
		
		DemoGenericsBounded<Float> demo= new DemoGenericsBounded<Float>(1.123456789f); //float, f o F, màx 7 decimals, arrodoneix a 7 decimals
		
		System.out.println(demoA.getObj() + "\n" + demo.getObj() + "\n" + demo1.getObj() );
		
	}

}
