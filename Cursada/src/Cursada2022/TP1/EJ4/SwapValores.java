package Cursada2022.TP1.EJ4;

public class SwapValores {

    public class obj{
        int a, b;
        
    }

    //Recibe una copia de los valores a y b, los intercambia, al volver al programa principal los valores se pierden
    public static void swap1 (int x, int y){
        if(x < y){
            int tmp = x;
            x = y;
            y = tmp;
            System.out.println("x = " + x + ", y = " + y);

        }
    }

    //Recibe una copia de las direcciones, x e y referencian a ese objeto
    public static void swap2(Integer x, Integer y){
        if(x < y){
            int tmp = y;
            x = y;
            y = tmp;  
            System.out.println("x = " + x + ", y = " + y);
 
        }    
    }


    public static void main(String[] args){
        int a = 1, b = 2;
        Integer c = 3, d =4;
        swap1(a, b);
        swap2(c,d);

        System.out.println(c.hashCode());

        System.out.println("a = " + a + ", b = " + b);
        System.out.println("c = " + c + ", d = " + d);
    }

}
