/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
            if (e.getSource() == viewPersons) {
                
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
       
    }

    private void setActionListener() {
        
    }

    private void initDB() {
        
    }
}
