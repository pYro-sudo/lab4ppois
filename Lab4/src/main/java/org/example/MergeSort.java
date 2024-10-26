package org.example;

public class MergeSort {
    private double arr[];
    public void merge(double arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        double L[] = new double[n1];
        double R[] = new double[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
            }
    }
    public void sort(double arr[], int l, int r)
    {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public void printArray(double arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public boolean isSorted(){
        for(int i=0;i< arr.length-1;++i){
            if(arr[i] > arr[i+1]) return false;
        }
        return true;
    }

    public void MergeSort()
    {
        System.out.println("Given array is");
        printArray(arr);
        sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array is");
        printArray(arr);
    }

    public void setArr(double[] arr) {
        this.arr = arr;
    }

    public double[] getArr() {
        return arr;
    }
}
