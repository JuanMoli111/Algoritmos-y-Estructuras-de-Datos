package Cursada2022.TP2.ListasGenericas;

public class ColaGenerica<T> {
    ListaEnlazadaGenerica<T> datos;

    public ColaGenerica(){
        datos = new ListaEnlazadaGenerica<T>();
    }


    //Encolar un elemento en la cola
    public void encolar(T elem){
        datos.agregarFinal(elem);
    }


    //Desencola un elemento de la cola, si no hay elementos retorna null
    public T desencolar(){
        T elem = datos.elemento(1);
        datos.eliminarEn(1);

        return elem;
    }

    //Metodo para consultar el elemento al principio de la cola, si no hay elementos retorna null
    public T tope(){
        return datos.elemento(1);
    }

    //Consultar si la cola es vacia
    public boolean esVacia(){
        return datos.esVacia();
    }

}
