/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import models.ModelAddresses;
import models.ModelDistributors;
import models.ModelPersons;
import models.ModelMain;

import views.ViewAddresses;
import views.ViewDistributors;
import views.ViewPersons;
import views.ViewMain;

import controllers.ControllerAddresses;
import controllers.ControllerDistributors;
import controllers.ControllerPersons;
import controllers.ControllerMain;


/**
 *
 * @author PatyLu_Prz
 */
public class Main {
    public static void main(String[] args) {
        ModelAddresses modelAddresses = new ModelAddresses();
        ViewAddresses viewAddresses = new ViewAddresses();
        ControllerAddresses controllerAddresses = new ControllerAddresses(modelAddresses, viewAddresses);

        ModelDistributors modelDistribuitors = new ModelDistributors();
        ViewDistributors viewDistributors = new ViewDistributors();
        ControllerDistributors controllerDistributors = new ControllerDistributors(modelDistribuitors, viewDistributors);

        ModelPersons modelPersons = new ModelPersons();
        ViewPersons viewPersons = new ViewPersons();
        ControllerPersons controllerPersons = new ControllerPersons(modelPersons, viewPersons);

        Object[] controllers = new Object[3];
        controllers[0] = controllerAddresses;
        controllers[1] = controllerDistributors;
        controllers[2] = controllerPersons;

        ModelMain modelMain = new ModelMain();
        ViewMain viewMain = new ViewMain();
        ControllerMain controllerMain = new ControllerMain(modelMain, viewMain, controllers);
    }
}
