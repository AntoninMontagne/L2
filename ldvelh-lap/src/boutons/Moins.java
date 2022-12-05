package boutons;

import principal.*;
import noeud.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

/*Le bouton "moins" sert à supprimer un choix d'une section
  Il prend en paramètre le model de la liste des choix, la liste des choix, la map des choix du noeud, le dictionnaire des sections, un noeud*/

public class Moins extends JButton{

  protected DefaultListModel modelListeChoix;
  protected JList<String> listeChoix;
  protected HashMap<String,String> mapNoeud;
  protected HashMap<String, HashMap<String, String>> dicoSections;
  protected Noeud unNoeud;

  public Moins(DefaultListModel model, HashMap<String,String> mapNoeud, HashMap<String, HashMap<String, String>> dicoSections, Noeud unNoeud,  JList<String> listSections2){
    this.setText("moins");
    this.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e) {
        //On récupère le choix à supprimer
        String removeChoice = listSections2.getSelectedValue();
        String removeFromMap = "";
        //On enlève le choix du model
        model.remove(listSections2.getSelectedIndex());
        for(String str: mapNoeud.keySet()){
          if(mapNoeud.get(str).equals(removeChoice)){
            removeFromMap = str;
          }
        }
        //On enlève le choix de la map des choix du noeud
        mapNoeud.remove(removeFromMap);
        //On met à jour le dictionnaire des sections
        dicoSections.put("Sections " + unNoeud.getNumber(), mapNoeud);
      }
    });
  }
}
