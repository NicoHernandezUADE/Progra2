package Aplicacion;
import Logica.Conjunto;
public class appConjunto {
    public static void main(String[] args) {
        Conjunto conj1 = new Conjunto();   
        System.out.println(conj1.estavacio());
        conj1.agregar(70);
        System.out.println(conj1.estavacio());
        System.out.println(conj1.pertenece(70));
        conj1.agregar(70);
        conj1.agregar(10);
        conj1.agregar(74);
        conj1.agregar(20);
        conj1.agregar(34);
        conj1.agregar(58);
        conj1.agregar(96);
        int val = conj1.elegir();
        System.out.println(val);
        System.out.println(conj1.toString());
        conj1.eliminar(8976);
        conj1.eliminar(34);
        System.out.println(conj1.toString());
        conj1.vaciar();
        System.out.println(conj1.largo());
    }
}
