/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.eva.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 *
 *  
 */
public class exercici4 {
    public static void main(String[] args) {
        //Passar arguments al main:
        //  Run --> Set Project Configuration --> Customize:
	//      1. Marcar la "Main Class" amb btn Browse
	//      2. Ficar en Arguments els arguments que volem passar al main
	//      3. Picar al btn de Run Project (triangle verd) perquè fer btn dret sobre la .java i fer "run" no funciona.
        
        //Per definicio en un set tots els elements son diferents per tant no cal fer res mes.
        // Set<String> paraulesDiferents = new HashSet<>(Arrays.asList(args));
        // System.out.println(paraulesDiferents);

        Set<String> paraulesDiferents = new HashSet<String>();
        Set<String> paraulesRepetides = new HashSet<String>();
        for (int i = 0; i < args.length; i++) {
            if (!paraulesRepetides.contains(args[i])) {
                if (paraulesDiferents.contains(args[i])) {
                    paraulesRepetides.add(args[i]);
                    paraulesDiferents.remove(args[i]);
                } else {
                    paraulesDiferents.add(args[i]);
                }
            }
        }
        System.out.println("paraulesDiferents: " + paraulesDiferents);
        System.out.println("paraulesRepetides: " + paraulesRepetides);
    }    
}
