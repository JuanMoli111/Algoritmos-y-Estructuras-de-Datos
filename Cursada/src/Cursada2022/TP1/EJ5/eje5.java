package Cursada2022.TP1.EJ5;

public class eje5 {
    

    //Inciso 5a.
    public Data MaxMinPromReturn(Integer[] array){
      
        //Declarar variables para calcular datos
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        double sum = 0, cant = 0;

        //Recorrer el array
        for(int i = 0; i < array.length; i++){

            //Calcular max/min
            if(array[i] > max) max = array[i];
            if(array[i] < min) min = array[i];

            sum += array[i];    cant += 1;
        }

        //Retornar objeto Data inicializado con los valores calculados
        return new Data(max,min,sum/cant);
    }

    //inciso 5b.
    public void MaxMinPromParam(Integer[] array, Data datos){
        //Declarar variables para calcular datos
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        double sum = 0, cant = 0;

        //Recorrer el array
        for(int i = 0; i < array.length; i++){

            //Calcular max/min
            if(array[i] > max) max = array[i];
            if(array[i] < min) min = array[i];

            sum += array[i];    cant += 1;
        }

        datos.setMax(max);
        datos.setMin(min);
        datos.setProm(sum/cant);
    }

    public static void MaxMinProm(Integer[] array){
        //Declarar variables para calcular datos
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        double sum = 0, cant = 0;

        //Recorrer el array
        for(int i = 0; i < array.length; i++){

            //Calcular max/min
            if(array[i] > max) max = array[i];
            if(array[i] < min) min = array[i];

            sum += array[i];    cant += 1;
        }

        Data datos = new Data(max,min,sum/cant);

        System.out.println(datos.toString());
    }

    

    
    public static void main(String[] args) {

        

        eje5 program = new eje5();

        Integer[] array = {9,8};

    

        //Data data = new Data();
        Data datos = program.MaxMinPromReturn(array);

        MaxMinProm(array);



        System.out.println(datos.toString());

    }

}