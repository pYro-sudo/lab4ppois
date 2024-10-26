package org.example;

import java.util.Vector;

public class BozoSort {
    private Vector<Double> array;

    private void swap(double a, double b){
        double t = a;
        a = b; b = t;
    }

    public void sort(Vector<Double> array) {
        int length = array.size();
        while (!isSorted(array)) {
            double i = array.get((int) (Math.random()*length));
            double j = array.get((int) (Math.random()*length));
            swap(Math.min(i, j), Math.max(i, j));
        }
    }
    public static boolean isSorted(Vector<Double> array) {
        if(array.size() == 1){
            return true;
        }
        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i) > array.get(i+1))
                return false;
        }
        return true;
    }

    public void PrintArray(Vector<Double> array){
        for(int i=0;i<array.size();++i){
            System.out.print(array.get(i)+" ");
        }
        System.out.println("");
    }

    public void BozoSort(){
        System.out.println("The array before");
        PrintArray(array);
        System.out.println("After Sorting");
        sort(this.array);
        PrintArray(array);
    }

    public Vector<Double> getArray() {
        return array;
    }

    public void setArray(Vector<Double> array) {
        this.array = array;
    }
}
