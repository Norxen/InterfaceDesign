/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ksn.controlador;

import com.ksn.modelo.WaterModel;
import com.ksn.modelo.WaterModel.State;
import com.ksn.vista.WaterView;

/**
 *
 * @author norxe
 */
public class WaterController {
    private final WaterView wv;
    private final WaterModel wm;
    
    public WaterController() {
        wv = new WaterView(this);
        wm = new WaterModel();
    }
    
    public static void main(String[] args) {
        args = new String[]{"-b", "20"};
        WaterController wc = new WaterController();
        wc.getView().showInitialTemperature(wc.getModel().getTemperature());
        wc.getView().initView(args);
    }

    public WaterView getView() {
        return wv;
    }

    public WaterModel getModel() {
        return wm;
    }
    
    public void askForWarmUp(int amount) {
        wm.warmUp(amount);
        askViewToShow(wm.getState());
    }
    
    public void askForCoolDown(int amount) {
        wm.coolDown(amount);
        askViewToShow(wm.getState());
    }
    
    public void askViewToShow(State state) {
        switch(state){
            case NORMAL -> {
                wv.showTemperature(wm.getTemperature());
            }
            case BOILED -> {
                wv.showErrorOverheated();
            }
            case FROZEN -> {
                wv.showErrorSubCooled();
            }
        }
    }
    
}
