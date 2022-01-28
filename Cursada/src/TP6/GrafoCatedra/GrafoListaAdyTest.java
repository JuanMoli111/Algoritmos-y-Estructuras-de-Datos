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

		grafo.agregarVertice(vert1);
		grafo.agregarVertice(vert2);
		grafo.agregarVertice(vert3);
		grafo.conectar(vert1, vert2);
		grafo.conectar(vert1, vert3);
		grafo.conectar(vert2, vert1);
		grafo.conectar(vert2, vert3);
		grafo.conectar(vert3, vert1);
		grafo.conectar(vert3, vert2);


		R.dfs(grafo);



		System.out.println("Tamaño de la lista de componentes conexos del grafo: " + R.ComponentesConexa(grafo).tamanio());

		ListaGenerica<Vertice<Integer>> L = R.dfsReturnLista(grafo);
		
		L.comenzar();

		while(!L.fin()){System.out.println("wot:" + L.proximo().getDato());}

    }








}