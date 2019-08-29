/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.MantemientoClientes;

import controlador.mantenimientoclientes.dao.companiaDao;
import controlador.mantenimientoclientes.mapeos.HibernateUtil;
import de.javasoft.plaf.synthetica.SyntheticaBlueMoonLookAndFeel;
import static java.awt.image.ImageObserver.ERROR;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author root
 */
public class mantemientoClientes extends javax.swing.JFrame {

    companiaDao companiadao;
    Session sesion;
    private Transaction tx;

    public mantemientoClientes() {
        initComponents();
        this.setTitle("Mantenimiento de Clientes");
        this.cbxCompania.removeAllItems();
        updateCombobox();
        actualizaTabla();
    }

    public void llenaJComboBoxPais() {
       // List<Companias> c = companiadao.listadoCompanias();
       // cbxCompania.setModel(new comboboxCompania(c));
    }

    public void updateCombobox() {
        AutoCompleteDecorator.decorate(cbxCompania);
    }

    public void actualizaTabla() {
        //this.iniciarOperacion();
        try {

            //List<Clientes> lst;
            //lst = companiadao.listadoCompanias();

            //tblClientes.setModel(new tablaClientes(lst));
            tamañoCeldas();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

        public void tamañoCeldas() {

        TableColumn columna0 = tblClientes.getColumn("ID");
        columna0.setPreferredWidth(60);
        columna0.setMinWidth(40);
        columna0.setMaxWidth(500);
        TableColumn columna1 = tblClientes.getColumn("Clientes");
        columna1.setPreferredWidth(180);
        columna1.setMinWidth(100);
        columna1.setMaxWidth(300);
        TableColumn columna2 = tblClientes.getColumn("Cedula");
        columna2.setPreferredWidth(130);
        columna2.setMinWidth(100);
        columna2.setMaxWidth(500);

    }
        
    public void iniciarOperacion() throws HibernateException {

        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    public void manejaException(HibernateException he) throws HibernateException {

        tx.rollback();
        throw new HibernateException("Ocurrio un error en la capa de acceso a datos. ", he);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cbxCompania = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(720, 550));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.add(cbxCompania, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 360, -1));

        jLabel1.setText("Compañia");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 700, 70));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Clientes"));
        jPanel3.setLayout(new java.awt.BorderLayout());

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblClientes);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 380, 380));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Prestamos"));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setViewportView(jList1);

        jPanel4.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 120, 380));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Eliminar");
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 125, 110, -1));

        jButton2.setText("Transferir");
        jButton2.setToolTipText("");
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 110, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 130, 380));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new SyntheticaBlueMoonLookAndFeel());

                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(mantemientoClientes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(mantemientoClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
                new mantemientoClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxCompania;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables
}
