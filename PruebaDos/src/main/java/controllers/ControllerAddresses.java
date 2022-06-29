/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import models.ModelAddresses;
import views.ViewAddresses;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            if (e.getSource() == viewAddresses) {
                
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
       
    }

    private void setActionListener() {
        
    }

    private void initDB() {
        
    }
    
}
