package com.daw.eva.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;


public class Principal {
    public static void main(String[] args){
        Map<String,Persona> map = new LinkedHashMap<String, Persona>();

        Persona p1 = new Persona(1,"asd");
        map.put("uno",  p1);
        map.put("dos", new Persona(21,"asddf") );
        map.put("dos", new Persona(22,"asddfasgfsfsfd") );  //Aquest machaca l'anterior perquè té la mateixa clau.
        map.put("tres", new Persona(3,"asdsdf") );

        
        System.out.println(" ------0------ ");
        Iterator<String> it = map.keySet().iterator();
        while ( it.hasNext() ){
            String key = it.next();
            System.out.println( "key: " + key + ", valor: " + map.get(key));

        }
        System.out.println();
        System.out.println(" ------1------ ");
        for ( Entry<String,Persona> mapa : map.entrySet() ){
            System.out.println( "key: " + mapa.getKey() + ", valor: " + mapa.getValue().toString());
        }

        System.out.println();
        System.out.println(" ------2------ ");
        System.out.println("Tamany: " + map.size() );
        System.out.println("Està buit?: " + map.isEmpty() );
        System.out.println("Get(\"uno\"): " + map.get("uno") );
        System.out.println("Get(\"dos\"): " + map.get("dos") );
//	System.out.println(" remove  " + map.remove("uno") );
        System.out.println("ContainsKey(\"uno\"): " + map.containsKey("uno") );
        System.out.println("ContainsValue(\"p1\"):" + map.containsValue(p1) );
        
        System.out.println();
        System.out.println(" ------3------ ");
        Persona p20 = new Persona(20,"pepito");
        System.out.println("ContainsKey(\"veinte\"): " + map.containsKey("veinte") );
        System.out.println("ContainsValue(\"p20\"):" + map.containsValue(p20) );

        System.out.println();
        System.out.println(" ------4------ ");
        map.clear() ;
        System.out.println("Tamany (després del clear): " + map.size() );	
    }
}
