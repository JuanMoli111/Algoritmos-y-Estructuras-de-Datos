package TP1.EJ2;

import java.util.Scanner;

public class eje2 {
    

    public int[] CrearVector(int n)
    {
        int[] vec = new int[n]; 

        for(int i = 0; i < n; i++)
        {    
            vec[i] = n*(i + 1);
        }

        return vec;
    }



    public static void main(String[] args)
    {

        eje2 program = new eje2();

        Scanner s = new Scanner(System.in);

        int inputNum = s.nextInt();

        while(inputNum != 0)
        {
            for (int elem : program.CrearVector(inputNum)) 
            {
                System.out.print(elem + " / ");
            }
            
            inputNum = s.nextInt();

        }

        s.close();
    }
}
