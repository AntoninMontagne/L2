package principal;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import javax.swing.*;
import java.lang.Process;

//Classe qui sert à afficher le graphe de l'histoire chargée, après avoir fermé la fenêtre du jeu
//Classe qui sert également à supprimer le fichier output.dot qui sert à charger le graphe en output.jpg

public class LaunchGraph {

  public static void main(String[] args) {

      JSONParser parser = new JSONParser();

      try (Reader reader = new FileReader("./files/fotw.json")) {

        Runtime rt = Runtime.getRuntime();
        //On supprime le fichier output.dot
        Process prRmDot = rt.exec("rm output.dot");
        //On regarde le systeme d'exploitation de l'ordinateur du joueur et la commande (pour ouvrir le graphe output.jpg) est différente en fonction du système trouvé.
        if(System.getProperty("os.name").equals("Mac OS X")){
          Process prOpenGraphMac = rt.exec("open output.jpg");
        }
        else{
          Process prOpenGraphLinux = rt.exec("xdg-open output.jpg");
        }
    }

    catch (Exception e) {
        e.printStackTrace();
    }
  }
}
