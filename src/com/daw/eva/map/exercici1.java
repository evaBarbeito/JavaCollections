/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.eva.map;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;


import java.util.Set;

/**
 *
 * @ 
 */
public class exercici1 {
    static LinkedHashMap<String, vehicle> matricules;
    
    
    public static void main(String[] args) {
        //------------EXERCICI 1------------
        
        // Create a linked hash map (ordenat en funció de l'ordre d'entrada en el map).
        ArrayList<vehicle> cotxesVsColor = new ArrayList<vehicle>();
        matricules = new LinkedHashMap<String, vehicle>();
        
        System.out.println("-------- EXERCICI 1 ---------");
        
        System.out.println("-------- 0 ---------");
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        Calendar data = new GregorianCalendar(2013,0,31);           // Jan = 0, dec = 11
        System.out.println("data.getTime() = " + dataFormat.format(data.getTime()));
        System.out.println("data.get(Calendar.YEAR) = " + data.get(Calendar.YEAR));
      
        matricules.put("B8240KY", new vehicle("blanco", "Opel", "Kadet", new GregorianCalendar(1990,0,1)));
        matricules.put("8040BGZ", new vehicle("rojo", "Seat", "Panda", new GregorianCalendar(1985,0,1)));
        matricules.put("8140BGZ", new vehicle("negro", "Seat", "Leon", new GregorianCalendar(2005,0,1)));
        matricules.put("7440BGZ", new vehicle("blanco", "Seat", "Ibiza", new GregorianCalendar(1990,0,1)));
        matricules.put("8240BGZ", new vehicle("azul", "Volkswagen", "Passat", new GregorianCalendar(2007,0,1)));
      
        
        cotxesVsColor = cotxesVsColor("blanco");
        System.out.println();
        System.out.println("-------- 4 ---------");
        System.out.println("LLista sencera de cotxesVsColor: " );
        System.out.println( cotxesVsColor);
        
        for (vehicle cotxeTmp:cotxesVsColor){
            System.out.println("    cotxeTmp = " + cotxeTmp);
            System.out.println("        cotxeTmp (color) = " + cotxeTmp.getColor() + " : cotxeTmp (model) = " + cotxeTmp.getModel());
            
        }
        
        System.out.println();
        System.out.println("-------- 5 ---------");
        System.out.println("LLista de cotxes vs any:");
        llistarCotxesIAny();
        
        System.out.println("Buscant i eliminant els cotxes anteriors a 1995...");
        esborrarCotxesVsAnteriorsAny(1995);
        
        System.out.println("LLista de cotxes vs any:");
        llistarCotxesIAny();
        
        
        //------------EXERCICI 2------------
        System.out.println();
        System.out.println("-------- EXERCICI 2 ---------");
        
        LinkedHashMap<String, ArrayList<String>> modelsPerMarca = new LinkedHashMap<String, ArrayList<String>>();
        
        modelsPerMarca.put("Opel", new ArrayList<String>(Arrays.asList("Kadet", "Corsa")));
        modelsPerMarca.put("Seat", new ArrayList<String>(Arrays.asList("Panda", "Leon", "Ibiza")));
        modelsPerMarca.put("Volkswagen", new ArrayList<String>(Arrays.asList("Passat")));
        llistarModelsPerMarca(modelsPerMarca);
    }
       
    
    
    public static void llistarModelsPerMarca(LinkedHashMap<String, ArrayList<String>> modelsPerMarcaTmp){
        for ( Entry<String, ArrayList<String>> dada : modelsPerMarcaTmp.entrySet() ){
            System.out.println("Models de la marca " + dada.getKey() + ":" + dada.getValue());
        }
    }
    
    

