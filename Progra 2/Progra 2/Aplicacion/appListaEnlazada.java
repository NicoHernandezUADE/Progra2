package Aplicacion;
import Logica.ListaEnlazada;

public class appListaEnlazada {
    public static void main(String[] args) {
        ListaEnlazada l1 = new ListaEnlazada();
        System.out.println(l1.estaVacia());
        l1.Agregar(10);
        System.out.println(l1.primero.contenido);
        l1.Agregar(20);
        l1.Agregar(30);
        System.out.println("el largo es " + l1.largo());
        System.out.println("pertenece el 20: " + l1.pertenece(20));
        System.out.println("pertenece el 50: " + l1.pertenece(50));
        l1.Agregar(40);
        l1.Agregar(10);
        System.out.println(l1.toString());
        l1.eliminar(10);
        System.out.println(l1.estaVacia());
        System.out.println(l1.toString());
        System.out.println(l1.primero.contenido);
        System.out.println(l1.toString());
        System.out.println(l1.estaVacia());
        l1.insertarEnPosicion(1904, 2);
        System.out.println(l1.toString());
        l1.Agregar(20);
        l1.Agregar(20);
        l1.Agregar(20);
        System.out.println(l1.toString());
        l1.EliminarTodasLasOcurrencias(20);
        System.out.println(l1.toString());
    }
}
