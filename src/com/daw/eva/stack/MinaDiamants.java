package com.daw.eva.stack;

import java.util.ArrayDeque;
import java.util.Deque;



public class MinaDiamants {
    public static void main(String[] args) {
        String[] mina = {"<","<","(",")",">",">"};

        extreuDiamants(mina);
    }


    public static void extreuDiamants(String mina[]){
        Deque<String> pilaDiamants = new ArrayDeque<String>();
        int blanc =0;
        int negre = 0;

        for(String elem:mina){
            //System.out.println("ret="+pilaDiamants.peekLast());
            if (!pilaDiamants.isEmpty() && pilaDiamants.peekFirst().equals("<") && elem.equals(">")){ 
                blanc++;
                pilaDiamants.pop();
            }
            else {
                if (!pilaDiamants.isEmpty() && pilaDiamants.peekFirst().equals("(") && elem.equals(")")){ 
                    negre++;
                    pilaDiamants.pop();
                }
                else pilaDiamants.push(elem);
            }
        }
        System.out.println("A la mina hi "+blanc+" diamants blancs i "+negre+" diamants negres");
    }
}
