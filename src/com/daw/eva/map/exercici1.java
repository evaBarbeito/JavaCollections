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
 * @author 
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
        System.out.println("LLista sencera de cotxesVsColor: " + cotxesVsColor);
        
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
   
    
    
}