    public static void esborrarCotxesVsAnteriorsAny(int any){
        int anyTmp;
        
        /*
        //AQUEST SISTEMA NO VA.
        for ( Entry<String, vehicle> mapa : matricules.entrySet() ){
            anyTmp = (int)mapa.getValue().any.get(Calendar.YEAR);

            if (anyTmp < any) {
                System.out.println("ccc");
                matricules.remove(mapa.getKey());
            }
        }
        */
        
        //AQUEST SISTEMA SÍ QUE VA.
        Iterator<String> it = matricules.keySet().iterator();
        while ( it.hasNext() ){
            String key = it.next();

            anyTmp = matricules.get(key).any.get(Calendar.YEAR);

            if (anyTmp < any) {
                //System.out.println("ccc");
                it.remove();
            }
        }
    }
    
    
    public static void llistarCotxesIAny(){
        for ( Entry<String, vehicle> mapa : matricules.entrySet() ){
            System.out.println("marca = " + mapa.getValue().marca);
            System.out.println("model = " + mapa.getValue().model);
            System.out.println("any = " + mapa.getValue().any.get(Calendar.YEAR));
            System.out.println("------");
        }
    }
    
    
    
    public static ArrayList<vehicle> cotxesVsColor (String color){
        vehicle cotxeTmp;
        
        ArrayList<vehicle> llistaCotxesVsColor = new ArrayList<vehicle>();

        //UNA FORMA DE VISUALITZAR EL CONTINGUT D'UN MAP.
        System.out.println();
        System.out.println("-------- 1 ---------");
        
        Set set = matricules.entrySet();                // Get a set of the entries
        Iterator i = set.iterator();                    // Get an iterator

        while(i.hasNext()) {                            // Display elements
            // Creem l'objecte "me" de tipus Entry (serà una entrada equivalent a la de "i" i per tant
            // tindrà la forma "<String, vehicle>" ja que "i" probé de "set" i aquest de "matricules" i
            // "matricules" té la forma "<String, vehicle>").
          
            Map.Entry me = (Map.Entry)i.next();          
            System.out.println("Clau = " + me.getKey());
            System.out.println("Valor = " + me.getValue());
            System.out.println("Valor.toString() = " + me.getValue().toString() );

            cotxeTmp = (vehicle)me.getValue();
            System.out.println("cotxeTmp.getColor()= " + cotxeTmp.getColor() + "; cotxeTmp.getModel() = " + cotxeTmp.getModel());
            System.out.println("------");

            if (cotxeTmp.getColor().equalsIgnoreCase(color)) {
                llistaCotxesVsColor.add(cotxeTmp);
            }
        }
        
        //UNA ALTRE FORMA DE VISUALITZAR EL CONTINGUT D'UN MAP.
        System.out.println();
        System.out.println("-------- 2 ---------");
        
        Iterator<String> it = matricules.keySet().iterator();
        while ( it.hasNext() ){
            String key = it.next();
            System.out.println( "key = " + key + " ; valor = " + matricules.get(key));
            System.out.println("color = " + matricules.get(key).color);
            System.out.println("------");
        }
        
        //UNA ALTRE FORMA DE VISUALITZAR EL CONTINGUT D'UN MAP.
        System.out.println();
        System.out.println("-------- 3 ---------");
        
        for ( Entry<String, vehicle> mapa : matricules.entrySet() ){
            System.out.println("getKey() = " + mapa.getKey());
            System.out.println("getValue() = " + mapa.getValue());
            System.out.println("getValue().toString() = " + mapa.getValue().toString());
            System.out.println("model = " + mapa.getValue().model);
            System.out.println("------");
        }
          
        return llistaCotxesVsColor;
    }
   
    
//    
// // Volem crear un map on ficarem totes les rutes creades en el menú 20. S'ha d'executar el menú 20 abans.
// 	// Poden existir rutes amb les mateixes dades (menys el ID, es clar).
// 	// Crea el mapa que mantingui l'ordre temporal en que es van inserir les rutes.
// 	// Visualitza de 3 formes diferents el contingut del mapa (veure un dels exemples que hi ha penjat en el moodle).
// 	// Copia tot el contingut del mapa en comprovacioRendimentTmp.mapaLinkedDeRutes . Alerta: s'ha de crear l'objecte en el constructor.
// 	//30. Crear un MAP de rutes i visualitzar-lo.
// 	public static void crearLinkedHashMapDeRutes (ComprovacioRendiment comprovacioRendimentTmp) {
// 		long tempsInicial;
// 		long tempsFinal;
// 		int temps1aForma;
// 		int temps2aForma;
// 		int temps3aForma;
// 		LinkedHashMap<Integer, Ruta_Dades> mapaLinkedDeRutes;
// 		int clauDelMap;
// 		
// 		
// 		mapaLinkedDeRutes = new LinkedHashMap<Integer, Ruta_Dades>();
// 		for(Ruta_Dades rutaTmp : comprovacioRendimentTmp.llistaRutes) {
// 			mapaLinkedDeRutes.put(rutaTmp.getId(), rutaTmp);
// 		}
// 		
// 		// 1a forma de visualitzar el contingut del map.
// 		// Fem un set amb les entrades del map i el recorrem. Es crea un set on el seu contingut són les entrades del mapa.
// 		tempsInicial = System.nanoTime();
// 		Set setTmp = mapaLinkedDeRutes.entrySet();
// 		Iterator it1 = setTmp.iterator();
// 		System.out.println("1a forma de visualitzar el contingut del map (map --> set + iterador del set):");
//         while(it1.hasNext()) {
//            Map.Entry me = (Map.Entry)it1.next();
//            System.out.println("Clau del map = " + me.getKey() + ": \n" + me.getValue().toString());
//         }
//         tempsFinal = System.nanoTime();
//         temps1aForma = (int)((tempsFinal - tempsInicial)/1000);
//         
//         // 2a forma de visualitzar el contingut del map.
//         // Fem un iterador que navegui per les claus del mapa. Es crea un set on el seu contingut són les claus del map.
// 		tempsInicial = System.nanoTime();
//         System.out.println();
//         System.out.println("2a forma de visualitzar el contingut del map (iterator de les claus del map):");
//         Iterator<Integer> it2 = mapaLinkedDeRutes.keySet().iterator();
//         while (it2.hasNext()) {
//             clauDelMap = it2.next();
//             System.out.println(clauDelMap + ": " + mapaLinkedDeRutes.get(clauDelMap));
//         }
//         tempsFinal = System.nanoTime();
//         temps2aForma = (int)((tempsFinal - tempsInicial)/1000);
//         
//         // 3a forma de visualitzar el contingut del map.
//         // Lo mateix que la forma 1 però fent servir un bucle for en comptes d'un iterator.
//         tempsInicial = System.nanoTime();
//         System.out.println();
//         System.out.println("3a forma de visualitzar el contingut del map (for-each del map --> set):");
//         for (Entry<Integer, Ruta_Dades> dada : mapaLinkedDeRutes.entrySet()) {
//             System.out.println(dada.getKey() + ": " + dada.getValue().toString());
//         }
//         tempsFinal = System.nanoTime();
//         temps3aForma = (int)((tempsFinal - tempsInicial)/1000);
// 		
//         System.out.println();
//         System.out.println("TEMPS PER 1a FORMA (map --> set + iterador del set): " + temps1aForma);
//         System.out.println("TEMPS PER 2a FORMA (iterator de les claus del map): " + temps2aForma);
//         System.out.println("TEMPS PER 3a FORMA (for-each del map --> set): " + temps3aForma);
// 		
//         
//         comprovacioRendimentTmp.mapaLinkedDeRutes.putAll(mapaLinkedDeRutes);
//         // No fem un return de comprovacioRendimentTmp perquè en realitat quan el rebem per paràmetre, estem rebent un apuntador i no
//         // el propi objecte.
//         // EL PROBLEMA ÉS QUE A LLAVORS NO SABEM QUINS MÈTODES MODIFIQUEN EL CONTINGUT DE comprovacioRendimentTmp A MENYS QUE
//         // MIREM EL SEU CODI.
// 	}
    
}




