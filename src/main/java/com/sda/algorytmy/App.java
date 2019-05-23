package com.sda.algorytmy;

import java.util.Arrays;
import java.util.Collections;

/**
 * Hello world!
 *
 */
public class App 
{
    public static int suma(int[] tab){

        if(tab.length == 0){
            return 0;
        }
        int[] tab2 = new int[tab.length-1];
        int pierwszy = tab[0];
        tab = Arrays.copyOfRange(tab, 1, tab.length);
        return pierwszy + suma(tab);
    }

    public static void quicksort(int[] tab, int x, int y){
        int i,j,v,temp;
        i=x;
        j=y;
        v=tab[(x+y) / 2];
        while (i<=j){
            while (tab[i]<v) {
                i++;
            }
            while (v<tab[j]) {
                j--;
            }
            if (i<=j) {
                temp=tab[i];
                tab[i]=tab[j];
                tab[j]=temp;
                i++;
                j--;
            }
        }

        if (x<j) {
            quicksort(tab, x, j);
        }
        if (i<y) {
            quicksort(tab, i, y);
        }
    }

    public static void main( String[] args )
    {

        int[] tab = {2,4,6,-11,3,2,4,6,2,454346,436,346,3434,23423,4232,2};
        System.out.println(suma(tab));
       quicksort(tab, 0,tab.length-1);
       for (int i = 0; i<tab.length; i++){
           System.out.println(tab[i]);
       }
    }
}
