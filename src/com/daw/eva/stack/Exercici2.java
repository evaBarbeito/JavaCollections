package com.daw.eva.stack;

import java.util.ArrayDeque;
import java.util.Deque;



public class Exercici2 {
    public static void main(String[] args) {
        String[] exp ={"(","(",")",")",")"};
        //String[] exp ={"(","(",")",")"};
        
        parsejaExpsMat(exp);
    }


    public static void parsejaExpsMat(String exp[]){
        Deque<String> pilaExp = new ArrayDeque<String>();
        int tanc = 0;

        for(String elem:exp){
           
           if (!pilaExp.isEmpty() && pilaExp.peekFirst().equals("(") && elem.equals(")")){ 
                tanc++;
                pilaExp.pop();
           }
           else pilaExp.push(elem);
            
        }
        if (!pilaExp.isEmpty()) System.out.println("Expressió matemàtica no ben formada"); 
        else System.out.println("Expressions matem:"+tanc+" ");
    }
}
