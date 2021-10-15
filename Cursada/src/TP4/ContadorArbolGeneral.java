package TP4;

import TP2.ListaGenerica;

public class ContadorArbolGeneral {
    

    public static Integer contarSt(ArbolGeneral<String> a, String dato)
    {

        Integer cantVeces = 0;

        ListaGenerica<ArbolGeneral<String>> hijos = a.getHijos();

        if(!hijos.esVacia())
            hijos.comenzar();
            cantVeces = cantVeces + contarSt(a, dato);

        //COMPARAR EL DATO DE LA RAIZ CON EL DATO,
        if(a.getDatoRaiz().equals(dato))
            cantVeces++;

        while(!hijos.fin())
            cantVeces += contarSt(hijos.proximo(), dato);

        return cantVeces;
    }

}
