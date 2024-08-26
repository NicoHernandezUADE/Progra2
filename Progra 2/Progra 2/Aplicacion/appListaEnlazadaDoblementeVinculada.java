package Aplicacion;
import Logica.ListaEnlazadaDoblementeVinculada; 

public class appListaEnlazadaDoblementeVinculada {
    public static void main(String[] args) {
        ListaEnlazadaDoblementeVinculada lista1 = new ListaEnlazadaDoblementeVinculada();
        System.out.println(lista1.estaVacia());
        lista1.Agregar(20);
        lista1.pertenece(20);
        lista1.Agregar(30);
        System.out.println(lista1.toString());
        lista1.Agregar(360);
        lista1.Agregar(32330);
        System.out.println(lista1.estaVacia());
        lista1.largo();
        lista1.eliminar(20);
        System.out.println(lista1.toString());
    }
}
