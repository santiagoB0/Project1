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
                            amistades += grafo.getVertices()[i].getId() + "," + grafo.getVertices()[j].getId() + "," + grafo.getMatrizAd()[i][j] + "\n";
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

//    public Grafo leerText(String inpath) {
//        Grafo neGrafo = new Grafo();
//        String line;
//        String datos = "";
//        String path = inpath;
//        File file = new File(path);
//        try {
//            if (!file.exists()) {
//                file.createNewFile();
//            } else {
//                FileReader fr = new FileReader(file);
//                BufferedReader br = new BufferedReader(fr);
//                while ((line = br.readLine()) != null) {
//                    if (!line.isEmpty()) {
//                        datos += line + "\n";
//                    }
//                } if (!"".equals(datos)) {
//                    String[] textSplit =
//                }
//            }
//        } catch(Exception err) {
//
//        }
//    }
}
