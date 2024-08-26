package Aplicacion;
import Logica.Pila;

public class appPila {
    public static void main(String[] args) {
        Pila pila1 = new Pila();
        System.out.println(pila1.PilaVacia());
        pila1.Apilar(10);
        pila1.Apilar(50);
        pila1.Apilar(40);
        System.out.println(pila1.Largo());
        pila1.Apilar(20);
        System.out.println(pila1.toString());
        System.out.println(pila1.PilaVacia());
        pila1.Desapilar();
        System.out.println(pila1.toString());
        pila1.Vaciar();
        System.out.println(pila1.PilaVacia());
    }
}
