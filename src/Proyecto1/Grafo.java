package Proyecto1;

public class Grafo {
    private int[][] MatrizAd;
    private int numNodos;
    private Vertice[] vertices;
    private boolean[] visited;
    private boolean[][] puentes;

    private int numNodosActivos;

    //Constructor
    public Grafo() {
        this.numNodos = 0;
        MatrizAd= new int[1][1];
        visited = new boolean[1];
        vertices = new Vertice[1];
        puentes = new boolean[1][1];
        numNodosActivos = 0;
    }

    // setters, Getters
    public Vertice[] getVertices() {
        return vertices;
    }

    public int[][] getMatrizAd() {
        return MatrizAd;
    }

    public int getNumNodos() {
        return numNodos;
    }

    public boolean[] getVisited() {
        return visited;
    }

    public void setVertices(Vertice[] vertices) {
        this.vertices = vertices;
    }

    public void setMatrizAd(int[][] matrizAd) {
        MatrizAd = matrizAd;
    }

    public void setNumNodos(int numNodos) {
        this.numNodos = numNodos;
    }

    public void setVisited(boolean[] visited) {
        this.visited = visited;
    }

    //Metodos
    public boolean isEmpty() {
        return vertices[0] == null;
    }
    public int searchSpace() {
        for (int i = 0; i < numNodos; i++) {
            if (vertices[i] == null) {
                return i;
            }
        } return -1;
    }

    public void agregarVertice(int id, String userName) {
        Vertice newVertice = new Vertice(id, userName);
        if (isEmpty()) {
            vertices[0] = newVertice;
            newVertice.setNumVertice(0);
            getMatrizAd()[0][0] = 0;
            visited[0] = false;
            numNodosActivos ++;
            numNodos++;
        } else {
            if (findVertice(userName) == null) {
                int space = searchSpace();
                if (space != -1) {
                    vertices[space] = newVertice;
                    newVertice.setNumVertice(space);
                    numNodosActivos++;
                } else {
                    Vertice[] newVertices = new Vertice[numNodos + 1];
                    int[][] newMatrizAdy = new int[numNodos + 1][numNodos + 1];
                    for (int i = 0; i < numNodos; i++) {
                        newVertices[i] = vertices[i];
                        for (int j = 0; j < numNodos; j++) {
                            newMatrizAdy[i][j] = getMatrizAd()[i][j];
                            newMatrizAdy[j][i] = getMatrizAd()[j][i];
                        }
                    }
                    for (int j = 0; j < numNodos; j++) {
                        newMatrizAdy[numNodos][j] = 0;
                        newMatrizAdy[j][numNodos] = 0;
                    }
                    newVertices[numNodos] = newVertice;
                    newVertice.setNumVertice(numNodos);
                    setMatrizAd(newMatrizAdy);
                    setVertices(newVertices);
                    setVisited(new boolean[numNodos + 1]);
                    visited[numNodos] = false;
                    puentes = new boolean[numNodos + 1][numNodos + 1];
                    numNodos++;
                    numNodosActivos++;
                }
            } else {
                System.out.println("Este nombre de usuario ya está registrado");
            }
        }
    }

    public void eliminarVertice(Vertice vertice) {
        if (isEmpty()) {
            System.out.println("No hay ningún usuario en la red.");
        } else {
            int numVertice = vertice.getNumVertice();
            getVertices()[numVertice] = null;
            for (int i = 0; i < numNodos; i++) {
                getMatrizAd()[numVertice][i] = 0;
                getMatrizAd()[i][numVertice] = 0;
            } numNodosActivos--;

        }
    }

    public void agregarArco(int n1,int n2, int peso){
        if (n2 < numNodos && n1 < numNodos) {
            if (getVertices()[n1] != null && getVertices()[n2] != null && n1 != n2) {
                MatrizAd[n1][n2] = peso;
                MatrizAd[n2][n1] = peso;
            }
        }
    }

    public void eliminarArco(int n1,int n2){
        MatrizAd[n1][n2] = 0;
        MatrizAd[n2][n1] = 0;
    }

    public boolean Arco(int n1, int n2){
        return MatrizAd[n1][n2] != 0;
    }

    public int recursiveDFS(int numVertice, int cantidadVertices) {
        System.out.println(vertices[numVertice].getId());
        visited[numVertice] = true;
        for (int i = 0; i < numNodos; i++) {
            if (getMatrizAd()[numVertice][i] != 0 && !visited[i]) {
                cantidadVertices = recursiveDFS(i, cantidadVertices + 1);
            }
        } return cantidadVertices;

    }

    public int BFS(Vertice startingVertice) {
        int contador = 0;
        Queue queue = new Queue();
        queue.enqueue(startingVertice);
        visited[startingVertice.getNumVertice()] = true;
        while (queue.getHead() != null) {
            visited[queue.getHead().getElement().getNumVertice()] = true;
            System.out.println(queue.getHead().getElement().getId());
            for (int j = 0; j < numNodos; j++) {
                if (MatrizAd[queue.getHead().getElement().getNumVertice()][j] != 0 && !visited[j]) {
                    queue.enqueue(vertices[j]);
                    visited[j] = true;
                }
            } contador++;
            queue.dispatch();
        }
        return contador;
    }

    public int numIslasBFS() {
        for (int i = 0; i < numNodos; i++){
            visited[i] = false;
        }
        int contador = 0;
        while (!todosVisitados()) {
            int i = notVisited();
            if (vertices[i] != null) {
                BFS(vertices[i]);
                contador++;
            } else {
                visited[i] = true;
            }
        }
        return contador;
    }

    public boolean todosVisitados() {
        int contador = 0;
        for (int i = 0; i < numNodos; i++) {
            if (getVisited()[i]) {
                contador++;
            }
        } return contador == numNodos;
    }

    public int notVisited() {
        int i = 0;
        while (getVisited()[i] && i < numNodos) {
            i++;
        } if (getVisited()[i]) {
            return -1;
        } else {
            return i;
        }
    }

    public int numIslas() {
        for (int i = 0; i < numNodos; i++) {
            visited[i] = false;
        }
        int contador = 0;
        while (!todosVisitados()) {
            int i = notVisited();
            if (vertices[i] != null) {
                recursiveDFS(i, 1);
                contador++;
            } else {
                visited[i] = true;
            }
        }
        return contador;
    }

    public boolean esPuente(int numVertice1, int numVertice2) {

        if (Arco(numVertice1, numVertice2)) {
            int peso = getMatrizAd()[numVertice1][numVertice2];
            int antes = numIslas();
            System.out.println(antes);
            eliminarArco(numVertice1, numVertice2);
            int despues = numIslas();
            System.out.println(despues);
            agregarArco(numVertice1, numVertice2, peso);
            System.out.println(antes + " " + despues);
            if (antes < despues) {
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("Estos usuarios no son amigos.");
            return false;
        }
    }

    public Vertice findVertice(String username) {
        for (int i = 0; i < numNodos; i++) {
            if (vertices[i] != null) {
                if (vertices[i].getUsername().equals(username)) {
                    return vertices[i];
                }
            }
        }
        return null;
    }
}
