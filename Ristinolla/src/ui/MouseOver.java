
package ui;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/**
 * 
 * @author      Paavo Rohamo
 */
public class MouseOver extends JButton implements MouseListener {

    private Color defaultColor;
    private Color mouseOverColor;
    
    public MouseOver(Color defaultColor, Color mouseover) {
        setBackground(defaultColor);
        this.defaultColor = defaultColor;
        this.mouseOverColor = mouseover;
        addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if (e.getSource() == this) {
            this.setBackground(this.mouseOverColor);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

        if (e.getSource() == this) {
            this.setBackground(this.defaultColor);
        }

    }
}
