package TP6.GrafoCatedra;

import TP2.ListaGenerica;
import TP2.ColaGenerica;
import TP2.ListaEnlazadaGenerica;



public class Recorridos<T> {


    //Recorrido depth first search para grafos que informa los vertices
    public void dfs(Grafo<T> grafo){

        //Arreglo de booleanos para registrar que vertices estan visitados
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];

        System.out.println("Tamaneo: " + marca.length);

        //recorre la lista de vertices
        for(int i = 0; i < grafo.listaDeVertices().tamanio(); i++){
            
            System.out.println(grafo.listaDeVertices().elemento(i).toString());

            //Si este vertice no está visitado, llama al recorrido dfs con la pos del vertice, el grafo actual y el arreglo de booleanos
            if (!marca[i])
                this.dfs(i, grafo, marca);
        }
    }

    //Metodo privado recursivo que maneja el recorrido dfs
    private void dfs(int i, Grafo<T> grafo, boolean[] marca){

        //Marca como visitado el vertice actual
        marca[i] = true;

        //Crea una arista en nulo para ir recuperando cada arista de la lista
        Arista<T> arista = null;
   
        //Iniciaiza la variable local j donde guardaremos la pos del proximo vertice a visitar
        int j = 0;

        //toma el vertice correspondiente a tal posicion
        Vertice<T> v = grafo.listaDeVertices().elemento(i);

        //System.out.println("El vertice en la posicion: Contiene el dato " + v.getDato());

        //Guarda su lista de adyacentes en ady, es una lista de aristas
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);

        ady.comenzar();

        //Mientras no llega al fin
        while(!ady.fin()){

            //Recupero la prox arista de la lista
            arista = ady.proximo();

            //Consigo la posicion del vertice al que conecta en el grafo
            j = arista.getVerticeDestino().getPosicion() - 1;

            //Si tal posicion no está visitada, llamar recursivamente al recorrido dfs con la posicion de destino, el grafo y el arreglo de marcas
            if(!marca[j])
                this.dfs(j, grafo, marca);

        }

    }


    //depth first search solo que retorna una lista con los vertices visitados
    public ListaEnlazadaGenerica<Vertice<T>> dfsReturnLista(Grafo<T> grafo){

        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];

        ListaEnlazadaGenerica<Vertice<T>> lis = new ListaEnlazadaGenerica<Vertice<T>>();

        for(int i = 0; i < grafo.listaDeVertices().tamanio(); i++){
            if(!marca[i])
                this.dfsReturnLista(i, grafo, lis, marca);
        }

        return lis;
    }

    //Metodo privado recursivo que maneja el depth first search retornando una lista con los vertices visitados
    private void dfsReturnLista(int i, Grafo<T> grafo, ListaEnlazadaGenerica<Vertice<T>> lis, boolean[] marca){

        marca[i] = true;
        int j = 0;
        Arista<T> arista = null;

        Vertice<T> v = grafo.listaDeVertices().elemento(i);

        System.out.println("ANTES DEL ERROR: " + lis.tamanio());
        lis.agregarEn(v,lis.tamanio());

        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();

        while(!ady.fin()){
            arista = ady.proximo();
            j = arista.getVerticeDestino().getPosicion() - 1;

            if(!marca[j]){
                this.dfsReturnLista(j, grafo, lis, marca);
            }
        }
    }

    //Recorre con el metodo dfs, un grafo pesado, calculando el peso de cada camino y retornando una lista de aquellos caminos que coincidan con cierto peso, en este caso 10
    //Esta lista es una lista de listas de vertices, cada lista de vertices representa un camino, de esta forma es una lista de caminos
    public ListaGenerica<ListaGenerica<Vertice<T>>> dfsConCosto(Grafo<T> grafo){

        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];

        ListaGenerica<Vertice<T>> lis = null;

        //    ListaEnlazadaGenerica<ListaGenerica<Vertice<T>>> recorridos = new ListaEnlazadaGenerica<ListaGenerica<Vertice<T>>>(); NO DA ERROR DE COMPILACION, NO SE SI CORRE
        //    ListaGenerica<ListaGenerica<Vertice<T>>> recorridos = new ListaEnlazadaGenerica<ListaGenerica<Vertice<T>>>();         NO DA ERROR DE COMPILACION, NO SE SI CORRE
        //    ListaEnlazadaGenerica<ListaEnlazadaGenerica<Vertice<T>>> recorridos = new ListaEnlazadaGenerica<ListaEnlazadaGenerica<Vertice<T>>>(); PUEDE INSTANCIARSE, PERO DA ERROR POR LOS TIPOS DE LOS PARAMETROS DEL METODO
        //    ListaGenerica<ListaEnlazadaGenerica<Vertice<T>>> recorridos = new ListaEnlazadaGenerica<ListaEnlazadaGenerica<Vertice<T>>>(); PUEDE INSTANCIARSE, PERO DA ERROR POR LOS TIPOS DE LOS PARAMETROS DEL METODO


        ListaGenerica<ListaGenerica<Vertice<T>>> recorridos = new ListaEnlazadaGenerica<ListaGenerica<Vertice<T>>>();
        
        int costo = 0;

        //Para cada vertice
        for(int i = 0; i < grafo.listaDeVertices().tamanio(); i++){

            //Crea una lista de vertices
            lis = new ListaEnlazadaGenerica<Vertice<T>>();

            //Agrega el vertice actual 
            lis.agregarFinal(grafo.listaDeVertices().elemento(i));
            //Lo marca como visitado
            marca[i] = true;

            //Llamar al dfs con la pos actual, el grafo, la lista con camino act, el arreglo de marcas, el costo actual y la lista de recorridos (lista de listas) que devuelve lo requerido 
            this.dfsConCosto(i, grafo, lis, marca, costo, recorridos);

            marca[i] = false;
        }

        return recorridos;
    }

    private void dfsConCosto(int i, Grafo<T> grafo, ListaGenerica<Vertice<T>> lis, boolean[] marca, int costo, ListaGenerica<ListaGenerica<Vertice<T>>> recorridos){


        Vertice<T> vDestino = null;     int p = 0, j = 0;

        //Recupera el vertice actual
        Vertice<T> v = grafo.listaDeVertices().elemento(i);

        //Almacena su lista de adyacentes
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);

        ady.comenzar();

        //Mientras haya adyacentes
        while(!ady.fin()){


            Arista<T> arista = ady.proximo();

            //Toma la posicion del vertice destino de esta arista
            j = arista.getVerticeDestino().getPosicion();

            //si no fue marcado, quiere decir q lo tenemos q considerar para decidir si hay algun camino que lo incluya que sume costo 10 
            //Si ya fue marcado quiere decir que ya pasamos por alli entonces ya fue comprobado
            if(!marca[j]){

                //Recupera el peso
                p = arista.getPeso();


                //Si el peso es mayor a diez no sigue llamando recursivamente
                if((costo + p) <= 10){

                    //Guarda el vertice desino de esta arista
                    vDestino = arista.getVerticeDestino();

                    //Agregarlo a la lista, marcarlo como visitado
                    lis.agregarFinal(vDestino);
                    marca[j] = true;

                    //Si el costo es = 10 agregar este recorrido a la lista de caminos
                    if((costo + p) == 10)
                        recorridos.agregarFinal(lis.clonar());
                    //De lo contrario llamar recursivamente, sumando el peso al costo actual
                    else
                        this.dfsConCosto(j, grafo, lis, marca, costo + p, recorridos);
                    

                    //Eliminar el vertice y desmarcarlo, pues a la vuelta debera consultar otros posibles caminos
                    lis.eliminar(vDestino);
                    marca[j] = false;
                }
            }
        }
    }


    public void bfs(Grafo<T> grafo){
        //Arreglo de booleanos para registrar los vertices ya visitados
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];

        //recorre la lista de vertices
        for(int i = 0; i < marca.length; i++){
            
            //Si este vertice no está visitado, llama al recorrido bfs con la pos del vertice + 1, el grafo actual y el arreglo de booleanos
            if (!marca[i])
                this.bfs(i + 1, grafo, marca);
        }
    }

    private void bfs(int i, Grafo<T> grafo, boolean[] marca){
        
        ListaGenerica<Arista<T>> ady = null;
        ColaGenerica<Vertice<T>> q = new ColaGenerica<Vertice<T>>();

        q.encolar(grafo.listaDeVertices().elemento(i));

        marca[i] = true;

        while(!q.esVacia()){

            Vertice<T> v = q.desencolar();

            ady = grafo.listaDeAdyacentes(v);
            ady.comenzar();

            while(!ady.fin()){
                Arista<T> arista = ady.proximo();

                int j = arista.getVerticeDestino().getPosicion();

                if(!marca[j]){

                    Vertice<T> w = arista.getVerticeDestino();

                    marca[j] = true;
                    q.encolar(w);
                }

            }


        }
    }


    //Retorna la lista de componentes conexos como una lista de grafos, implementado con depth first search
    public ListaGenerica<Grafo<T>> ComponentesConexa(Grafo<T> grafo){

        //Arreglo de booleanos para registrar que vertices estan visitados
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];


        ListaEnlazadaGenerica<Grafo<T>> L = new ListaEnlazadaGenerica<Grafo<T>>();

        //recorre la lista de vertices
        for(int i = 0; i < grafo.listaDeVertices().tamanio(); i++){
            
            //Si este vertice no está visitado, llama al recorrido dfs con la pos del vertice, el grafo actual y el arreglo de booleanos
            if (!marca[i]){

                Grafo<T> CompCon = new GrafoImplListAdy<T>();

                ///Al finalizar este llamado recursivo, CompCon es un grafo con todos los elementos que se hayan alcanzado desde un vertice no visitado cualquiera i
                //Si aun quedan elementos sin visitar, significa que existen mas componentes conexas, eso se verifica en el if de arriba
                this.ComponentesConexa(i, grafo, marca, CompCon);


                //Agregar este sub-grafo a la lista de componentes conexos
                L.agregarInicio(CompCon);              

            }
        }
        
        return L;
    }


    //Encontrar los componentes conexos de un grafo, implementado con recorrido depth first search
    //Puede retornar los componentes conexos como una lista de grafos
    private void ComponentesConexa(int i,Grafo<T> G, boolean[] marca, Grafo<T> CompCon){
    
        
        //Marca como visitado el vertice actual
        marca[i] = true;


        //Salva el vertice actual
        Vertice<T> v = G.listaDeVertices().elemento(i);


        //Agrega el vertice al grafo componente conexo
        CompCon.agregarVertice(v);


        //Crea una arista en nulo para ir recuperando cada arista de la lista
        Arista<T> arista = null;
   
        //Iniciaiza la variable local j donde guardaremos la pos del proximo vertice a visitar
        int j = 0;


        //Guarda su lista de adyacentes en ady, es una lista de aristas
        ListaGenerica<Arista<T>> ady = G.listaDeAdyacentes(v);

        ady.comenzar();

        //Mientras haya adyacencias en este vertice
        while(!ady.fin()){

            //Recupero la prox arista de la lista
            arista = ady.proximo();



            //Consigo la posicion del vertice al que conecta en el grafo
            j = arista.getVerticeDestino().getPosicion();

            //Si tal posicion no está visitada, llamar recursivamente al recorrido dfs con la posicion de destino, el grafo y el arreglo de marcas
            if(!marca[j]){

                //Conectar el vertice actual v, con el vertice destino SOLO si esa posicion no fue visitada ¿no?
                CompCon.conectar(v, arista.getVerticeDestino());

                //Llamado recursivo
                this.ComponentesConexa(j, G, marca, CompCon);
            }
        }
        
    
    }



        /*//Para cada adyacencia de este vertice
        for(int k = 0; k < G.listaDeAdyacentes(v).tamanio(); k++){

            //Conectar el vertice actual v, con el vertice destino
            CompCon.conectar(v, G.listaDeAdyacentes(v).elemento(k).getVerticeDestino());

            


        }
    //Metodo privado recursivo que maneja el recorrido dfs
    private void dfss(int i, Grafo<T> grafo, boolean[] marca){

        //Marca como visitado el vertice actual
        marca[i] = true;

        //Crea una arista en nulo para ir recuperando cada arista de la lista
        Arista<T> arista = null;
   
        //Iniciaiza la variable local j donde guardaremos la pos del proximo vertice a visitar
        int j = 0;

        //toma el vertice correspondiente a tal posicion
        Vertice<T> v = grafo.listaDeVertices().elemento(i);

        System.out.println(v);

        //Guarda su lista de adyacentes en ady, es una lista de aristas
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);

        ady.comenzar();

        //Mientras no llega al fin
        while(!ady.fin()){

            //Recupero la prox arista de la lista
            arista = ady.proximo();

            //Consigo la posicion del vertice al que conecta en el grafo
            j = arista.getVerticeDestino().getPosicion();

            //Si tal posicion no está visitada, llamar recursivamente al recorrido dfs con la posicion de destino, el grafo y el arreglo de marcas
            if(!marca[j])
                this.dfs(j, grafo, marca);

        }

    }*/
    //Desafio: codificar el dfs con prueba de aciclidad, es distinto para grafos no dirigidos que grafos dirigidos


}
