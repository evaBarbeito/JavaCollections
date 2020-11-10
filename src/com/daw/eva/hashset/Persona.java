package com.daw.eva.hashset;

import java.util.HashSet;
import java.util.Iterator;

public class Persona {

	 private String nom; 
	 private String dni;  
	 private int edat;
	 
	 
	
	
	public Persona(String nom, String dni, int edat) {
		super();
		this.nom = nom;
		this.dni = dni;
		this.edat = edat;
	}




	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public String getDni() {
		return dni;
	}




	public void setDni(String dni) {
		this.dni = dni;
	}




	public int getEdat() {
		return edat;
	}




	public void setEdat(int edat) {
		this.edat = edat;
	}




	@Override
	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
//		result = prime * result + edat;
//		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
//		return result;
		return this.nom.hashCode();
	}




	@Override
	public boolean equals(Object obj) {

//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Persona other = (Persona) obj;
//		if (dni == null) {
//			if (other.dni != null)
//				return false;
//		} else if (!dni.equals(other.dni))
//			return false;
//		if (edat != other.edat)
//			return false;
//		if (nom == null) {
//			if (other.nom != null)
//				return false;
//		} else if (!nom.equals(other.nom))
//			return false;
//		return true;
	
		return this.dni.equals(((Persona) obj).getDni());
		
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Persona p;   
		 // Sense duplicats    
		 HashSet persones = new HashSet();     
		 
		 //LinkedHashSet preserva l'ordre d'inserció
		 
		 persones.add(new Persona("P1", "1111111Z", 23));    
		 persones.add(new Persona("P2", "2222222Z", 24));  
		 persones.add(new Persona("P3", "3333333Z", 25));  
		 persones.add(new Persona("P3", "3333333Z", 28));   // Aquest està repe per culpa del hash i l'equals()   
		 persones.add(new Persona("P3", "6666666Z", 25));   // Aquest no està repe per culpa del l'equals()    
		 persones.add(new Persona("P4", "3333333Z", 25));   // Sense ordre i sense definir operació hashCode aquesta iteració retorna ordres aleatoris ; comentar hashcode:ordena pel nom   
		 // Cada vegada es calcula hashCode diferent    
		 Iterator<Persona> iter = persones.iterator();   
		 while (iter.hasNext()) {      
			 p = iter.next();     
			 System.out.println(p.getNom() + " " +p.getDni() + " " + p.getEdat());
		 }
		
	}

}
