package Proyecto1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Funciones {

    public void printText(Grafo grafo) {
        String usuarios = "";
        String amistades = "";
        boolean[][] arcosVisited = new boolean[grafo.getNumNodos()][grafo.getNumNodos()];
        for (int i = 0; i < grafo.getNumNodos(); i++) {
            for (int j = 0; j < grafo.getNumNodos(); j++) {
                arcosVisited[i][j] = false;
            }
        }
        if (!grafo.isEmpty()) {
            for (int i = 0; i < grafo.getNumNodos(); i++) {
                if (grafo.getVertices()[i] != null) {
                    usuarios += grafo.getVertices()[i].getId() + "," + grafo.getVertices()[i].getUsername() + "\n";
                    for (int j = 0; j < grafo.getNumNodos(); j++) {
                        if (grafo.getMatrizAd()[i][j] != 0 && grafo.getVertices()[j] != null && !arcosVisited[i][j]) {
                            amistades += grafo.getVertices()[i].getUsername() + "," + grafo.getVertices()[j].getUsername() + "," + grafo.getMatrizAd()[i][j] + "\n";
                            arcosVisited[i][j] = true;
                            arcosVisited[j][i] = true;
                        }
                    }
                }
            }
        }
        try {
            PrintWriter pwUsuarios = new PrintWriter("//Users//abricenop//IdeaProjects//Project1//src//Test//grafo.txt");
            pwUsuarios.print(usuarios);
            pwUsuarios.append(amistades);
            pwUsuarios.close();
            JOptionPane.showMessageDialog(null, "Escritura exitosa.");
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error.");
        }
    }

    public Grafo leerText(String inPath1) {
        Grafo newGrafo = new Grafo();
        String line1;
        String usuarios = "";
        File file1 = new File(inPath1);
        try {
            if (!file1.exists()) {
                file1.createNewFile();
            } else {
                FileReader fr1 = new FileReader(file1);
                BufferedReader br1 = new BufferedReader(fr1);
                while ((line1 = br1.readLine()) != null) {
                    if (!line1.isEmpty()) {
                        usuarios += line1 + "\n";
                    }
                } if (!"".equals(usuarios)) {
                    String[] usuariosSplit = usuarios.split("\n");
                    for (int i = 0; i < usuariosSplit.length; i++) {
                        String[] user = usuariosSplit[i].split(",");
                        if (user.length == 2) {
                            newGrafo.agregarVertice(Integer.parseInt(user[0]), user[1]);
                        } else {
                            newGrafo.agregarArco(newGrafo.findVertice(user[0]).getNumVertice(), newGrafo.findVertice(user[1]).getNumVertice(), Integer.parseInt(user[2]));
                        }
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Lectura exitosa.");
        } catch(Exception err) {
            JOptionPane.showMessageDialog(null, "Un error ocurrió.");
        }
        return newGrafo;
    }
}
