package com.eventListeners;

import javax.swing.*;
import java.util.HashMap;

public class RenderOps {
    private static HashMap<String, JButton> buttonMap;
    public RenderOps(){
        buttonMap = new HashMap<>();
    }

    public static void addButtons(String buttonName, JButton button){
        buttonMap.put(buttonName,button);
    }


}
