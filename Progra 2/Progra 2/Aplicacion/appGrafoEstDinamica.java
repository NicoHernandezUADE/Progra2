package Aplicacion;

import Logica.GrafoEstDinamica;

public class appGrafoEstDinamica {
    
    public static void main(String[] args) {
        GrafoEstDinamica grafo1 = new GrafoEstDinamica();
        grafo1.InicializarGrafo();

        grafo1.AgregarVertice(1);
        grafo1.AgregarVertice(2);
        grafo1.AgregarVertice(3);
        grafo1.AgregarVertice(4);
        grafo1.AgregarVertice(5);
        grafo1.AgregarVertice(6);
        grafo1.AgregarVertice(7);

        grafo1.AgregarArista(1, 2, 1);
        grafo1.AgregarArista(1, 3, 1);
        grafo1.AgregarArista(1, 4, 1);
        grafo1.AgregarArista(1, 5, 1);
        grafo1.AgregarArista(1, 6, 1);
        grafo1.AgregarArista(1, 7, 1);
        grafo1.AgregarArista(2, 3, 1);
        grafo1.AgregarArista(2, 4, 1);
        grafo1.AgregarArista(2, 5, 1);
        grafo1.AgregarArista(2, 6, 1);
        grafo1.AgregarArista(2, 7, 1);
        grafo1.AgregarArista(3, 4, 1);
        grafo1.AgregarArista(3, 5, 1);
        grafo1.AgregarArista(3, 6, 1);
        grafo1.AgregarArista(3, 7, 1);
        grafo1.AgregarArista(4, 5, 1);
        grafo1.AgregarArista(4, 6, 1);
        grafo1.AgregarArista(4, 7, 1);
        grafo1.AgregarArista(5, 6, 1);
        grafo1.AgregarArista(5, 7, 1);
        grafo1.AgregarArista(6, 7, 1);
        

        System.out.println(grafo1.Vertices());
        grafo1.EliminarVertice(1);
        grafo1.EliminarVertice(2);
        grafo1.EliminarVertice(3);
        
        System.out.println(grafo1.Vertices());
        System.out.println(grafo1.ExisteArista(4, 6));
    }
}
