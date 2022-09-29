/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ksn.controlador;

import com.ksn.modelo.WaterModel;
import com.ksn.vista.WaterView;

/**
 *
 * @author norxe
 */
public class WaterController {
    private WaterView wv;
    private WaterModel wm;
    
    public WaterController() {
        wv = new WaterView();
        wm = new WaterModel();
    }
    
    public static void main(String[] args) {
        args = new String[]{"-b", "20"};
        WaterController wc = new WaterController();
        wc.getView().initView(args);
    }

    public WaterView getView() {
        return wv;
    }

    public WaterModel getModel() {
        return wm;
    }
    
    public void askForWarmUp(int amount) {
        int temperature = wm.warmUp(amount);
        wv.updateResult(temperature);
    }
    
    public void askForCoolDown(int amount) {
        int temperature = wm.coolDown(amount);
        wv.updateResult(temperature);
    }
    
}
