/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.ModelPersons;
import views.ViewPersons;

/**
 *
 * @author worte
 */
public class ControllerPersons {

     public ModelPersons modelPersons;
    public ViewPersons viewPersons;

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewPersons.jbtn_primero) {
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewPersons.jbtn_anterior) {
                jbtn_anterior_actionPerformed();
            } else if (e.getSource() == viewPersons.jbtn_siguiente) {
                jbtn_siguiente_actionPerformed();
            } else if (e.getSource() == viewPersons.jbtn_ultimo) {
                jbtn_ultimo_actionPerformed();
            } else if (e.getSource() == viewPersons.jbtn_nuevo){
                jbtn_nuevo_actionPerformed();
            } else if (e.getSource() == viewPersons.jbtn_insertar){
                jbtn_insertar_actionPerformed();
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewPersons.jbtn_modificar){
                jbtn_modificar_actionPerformed();
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewPersons.jbtn_eliminar){
                jbtn_eliminar_actionPerformed();
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewPersons.jbtn_cancelar){
                jbtn_cancelar_actionPerformed();
            } else if (e.getSource() == viewPersons.jbtn_editar){
                jbtn_editar_actionPerformed();
            }
        }
    };
    
    public ControllerPersons(ModelPersons modelPersons, ViewPersons viewPersons){
        this.modelPersons = modelPersons;
        this.viewPersons = viewPersons;
        setActionListener();
        initDB();
    }
    
    void initView() {
       viewPersons.setVisible(true);
    }

    private void setActionListener() {
        viewPersons.jbtn_primero.addActionListener(actionListener);
        viewPersons.jbtn_anterior.addActionListener(actionListener);
        viewPersons.jbtn_siguiente.addActionListener(actionListener);
        viewPersons.jbtn_ultimo.addActionListener(actionListener);
        viewPersons.jbtn_nuevo.addActionListener(actionListener);
        viewPersons.jbtn_insertar.addActionListener(actionListener);
        viewPersons.jbtn_modificar.addActionListener(actionListener);
        viewPersons.jbtn_eliminar.addActionListener(actionListener);
        viewPersons.jbtn_cancelar.addActionListener(actionListener);
        viewPersons.jbtn_editar.addActionListener(actionListener);
    }

    private void initDB() {
        modelPersons.conectarBD();
        viewPersons.jtf_id.setText(modelPersons.getId_distribuidor());
        viewPersons.jtf_nombre.setText(modelPersons.getNombre());
        viewPersons.jtf_ap.setText(modelPersons.getAp());
        viewPersons.jtf_am.setText(modelPersons.getAm());
    }
    
    private void jbtn_primero_actionPerformed() {
        modelPersons.setFirst();
        setValues();
    }

    private void jbtn_anterior_actionPerformed() {
        modelPersons.setLast();
        setValues();
    }

    private void jbtn_siguiente_actionPerformed() {
        modelPersons.setNext();
        setValues();
    }

    private void jbtn_ultimo_actionPerformed() {
        modelPersons.setLast();
        setValues();
    }

    
    private void setValues(){
        viewPersons.jtf_id.setText(modelPersons.getId_distribuidor());
        viewPersons.jtf_nombre.setText(modelPersons.getNombre());
    }
    
    private void jbtn_nuevo_actionPerformed() {
        viewPersons.jtf_id.setEditable(true);
        viewPersons.jtf_nombre.setEditable(true);
        viewPersons.jbtn_anterior.setEnabled(false);
        viewPersons.jbtn_siguiente.setEnabled(false);
        viewPersons.jbtn_primero.setEnabled(false);
        viewPersons.jbtn_ultimo.setEnabled(false);
        viewPersons.jbtn_modificar.setEnabled(false);
        viewPersons.jbtn_eliminar.setEnabled(false);
        viewPersons.jbtn_nuevo.setEnabled(false);
        viewPersons.jbtn_cancelar.setEnabled(true);
        viewPersons.jbtn_insertar.setEnabled(true);
        viewPersons.jtf_id.setText(null);
        viewPersons.jtf_nombre.setText(null);
        viewPersons.jbtn_editar.setEnabled(false);
    }

    private void jbtn_insertar_actionPerformed() {
        modelPersons.setId_distribuidor(viewPersons.jtf_id.getText());
        modelPersons.setNombre(viewPersons.jtf_nombre.getText());
        modelPersons.insert(
                modelPersons.getId_distribuidor(),
                modelPersons.getNombre(),
                modelPersons.getAp(),
                modelPersons.getAm()
                );
        JOptionPane.showMessageDialog(null,"Registro añadido con exito");
        jbtn_cancelar_actionPerformed();
    }

    private void jbtn_modificar_actionPerformed() {
        modelPersons.update(modelPersons.getId_distribuidor(), modelPersons.getNombre(),modelPersons.getAp(),modelPersons.getAm());
        JOptionPane.showMessageDialog(null,"Registro modificado con exito");
        jbtn_cancelar_actionPerformed();
    }

    private void jbtn_eliminar_actionPerformed() {
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de "
                    + "eliminar el registro?", "Alerta!", JOptionPane.YES_NO_OPTION);
        if(resp==0){
            modelPersons.setId_distribuidor(viewPersons.jtf_id.getText());
            modelPersons.setNombre(viewPersons.jtf_nombre.getText());
            modelPersons.setAp(viewPersons.jtf_ap.getText());
            modelPersons.setAm(viewPersons.jtf_am.getText());
            modelPersons.delete(modelPersons.getId_distribuidor());
            JOptionPane.showMessageDialog(null,"Registro borrado con exito");
        }
        jbtn_cancelar_actionPerformed();
    }

    private void jbtn_cancelar_actionPerformed() {
        jbtn_primero_actionPerformed();
        viewPersons.jbtn_anterior.setEnabled(true);
        viewPersons.jbtn_siguiente.setEnabled(true);
        viewPersons.jbtn_primero.setEnabled(true);
        viewPersons.jbtn_ultimo.setEnabled(true);
        viewPersons.jbtn_modificar.setEnabled(false);
        viewPersons.jbtn_eliminar.setEnabled(true);
        viewPersons.jbtn_nuevo.setEnabled(true);
        viewPersons.jtf_id.setEditable(false);
        viewPersons.jtf_nombre.setEditable(false);
        viewPersons.jbtn_cancelar.setEnabled(false);
        viewPersons.jbtn_insertar.setEnabled(false);
        viewPersons.jbtn_editar.setEnabled(true);
    }

    private void jbtn_editar_actionPerformed() {
        viewPersons.jbtn_anterior.setEnabled(true);
        viewPersons.jbtn_siguiente.setEnabled(true);
        viewPersons.jbtn_primero.setEnabled(true);
        viewPersons.jbtn_ultimo.setEnabled(true);
        viewPersons.jbtn_modificar.setEnabled(true);
        viewPersons.jbtn_eliminar.setEnabled(false);
        viewPersons.jbtn_nuevo.setEnabled(false);
        viewPersons.jtf_id.setEditable(true);
        viewPersons.jtf_nombre.setEditable(true);
        viewPersons.jbtn_cancelar.setEnabled(true);
        viewPersons.jbtn_insertar.setEnabled(false);
        viewPersons.jbtn_editar.setEnabled(false);
    }
}
