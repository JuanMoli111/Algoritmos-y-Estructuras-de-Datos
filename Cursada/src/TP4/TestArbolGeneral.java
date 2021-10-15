package TP4;

public class TestArbolGeneral {
    


    public static void main(String[] args) {
        

        ArbolGeneral<Integer> AG = new ArbolGeneral<>(5);

        

        AG.agregarHijo(new ArbolGeneral<Integer>(7));
        AG.agregarHijo(new ArbolGeneral<Integer>(4));

        AG.agregarHijo(new ArbolGeneral<Integer>(15));
        AG.agregarHijo(new ArbolGeneral<Integer>(71));

        AG.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(715));
        AG.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(29));


        AG.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(7451));


        AG.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(741));

        System.out.println("");
        System.out.println("");

        AG.preOrden();

        System.out.println("");
        System.out.println("");

        AG.postOrden();

        System.out.println("");        
        System.out.println("");

        AG.inOrden();

        System.out.println("");        
        System.out.println("");

        AG.recorridoPorNiveles();
    }



}
