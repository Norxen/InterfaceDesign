/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ksn.modelo;

//Tank of water, this let you know the temperature at any point of the program.

//It will be initialized as a random number between 0 - 100
public class WaterModel {
    private int temperature;
    
    public WaterModel(){
        temperature = (int) Math.floor(Math.random()*(101));
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int warmUp(int amount) {
        return temperature + amount;
    }

    public int coolDown(int amount) {
        return temperature - amount;
    }
    
}
