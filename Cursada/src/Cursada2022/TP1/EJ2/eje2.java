package Cursada2022.TP1.EJ2;
import java.util.Scanner;

public class eje2 {
    
    public int[] CrearArreglo(int n){

        int[] array = new int[n];

        for(int i = 1; i <= n; i++){
            
            array[i-1] = i*n;

        }


        return array;
    }

    public static void main(String[] args){

        int a;

        Scanner s = new Scanner(System.in);

        a = s.nextInt();
        s.close();

        eje2 clase = new eje2();

        int[] arr = clase.CrearArreglo(a);

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }


    }

}
