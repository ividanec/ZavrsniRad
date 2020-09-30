/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.vidanec.zavrsnirad.view;

import hr.vidanec.zavrsnirad.model.Knjiga;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Ivan
 */
public class KnjigaCellRenderer extends JLabel implements ListCellRenderer<Knjiga>{

    @Override
    public Component getListCellRendererComponent(JList<? extends Knjiga> list, Knjiga value, int index, boolean isSelected, boolean cellHasFocus) {
        setText(value.getNaziv());
        if (isSelected) {
            setBackground(Color.BLUE);
            setForeground(Color.RED);
        } else {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }
        return this;
    }
    
}
