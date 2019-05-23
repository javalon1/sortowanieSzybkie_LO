package com.sda.algorytmy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private static List<Integer> quicksortExample2(List<Integer> list) {
        if (list.size() < 2) {
            // base case, arrays with 0 or 1 element are already "sorted"
            return list;
        } else {
            // recursive case
            Integer pivot = list.get(0);

            // sub-array of all the elements less than the pivot
            List<Integer> less = list.stream().skip(1).filter(el -> el <= pivot)
                    .collect(Collectors.toList());

            // sub-array of all the elements greater than the pivot
            List<Integer> greater = list.stream().skip(1).filter(el -> el > pivot)
                    .collect(Collectors.toList());

            return Stream.of(
                    quicksortExample2(less).stream(),
                    Stream.of(pivot),
                    quicksortExample2(greater).stream())
                    .flatMap(Function.identity()).collect(Collectors.toList());
        }
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
