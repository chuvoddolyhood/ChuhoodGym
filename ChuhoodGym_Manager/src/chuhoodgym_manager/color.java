/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chuhoodgym_manager;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Tran Nhan Nghia
 */
public class color {
    public void setColor(JPanel panel){
        panel.setBackground(new Color(51,55,80));
    }
    
    public void resetColor(JPanel panel){
        panel.setBackground(new Color(21,25,28));
    }
    
    public void setColorPanel(JPanel panel){
        panel.setBackground(new Color(51,55,80));
    }
    
    public void resetColorPanel(JPanel panel){
        panel.setBackground(new Color(44,52,58));
    }
}
