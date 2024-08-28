package material_profe;

public class Test {

    public static void main(String[] args) {
        ArbolB arbol = new ArbolB();

        arbol.Agregar(6);
        arbol.Agregar(2);
        arbol.Agregar(8);
        arbol.Agregar(1);
        arbol.Agregar(5);
        arbol.Agregar(9);

        System.out.println(arbol);
        System.out.println("----------------------------");
        
        arbol.Agregar(7);

        System.out.println(arbol);
        System.out.println("----------------------------");

        arbol.Eliminar(2);
        System.out.println(arbol);
        System.out.println("----------------------------");

        arbol.Eliminar(6);
        System.out.println(arbol);
        System.out.println("----------------------------");
    }

}
