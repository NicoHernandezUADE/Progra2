package GuiaEjs;

import Logica.Conjunto;
import Logica.ListaEnlazada.Nodo;
import Logica.*;

public class EjerciciosConjunto {
    
    // ej 3.1.1
    public static Conjunto diferenciaSimetrica(Conjunto conj1, Conjunto conj2){
        Conjunto res = new Conjunto();
        while (!conj1.estavacio()) {
            int val = conj1.elegir();
            if ((conj1.pertenece(val) && !conj2.pertenece(val))) {
                res.agregar(val);
            }
            conj1.eliminar(val);
        }

        while (!conj2.estavacio()) {
            int val = conj2.elegir();
            if (!res.pertenece(val)) {
                res.agregar(val);
            }
            conj2.eliminar(val);
        }

        return res;
    }

    // ej 3.2
    public static boolean SonIguales(Conjunto c1, Conjunto c2){
        if (c1.largo != c2.largo) {
            return false;
        }
        while (!c1.estavacio()) {
            int val = c1.elegir();
            if (!c2.pertenece(val)) {
                return false;
            }
            c1.eliminar(val);
        }
        return true;      
    }

    //ej 3.3
    public static int CardinalidadConj(Conjunto c){
        int res = 0;
        while (!c.estavacio()) {
            res++;
            c.eliminar(c.elegir());
        }
        return res;
    }

    //ej 3.4
    public static Conjunto SumarPilaYCola(Pila p1, ListaEnlazada l1){
        Conjunto res = new Conjunto();
        while (!p1.PilaVacia()) {
            res.agregar(p1.Tope());
            p1.Desapilar();
        }
        Nodo movil = l1.primero;
        while(movil != null){
            res.agregar(movil.contenido);
            movil = movil.siguiente;
        }
        return res;
    }

    //ej 3.5
    public static boolean TienenPyCMismosElementos(Pila p1, ListaEnlazada c1){
        Conjunto conj1 = new Conjunto();
        while (!p1.PilaVacia()) {
            conj1.agregar(p1.Tope());
            p1.Desapilar();
        }
        Nodo movil = c1.primero;
        while (movil != null) {
            if (!conj1.pertenece(movil.contenido)) {
                return false;
            }
            movil = movil.siguiente;
        }
        return true;
    }
    public static void main(String[] args) {
        //test ej 3.1.1
        Conjunto c1 = new Conjunto();
        c1.agregar(1);
        c1.agregar(2);
        c1.agregar(3);
        c1.agregar(90);
        Conjunto c2 = new Conjunto();
        c2.agregar(3);
        c2.agregar(4);
        c2.agregar(5);
        Conjunto res = diferenciaSimetrica(c1, c2);
        System.out.println("Dif simetrica conj1" + res.toString());

        //test ej 3.2
        Conjunto c3 = new Conjunto();
        c3.agregar(1);
        c3.agregar(2);
        c3.agregar(3);
        Conjunto c4 = new Conjunto();
        c4.agregar(1);
        c4.agregar(2);
        c4.agregar(343);

        System.out.println("Son iguales? " + SonIguales(c3, c4));
        //test ej 3.3
        Conjunto c5 = new Conjunto();
        c5.agregar(1);
        c5.agregar(2);
        c5.agregar(3);
        System.out.println("Cardinalidad: " + CardinalidadConj(c5));

        //test ej 3.4
        Pila pila1 = new Pila();
        pila1.Apilar(1);
        pila1.Apilar(2);
        pila1.Apilar(3);
        ListaEnlazada cola1 = new ListaEnlazada();
        cola1.Agregar(4);
        cola1.Agregar(5);
        cola1.Agregar(1);

        Conjunto res2 = SumarPilaYCola(pila1, cola1);
        System.out.println("Pila y cola sumadas: " + res2.toString());

        //test ej 3.5
        Pila pila2 = new Pila();
        pila2.Apilar(1);
        pila2.Apilar(2);
        pila2.Apilar(3);
        ListaEnlazada cola2 = new ListaEnlazada();
        cola2.Agregar(1);
        cola2.Agregar(2);
        cola2.Agregar(3);
        cola2.Agregar(1);
        System.out.println("Cola 2: " + cola2.toString());
        System.out.println("Tienen mismos elementos? " + TienenPyCMismosElementos(pila2, cola2)); //expected true
        cola2.Agregar(7);
        System.out.println("Tienen mismos elementos? " + TienenPyCMismosElementos(pila2, cola2)); //expected false
    }
}
