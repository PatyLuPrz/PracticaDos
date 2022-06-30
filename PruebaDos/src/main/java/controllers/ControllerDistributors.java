/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.ModelDistributors;
import views.ViewDistributors;

/**
 *
 * @author worte
 */
public class ControllerDistributors {

    public ModelDistributors modelDistributors;
    public ViewDistributors viewDistributors;

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             if (e.getSource() == viewDistributors.jbtn_primero) {
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewDistributors.jbtn_anterior) {
                jbtn_anterior_actionPerformed();
            } else if (e.getSource() == viewDistributors.jbtn_siguiente) {
                jbtn_siguiente_actionPerformed();
            } else if (e.getSource() == viewDistributors.jbtn_ultimo) {
                jbtn_ultimo_actionPerformed();
            } else if (e.getSource() == viewDistributors.jbtn_nuevo){
                jbtn_nuevo_actionPerformed();
            } else if (e.getSource() == viewDistributors.jbtn_insertar){
                jbtn_insertar_actionPerformed();
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewDistributors.jbtn_modificar){
                jbtn_modificar_actionPerformed();
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewDistributors.jbtn_eliminar){
                jbtn_eliminar_actionPerformed();
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewDistributors.jbtn_cancelar){
                jbtn_cancelar_actionPerformed();
            } else if (e.getSource() == viewDistributors.jbtn_editar){
                jbtn_editar_actionPerformed();
            }
        }
    };
    
    public ControllerDistributors(ModelDistributors modelDistributors, ViewDistributors viewDistributors){
        this.modelDistributors = modelDistributors;
        this.viewDistributors = viewDistributors;
        setActionListener();
        initDB();
    }
    
    void initView() {
       viewDistributors.setVisible(true);
    }

    private void setActionListener() {
        viewDistributors.jbtn_primero.addActionListener(actionListener);
        viewDistributors.jbtn_anterior.addActionListener(actionListener);
        viewDistributors.jbtn_siguiente.addActionListener(actionListener);
        viewDistributors.jbtn_ultimo.addActionListener(actionListener);
        viewDistributors.jbtn_nuevo.addActionListener(actionListener);
        viewDistributors.jbtn_insertar.addActionListener(actionListener);
        viewDistributors.jbtn_modificar.addActionListener(actionListener);
        viewDistributors.jbtn_eliminar.addActionListener(actionListener);
        viewDistributors.jbtn_cancelar.addActionListener(actionListener);
        viewDistributors.jbtn_editar.addActionListener(actionListener);
    }

    private void initDB() {
        modelDistributors.conectarBD();
        viewDistributors.jtf_id.setText(modelDistributors.getId());
        viewDistributors.jtf_fecharegistro.setText(modelDistributors.getFecha_registro());
    }
    
    private void jbtn_primero_actionPerformed() {
        modelDistributors.setFirst();
        setValues();
    }

    private void jbtn_anterior_actionPerformed() {
        modelDistributors.setLast();
        setValues();
    }

    private void jbtn_siguiente_actionPerformed() {
        modelDistributors.setNext();
        setValues();
    }

    private void jbtn_ultimo_actionPerformed() {
        modelDistributors.setLast();
        setValues();
    }

    
    private void setValues(){
        viewDistributors.jtf_id.setText(modelDistributors.getId());
        viewDistributors.jtf_fecharegistro.setText(modelDistributors.getFecha_registro());
    }
    
    private void jbtn_nuevo_actionPerformed() {
        viewDistributors.jtf_id.setEditable(true);
        viewDistributors.jtf_fecharegistro.setEditable(true);
        viewDistributors.jbtn_anterior.setEnabled(false);
        viewDistributors.jbtn_siguiente.setEnabled(false);
        viewDistributors.jbtn_primero.setEnabled(false);
        viewDistributors.jbtn_ultimo.setEnabled(false);
        viewDistributors.jbtn_modificar.setEnabled(false);
        viewDistributors.jbtn_eliminar.setEnabled(false);
        viewDistributors.jbtn_nuevo.setEnabled(false);
        viewDistributors.jbtn_cancelar.setEnabled(true);
        viewDistributors.jbtn_insertar.setEnabled(true);
        viewDistributors.jtf_id.setText(null);
        viewDistributors.jtf_fecharegistro.setText(null);
        viewDistributors.jbtn_editar.setEnabled(false);
    }

    private void jbtn_insertar_actionPerformed() {
        modelDistributors.setId(viewDistributors.jtf_id.getText());
        modelDistributors.setFecha_registro(viewDistributors.jtf_fecharegistro.getText());
        modelDistributors.insert(
                modelDistributors.getId(),
                modelDistributors.getFecha_registro()
                );
        JOptionPane.showMessageDialog(null,"Registro añadido con exito");
        jbtn_cancelar_actionPerformed();
    }

    private void jbtn_modificar_actionPerformed() {
        modelDistributors.update(modelDistributors.getId(), modelDistributors.getFecha_registro());
        JOptionPane.showMessageDialog(null,"Registro modificado con exito");
        jbtn_cancelar_actionPerformed();
    }

    private void jbtn_eliminar_actionPerformed() {
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de "
                    + "eliminar el registro?", "Alerta!", JOptionPane.YES_NO_OPTION);
        if(resp==0){
            modelDistributors.setId(viewDistributors.jtf_id.getText());
            modelDistributors.setFecha_registro(viewDistributors.jtf_fecharegistro.getText());
            modelDistributors.delete(modelDistributors.getId());
            JOptionPane.showMessageDialog(null,"Registro borrado con exito");
        }
        jbtn_cancelar_actionPerformed();
    }

    private void jbtn_cancelar_actionPerformed() {
        jbtn_primero_actionPerformed();
        viewDistributors.jbtn_anterior.setEnabled(true);
        viewDistributors.jbtn_siguiente.setEnabled(true);
        viewDistributors.jbtn_primero.setEnabled(true);
        viewDistributors.jbtn_ultimo.setEnabled(true);
        viewDistributors.jbtn_modificar.setEnabled(false);
        viewDistributors.jbtn_eliminar.setEnabled(true);
        viewDistributors.jbtn_nuevo.setEnabled(true);
        viewDistributors.jtf_id.setEditable(false);
        viewDistributors.jtf_fecharegistro.setEditable(false);
        viewDistributors.jbtn_cancelar.setEnabled(false);
        viewDistributors.jbtn_insertar.setEnabled(false);
        viewDistributors.jbtn_editar.setEnabled(true);
    }

    private void jbtn_editar_actionPerformed() {
        viewDistributors.jbtn_anterior.setEnabled(true);
        viewDistributors.jbtn_siguiente.setEnabled(true);
        viewDistributors.jbtn_primero.setEnabled(true);
        viewDistributors.jbtn_ultimo.setEnabled(true);
        viewDistributors.jbtn_modificar.setEnabled(true);
        viewDistributors.jbtn_eliminar.setEnabled(false);
        viewDistributors.jbtn_nuevo.setEnabled(false);
        viewDistributors.jtf_id.setEditable(true);
        viewDistributors.jtf_fecharegistro.setEditable(true);
        viewDistributors.jbtn_cancelar.setEnabled(true);
        viewDistributors.jbtn_insertar.setEnabled(false);
        viewDistributors.jbtn_editar.setEnabled(false);
    }
    
}
