package TP1.EJ1;
public class eje1 {
    

    public static void PrintFor(int a, int b)
    {
        for(int i = a; i <= b; i++)
        {
            System.out.println(i);
        }
    }

    public static void PrintWhile(int a, int b)
    {
        while(a <= b) 
        {
            System.out.println(a++);
        }
    }

    public static void PrintSinIter(int a, int b)
    {
        if(a == b)
        {
            System.out.println(b);
        }
        else
        {   
            //Incrementar desp de imprimir, pero ANTES de hacer recursion, o entrará en un loop infinito
            System.out.println(a++);
            PrintSinIter(a, b);
        }
    }

    public static void main(String[] args) throws Exception {
        
        PrintFor(1,3);

        PrintWhile(16, 44);

        PrintSinIter(4, 8);
    }
}
