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
            PrintWriter pwAmistades = new PrintWriter("//Users//abricenop//IdeaProjects//Project1//src//Test//amistades.txt");
            pwUsuarios.print(usuarios);
            pwAmistades.print(amistades);
            pwAmistades.close();
            pwUsuarios.close();
            JOptionPane.showMessageDialog(null, "Escritura exitosa.");
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error.");
        }
    }

    public Grafo leerText(String inPath1, String inPath2) {
        Grafo newGrafo = new Grafo();
        String line1;
        String line2;
        String usuarios = "";
        String amistades = "";
        File file1 = new File(inPath1);
        File file2 = new File(inPath2);
        try {
            if (!file1.exists() || !file2.exists()) {
                file1.createNewFile();
                file2.createNewFile();
            } else {
                FileReader fr1 = new FileReader(file1);
                BufferedReader br1 = new BufferedReader(fr1);
                FileReader fr2 = new FileReader(file2);
                BufferedReader br2 = new BufferedReader(fr2);
                while ((line1 = br1.readLine()) != null) {
                    if (!line1.isEmpty()) {
                        usuarios += line1 + "\n";
                    }
                    while ((line2 = br2.readLine()) != null) {
                        amistades += line2 + "\n";
                    }
                } if (!"".equals(usuarios)) {
                    String[] usuariosSplit = usuarios.split("\n");
                    for (int i = 0; i < usuariosSplit.length; i++) {
                        String[] user = usuariosSplit[i].split(",");
                        newGrafo.agregarVertice(Integer.parseInt(user[0]), user[1]);
                    }
                } if (!"".equals(amistades)) {
                    String[] amistadesSplit = amistades.split("\n");
                    for (int i = 0; i < amistadesSplit.length; i++) {
                        String[] arco = amistadesSplit[i].split(",");
                        newGrafo.agregarArco(newGrafo.findVertice(arco[0]).getNumVertice(), newGrafo.findVertice(arco[1]).getNumVertice(), Integer.parseInt(arco[2]));
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
