/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.mantenimientoclientes.combobox;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import modelo.mantenimientoclientes.Companias;

/**
 *
 * @author root
 */
public class comboboxCompania extends AbstractListModel implements ComboBoxModel{
    List<Companias> listaCompanias;
    Companias compania;

    public comboboxCompania(List<Companias> compania){
        this.listaCompanias = compania;
    }
    
    @Override
    public int getSize() {
        return listaCompanias.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listaCompanias.get(index).toString();
    }
    
    public void setSelectedItem(Object o){
        if (o != null && listaCompanias.size() > 0){
            for (Companias p : listaCompanias){
                if (p.toString().equals(o.toString())){
                    compania = p;
                    break;
                }
            }
        }
    }

    @Override
    public Object getSelectedItem() {
        return compania;
    }
}
