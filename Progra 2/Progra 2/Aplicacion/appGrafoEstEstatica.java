package Aplicacion;
import Logica.GrafoEstEstatica;

public class appGrafoEstEstatica {
    
    public static void main(String[] args) {
        GrafoEstEstatica grafo1 = new GrafoEstEstatica();
        grafo1.InicializarGrafo();

        grafo1.AgregarVertice(1);
        grafo1.AgregarVertice(2);
        grafo1.AgregarVertice(3);
        grafo1.AgregarVertice(4);
        
        grafo1.AgregarArista(1, 2, 10);
        grafo1.AgregarArista(1, 3, 10);
        grafo1.AgregarArista(1, 4, 10);

        System.out.println(grafo1.ExisteArista(1,90));
    }
}
