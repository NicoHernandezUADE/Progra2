package Aplicacion;
import Logica.ArbolBinario;
import Logica.ListaEnlazada;
public class appArbol{

    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.agregar(8);
        arbol.agregar(5);
        arbol.agregar(7);
        arbol.agregar(2);
        arbol.agregar(3);
        arbol.agregar(8);
        arbol.agregar(5);
        arbol.agregar(9);
        arbol.agregar(10);
        arbol.inOrder(arbol);

        ListaEnlazada hojas =arbol.almacenarHojas();
        System.out.println(hojas);
    }
}