/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
            if (e.getSource() == viewDistributors) {
                
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
       
    }

    private void setActionListener() {
        
    }

    private void initDB() {
        
    }
    
}
