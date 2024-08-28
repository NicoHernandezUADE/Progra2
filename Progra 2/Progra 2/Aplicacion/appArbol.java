package Aplicacion;
import Logica.ArbolBinario;
public class appArbol{

    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.agregar(8);
        arbol.agregar(3);
        arbol.agregar(15);
        System.out.println(arbol.estaVacio());
        System.out.println(arbol.raiz());
        arbol.inOrder(arbol);
    }
}