package Cursada2022.TP2.ListasGenericas;

public class PilaGenerica<T> {
    ListaEnlazadaGenerica<T> datos;

    //Inicializar la pila, inicializar la lista enlazada
    public PilaGenerica(){
        datos = new ListaEnlazadaGenerica<T>();
    }

    //Apilar un elemento
    public void apilar(T elem){
        datos.agregarFinal(elem);
    }

    //Desapilar un elemento de la pila, si no hay elementos retorna null
    public T desapilar(){
        T elem = datos.elemento(datos.tamanio());
        datos.eliminarEn(datos.tamanio());

        return elem;
    }

    //Consultar el elemento al tope de la pila, si no hay elementos retorna null
    public T tope(){
        return datos.elemento(datos.tamanio());
    }

    //Consultar si la pila es vacia
    public boolean esVacia(){
        return datos.esVacia();
    }


}
