package com.gui.main;
import com.gui.panels.*;

import javax.swing.*;
import java.util.HashMap;

public class Renderers {

    private static HashMap< String,JPanel > panelMap;
    public Renderers(){
        panelMap = new HashMap<>();
    }
    public static void addPanels(String panelName,JPanel panel){
        panelMap.put(panelName,panel);
    }

    public static JPanel getPanels(String panelName){
        return panelMap.get(panelName);
    }

    public static void renderIn(String panelName){
        panelMap.get(panelName).setVisible(true);
    }

    public static void renderOut(String panelName){
        panelMap.get(panelName).setVisible(false);
    }
}
