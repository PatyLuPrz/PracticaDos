/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import models.ModelAddresses;
import views.ViewAddresses;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author PatyLu_Prz
 */
public class ControllerAddresses {

    public ModelAddresses modelAddresses;
    public ViewAddresses viewAddresses;

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewAddresses.jbtn_primero) {
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewAddresses.jbtn_anterior) {
                jbtn_anterior_actionPerformed();
            } else if (e.getSource() == viewAddresses.jbtn_siguiente) {
                jbtn_siguiente_actionPerformed();
            } else if (e.getSource() == viewAddresses.jbtn_ultimo) {
                jbtn_ultimo_actionPerformed();
            } else if (e.getSource() == viewAddresses.jbtn_nuevo){
                jbtn_nuevo_actionPerformed();
            } else if (e.getSource() == viewAddresses.jbtn_insertar){
                jbtn_insertar_actionPerformed();
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewAddresses.jbtn_modificar){
                jbtn_modificar_actionPerformed();
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewAddresses.jbtn_eliminar){
                jbtn_eliminar_actionPerformed();
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewAddresses.jbtn_cancelar){
                jbtn_cancelar_actionPerformed();
            } else if (e.getSource() == viewAddresses.jbtn_editar){
                jbtn_editar_actionPerformed();
            }
        }
    };
    
    public ControllerAddresses(ModelAddresses modelAddresses, ViewAddresses viewAddresses){
        this.modelAddresses = modelAddresses;
        this.viewAddresses = viewAddresses;
        setActionListener();
        initDB();
    }
    
    void initView() {
       viewAddresses.setVisible(true);
    }

    private void setActionListener() {
        viewAddresses.jbtn_primero.addActionListener(actionListener);
        viewAddresses.jbtn_anterior.addActionListener(actionListener);
        viewAddresses.jbtn_siguiente.addActionListener(actionListener);
        viewAddresses.jbtn_ultimo.addActionListener(actionListener);
        viewAddresses.jbtn_nuevo.addActionListener(actionListener);
        viewAddresses.jbtn_insertar.addActionListener(actionListener);
        viewAddresses.jbtn_modificar.addActionListener(actionListener);
        viewAddresses.jbtn_eliminar.addActionListener(actionListener);
        viewAddresses.jbtn_cancelar.addActionListener(actionListener);
        viewAddresses.jbtn_editar.addActionListener(actionListener);
    }

    private void initDB() {
        modelAddresses.conectarBD();
        viewAddresses.jtf_id.setText(modelAddresses.getId_distribuidor());
        viewAddresses.jtf_calle.setText(modelAddresses.getCalle());
        viewAddresses.jtf_colonia.setText(modelAddresses.getColonia());
        viewAddresses.jtf_numerocasa.setText(modelAddresses.getNumero_casa());
        
    }
    
    private void jbtn_primero_actionPerformed() {
        modelAddresses.setFirst();
        setValues();
    }

    private void jbtn_anterior_actionPerformed() {
        modelAddresses.setLast();
        setValues();
    }

    private void jbtn_siguiente_actionPerformed() {
        modelAddresses.setNext();
        setValues();
    }

    private void jbtn_ultimo_actionPerformed() {
        modelAddresses.setLast();
        setValues();
    }

    
    private void setValues(){
        viewAddresses.jtf_id.setText(modelAddresses.getId_distribuidor());
        viewAddresses.jtf_calle.setText(modelAddresses.getCalle());
        viewAddresses.jtf_colonia.setText(modelAddresses.getColonia());
        viewAddresses.jtf_numerocasa.setText(modelAddresses.getNumero_casa());
    }
    
    private void jbtn_nuevo_actionPerformed() {
        viewAddresses.jtf_id.setEditable(true);
        viewAddresses.jtf_calle.setEditable(true);
        viewAddresses.jtf_colonia.setEditable(true);
        viewAddresses.jtf_numerocasa.setEditable(true);
        viewAddresses.jbtn_anterior.setEnabled(false);
        viewAddresses.jbtn_siguiente.setEnabled(false);
        viewAddresses.jbtn_primero.setEnabled(false);
        viewAddresses.jbtn_ultimo.setEnabled(false);
        viewAddresses.jbtn_modificar.setEnabled(false);
        viewAddresses.jbtn_eliminar.setEnabled(false);
        viewAddresses.jbtn_nuevo.setEnabled(false);
        viewAddresses.jbtn_cancelar.setEnabled(true);
        viewAddresses.jbtn_insertar.setEnabled(true);
        viewAddresses.jtf_id.setText(null);
        viewAddresses.jtf_calle.setText(null);
        viewAddresses.jtf_colonia.setText(null);
        viewAddresses.jtf_numerocasa.setText(null);
        viewAddresses.jbtn_editar.setEnabled(false);
    }

    private void jbtn_insertar_actionPerformed() {
        modelAddresses.setId_distribuidor(viewAddresses.jtf_id.getText());
        modelAddresses.setCalle(viewAddresses.jtf_calle.getText());
        modelAddresses.setColonia(viewAddresses.jtf_colonia.getText());
        modelAddresses.setNumero_casa(viewAddresses.jtf_numerocasa.getText());
        modelAddresses.insert(
                modelAddresses.getId_distribuidor(),
                modelAddresses.getCalle(),
                modelAddresses.getNumero_casa(),
                modelAddresses.getColonia()
                );
        JOptionPane.showMessageDialog(null,"Registro añadido con exito");
        jbtn_cancelar_actionPerformed();
    }

    private void jbtn_modificar_actionPerformed() {
        modelAddresses.update(modelAddresses.getId_distribuidor(), modelAddresses.getCalle(), modelAddresses.getNumero_casa(), modelAddresses.getColonia());
        JOptionPane.showMessageDialog(null,"Registro modificado con exito");
        jbtn_cancelar_actionPerformed();
    }

    private void jbtn_eliminar_actionPerformed() {
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de "
                    + "eliminar el registro?", "Alerta!", JOptionPane.YES_NO_OPTION);
        if(resp==0){
            modelAddresses.setId_distribuidor(viewAddresses.jtf_id.getText());
            modelAddresses.setCalle(viewAddresses.jtf_calle.getText());
            modelAddresses.setColonia(viewAddresses.jtf_colonia.getText());
            modelAddresses.setNumero_casa(viewAddresses.jtf_numerocasa.getText());
            modelAddresses.delete(modelAddresses.getId_distribuidor());
            JOptionPane.showMessageDialog(null,"Registro borrado con exito");
        }
        jbtn_cancelar_actionPerformed();
    }

    private void jbtn_cancelar_actionPerformed() {
        jbtn_primero_actionPerformed();
        viewAddresses.jbtn_anterior.setEnabled(true);
        viewAddresses.jbtn_siguiente.setEnabled(true);
        viewAddresses.jbtn_primero.setEnabled(true);
        viewAddresses.jbtn_ultimo.setEnabled(true);
        viewAddresses.jbtn_modificar.setEnabled(false);
        viewAddresses.jbtn_eliminar.setEnabled(true);
        viewAddresses.jbtn_nuevo.setEnabled(true);
        viewAddresses.jtf_id.setEditable(false);
        viewAddresses.jtf_calle.setEditable(false);
        viewAddresses.jtf_colonia.setEditable(false);
        viewAddresses.jtf_numerocasa.setEditable(false);
        viewAddresses.jbtn_cancelar.setEnabled(false);
        viewAddresses.jbtn_insertar.setEnabled(false);
        viewAddresses.jbtn_editar.setEnabled(true);
    }

    private void jbtn_editar_actionPerformed() {
        viewAddresses.jbtn_anterior.setEnabled(true);
        viewAddresses.jbtn_siguiente.setEnabled(true);
        viewAddresses.jbtn_primero.setEnabled(true);
        viewAddresses.jbtn_ultimo.setEnabled(true);
        viewAddresses.jbtn_modificar.setEnabled(true);
        viewAddresses.jbtn_eliminar.setEnabled(false);
        viewAddresses.jbtn_nuevo.setEnabled(false);
        viewAddresses.jtf_id.setEditable(true);
        viewAddresses.jtf_calle.setEditable(true);
        viewAddresses.jtf_colonia.setEditable(true);
        viewAddresses.jtf_numerocasa.setEditable(true);
        viewAddresses.jbtn_cancelar.setEnabled(true);
        viewAddresses.jbtn_insertar.setEnabled(false);
        viewAddresses.jbtn_editar.setEnabled(false);
    }
}
