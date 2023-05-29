package Proyecto1;

public class Main {
    public static void main(String[] strings) {
        Grafo grafoPrueba = new Grafo();
        grafoPrueba.agregarVertice(1, "a");
        grafoPrueba.agregarVertice(2, "b");
        grafoPrueba.agregarVertice(3, "c");
        grafoPrueba.agregarVertice(4, "d");
        grafoPrueba.agregarVertice(5, "e");
        grafoPrueba.agregarVertice(6, "f");
        grafoPrueba.agregarVertice(7, "g");
        grafoPrueba.agregarArco(0, 2, 1);
        grafoPrueba.agregarArco(2, 1, 2);
        grafoPrueba.agregarArco(1, 3, 3);
        grafoPrueba.agregarArco(1, 4, 3);
        grafoPrueba.agregarArco(1, 5, 4);
        grafoPrueba.eliminarVertice(grafoPrueba.getVertices()[1]);
        grafoPrueba.agregarArco(0, 6, 4);
        grafoPrueba.agregarArco(5, 6, 4);
        grafoPrueba.agregarArco(0, 1, 4);
//        int cantidad = grafoPrueba.recursiveDFS(1, 1);
        int cantidadIslas = grafoPrueba.numIslas();
//        int bfs = grafoPrueba.BFS(grafoPrueba.getVertices()[0]);
        int islas = grafoPrueba.numIslasBFS();
//        System.out.println(cantidad);
//        System.out.println(cantidadIslas);
//        int numIslas = grafoPrueba.numIslas();
//        System.out.println("Cantidad Vertices " + bfs);
        System.out.println("Islas " + cantidadIslas);
//        System.out.println(grafoPrueba.esPuente(5, 6));
//        grafoPrueba.agregarVertice(101, "santiago");
//        grafoPrueba.agregarVertice(102, "Casamentera");
//        grafoPrueba.agregarVertice(103, "Nublado");
////        System.out.println(grafoPrueba.getVertices()[2].getId());
////        for (int i=0; i<grafoPrueba.getNumNodos(); i++) {
////            System.out.println(grafoPrueba.getVertices()[i].getId());
////        }
//        grafoPrueba.eliminarVertice(grafoPrueba.getVertices()[0]);
////        System.out.println(grafoPrueba.getVertices()[2].getId());
//        grafoPrueba.agregarVertice(104, "Carmela");
//        grafoPrueba.agregarVertice(105, "Carmela");
//        grafoPrueba.agregarVertice(106, "Carmela");
//        grafoPrueba.agregarVertice(107, "Carmela");
//        grafoPrueba.agregarVertice(108, "armela");
//
//        grafoPrueba.agregarVertice(109, "armela");
//        grafoPrueba.agregarArco(0, 2, 7);
//        grafoPrueba.agregarArco(0, 1, 9);
//        grafoPrueba.eliminarVertice(grafoPrueba.getVertices()[5]);
//        grafoPrueba.agregarArco(0, 3, 7);
//        grafoPrueba.agregarArco(3, 4, 7);
//        System.out.println(grafoPrueba.getVertices()[grafoPrueba.getNumNodos()].getId());
//        System.out.println(grafoPrueba.getNumNodos());
//        grafoPrueba.agregarArco(0, 5, 7);
//        for (int i=0; i<grafoPrueba.getNumNodos(); i++) {
//            System.out.println(grafoPrueba.getVertices()[i].getId());
//        }
//        int verticesIsla = grafoPrueba.recursiveDFS(0, 1);
//        System.out.println(verticesIsla);
//        System.out.println(grafoPrueba.getMatrizAd()[0][5]);
//        System.out.println(grafoPrueba.getMatrizAd()[1][0]);
//        System.out.println(grafoPrueba.getVertices()[2].getId());
//        System.out.println(grafoPrueba.getNumNodos());
    }
}
