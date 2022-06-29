/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelMain;
import views.ViewMain;

/**
 *
 * @author PatyLu_Prz
 */
public class ControllerMain {
    private final ModelMain modelMain;
    private final ViewMain viewMain;
    
    private Object controllers[];
    
    private ControllerAddresses controllerAddeses;
    private ControllerDistributors controllerDistributors;
    private ControllerPersons controllerPersons;
    
    
    public ControllerMain(ModelMain modelMain, ViewMain viewMain, Object[] controllers){
        this.modelMain = modelMain;
        this.viewMain = viewMain;
        this.controllers = controllers;
        setControllers();
        setActionListener();
        initComponents();
    }

    private void setControllers() {
        controllerAddeses = (ControllerAddresses) controllers[0];
        controllerDistributors = (ControllerDistributors) controllers[1];
        controllerPersons = (ControllerPersons) controllers[2];
    }

    private void setActionListener() {
        viewMain.jmi_addresses.addActionListener(actionListener);
        viewMain.jmi_distributors.addActionListener(actionListener);
        viewMain.jmi_persons.addActionListener(actionListener);
        
    }

    private void initComponents() {
        viewMain.setTitle("Prueba Uno");
        viewMain.setLocationRelativeTo(null);
        viewMain.setVisible(true);
    }
    
    private final ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewMain.jmi_addresses) {
                jmi_adresses_actionPerformed();
            } else if (e.getSource() == viewMain.jmi_distributors) {
                jmi_distributors_actionPerformed();
            } else if (e.getSource() == viewMain.jmi_persons) {
                jmi_persons_actionPerformed();
            } else if (e.getSource() == viewMain.jmi_salir) {
                jmi_salir_actionPerformed();
            }
        }
    };
            
    private void jmi_adresses_actionPerformed() {
        controllerAddeses.initView();
        viewMain.setContentPane(controllerAddeses.viewAddresses);
        }

        private void jmi_persons_actionPerformed() {
            controllerPersons.initView();
            viewMain.setContentPane(controllerPersons.viewPersons);
        }

        private void jmi_distributors_actionPerformed() {
            controllerDistributors.initView();
            viewMain.setContentPane(controllerDistributors.viewDistributors);
        }
        
        private void jmi_salir_actionPerformed() {
            System.exit(0);
        }
}
