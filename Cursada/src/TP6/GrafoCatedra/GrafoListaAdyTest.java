package TP6.GrafoCatedra;

import TP2.ListaGenerica;

//import TP6.GrafoCatedra.Recorridos;

public class GrafoListaAdyTest {



    public static void main(String[] args) {
        
        GrafoImplListAdy<Integer> grafo = new GrafoImplListAdy<Integer>();

		Recorridos<Integer> R = new Recorridos<Integer>();

		VerticeImplListAdy<Integer> vert1 = new VerticeImplListAdy<Integer>(1);
		VerticeImplListAdy<Integer> vert2 = new VerticeImplListAdy<Integer>(2);
		VerticeImplListAdy<Integer> vert3 = new VerticeImplListAdy<Integer>(3);
		VerticeImplListAdy<Integer> vert4 = new VerticeImplListAdy<Integer>(4);
		VerticeImplListAdy<Integer> vert5 = new VerticeImplListAdy<Integer>(5);

		grafo.agregarVertice(vert1);
		grafo.agregarVertice(vert2);
		grafo.agregarVertice(vert3);		
		grafo.agregarVertice(vert4);
		grafo.agregarVertice(vert5);

		grafo.conectar(vert1, vert2);
		grafo.conectar(vert1, vert3);
		grafo.conectar(vert2, vert1);
		grafo.conectar(vert2, vert3);
		grafo.conectar(vert3, vert1);
		grafo.conectar(vert3, vert2);

		//grafo.conectar(vert4, vert3);
		//grafo.conectar(vert3, vert4);

		//grafo.conectar(vert4, vert5);
		grafo.conectar(vert5, vert4);

		R.dfs(grafo);



		System.out.println("Tamaño de la lista de componentes fuertemente conexos del grafo: " + R.ComponentesFuertementeConexos(grafo).tamanio());

		ListaGenerica<Vertice<Integer>> L = R.dfsReturnLista(grafo);
		
		L.comenzar();

		while(!L.fin()){System.out.println("wot:" + L.proximo().getDato());}

    }



}