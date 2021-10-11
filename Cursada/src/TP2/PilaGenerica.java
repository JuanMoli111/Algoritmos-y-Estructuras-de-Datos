package TP2;

public class PilaGenerica<T> {
    
    ListaGenerica<T> datos = new ListaEnlazadaGenerica<>();




    public void apilar(T elem)
    {
        datos.agregarFinal(elem);
    }
    


    public T desapilar()
    {
        //Almacenar el ultimo elemento de la pila (el tope)
       
        T elem = datos.elemento(datos.tamanio());

        //Eliminarlo de la pila
        datos.eliminarEn(datos.tamanio());

        //Retornar el elemento
        return elem;
    }

    public T tope()
    {
        //Retornar el ultimo elemento de la pila
        return datos.elemento(datos.tamanio());
    }

    public boolean esVacia()
    {
        return datos.tamanio() == 0;
    }

}
