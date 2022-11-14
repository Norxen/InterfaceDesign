/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ksn.modelo;



//Tank of water, this let you know the temperature at any point of the program.

//It will be initialized as a random number between 0 - 100
public class WaterModel {
    private int temperature;
    private State state;
    
    public enum State {
        NORMAL, BOILED, FROZEN;
    }
    
    public WaterModel(){
        temperature = Math.round((float) Math.random()*(100));
    }

    public int getTemperature() {
        return temperature;
    }
    
    public void warmUp(int amount) {
        temperature += amount;
        setState();
    }

    public void coolDown(int amount) {
        temperature -= amount;
        setState();
    }
    
    private void setState() {
        if(temperature < 0) state = State.FROZEN;
        else if(temperature > 100) state = State.BOILED;
        else state = State.NORMAL;
    }
    
    public State getState() {
        return state;
    }
    
}
