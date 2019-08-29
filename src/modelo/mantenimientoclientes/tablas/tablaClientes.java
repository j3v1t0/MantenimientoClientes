/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.mantenimientoclientes.tablas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.mantenimientoclientes.Clientes;

/**
 *
 * @author root
 */
public class tablaClientes extends AbstractTableModel {

    String[] columnas = {"ID", "Cliente","Cedula"};
    private List<Clientes> cliente = new ArrayList();

    public tablaClientes(List<Clientes> cliente) {
        this.cliente = cliente;
    }

    @Override
    public int getRowCount() {
        return cliente.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    public void inicializarCuenta() {
        cliente = new ArrayList();
        fireTableDataChanged();
    }

    public Clientes dameCuenta(int fila) {
        return this.cliente.get(fila);
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Object resultado = null;
        if (columna == 0) {
           // resultado = cliente.get(fila).getIdpais();
        } else {
            if (columna == 1) {
               // resultado = cliente.get(fila).getPais();
            }
        }
        return resultado;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}
