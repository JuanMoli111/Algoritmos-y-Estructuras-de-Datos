package TP1.EJ5;

public class eje5 {
    
    static class objUtil
    {
        int min,max;
        double prom;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getMin() {
            return min;
        }
        public void setMin(int min) {
            this.min = min;
        }

        public void setProm(double prom) {
            this.prom = prom;
        }

        public double getProm() {
            return prom;
        }
    }




    public static int[] CalcularArregloReturn(int[] vecEnteros)
    {

        //Arreglo para retornar los resultados 
        int[] Resultados = new int[3];

        //Declarar variables para calcular el promedio, el max y el minimo elementos
        int Total = 0, Max = -99999, Min = 99999;


        for(int i = 0; i < vecEnteros.length ; i++)
        {
            Total += vecEnteros[i];

            if(Max < vecEnteros[i])
            {
                Max = vecEnteros[i];
            }

            if(Min > vecEnteros[i])
            {
                Min = vecEnteros[i];
            }
        } 

        //Devolver en la primera posicion el promedio de los elementos
        //en la segunda y tercera posicion, los elementeos maximo y minimo respectivamente
        Resultados[0] = Total/vecEnteros.length;
        Resultados[1] = Max;
        Resultados[2] = Min;

        return Resultados;
    }
    
    
    public static void CalcularArregloParams(int[] vecEnteros, objUtil obj)
    {
        int Total = 0;
        
        int max = -99999;
        int min = 99999;

        for(int i = 0; i < vecEnteros.length ; i++)
        {
            Total += vecEnteros[i];

            if(max < vecEnteros[i])
            {
                max = vecEnteros[i];
            }

            if(min > vecEnteros[i])
            {
                min = vecEnteros[i];
            }
        } 

        obj.setMax(max);
        obj.setMin(min);
        obj.setProm((double) (Total / vecEnteros.length));

    }


    public static void CalcularArreglo(int[] vecEnteros)
    {
        int Total = 0;
        
        int max = -99999;
        int min = 99999;

        for(int i = 0; i < vecEnteros.length ; i++)
        {
            Total += vecEnteros[i];

            if(max < vecEnteros[i])
            {
                max = vecEnteros[i];
            }

            if(min > vecEnteros[i])
            {
                min = vecEnteros[i];
            }
        } 

        Double prom = (double)Total/ vecEnteros.length;

        System.out.println(prom + " max: " + max + " min: " + min);


    }


    public static void main(String[] args) {
        


        int[] vec = {1,2,3,10};

        //objUtil obj = new objUtil();

        CalcularArreglo(vec);

        //System.out.println(obj.getProm() + " max: " + obj.getMax() + " min: " + obj.getMin());

    }
}
