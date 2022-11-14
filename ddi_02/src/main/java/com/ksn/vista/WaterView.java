/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ksn.vista;

import com.ksn.controlador.WaterController;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 *
 * @author norxe
 */
public class WaterView {
    
    public WaterController wc;
    
    public WaterView(WaterController wc){
        this.wc = wc;
    }
    
    public void initView(String[] args) {
                ///////////////////////////////////// 1. FASE DE DEFINICIÓN
        // create Options object
        Options options = new Options();
        Option oUp = Option.builder("s").hasArg()
                .desc("Sube la temperatura x grados").build();
        Option oDown = Option.builder("b").hasArg()
                .desc("Baja la temperatura").build();

        OptionGroup group = new OptionGroup();
        group.addOption(oUp);
        group.addOption(oDown);
        options.addOptionGroup(group);
        options.addOption("h", "help", false, "display help");

        ///////////////////////////////////// 2. FASE DE PARSEO
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            ///////////////////////////////////// 3. FASE DE INTERROGACIÓN
            // Si opción -h
            if (cmd.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("time", options);
            } else {
                if (cmd.hasOption(oUp)) {
                    int value = Integer.parseInt(
                            cmd.getOptionValue(oUp));
                    wc.askForWarmUp(value);
              
                } else if (cmd.hasOption(oDown)) {
                    int value = Integer.parseInt(
                            cmd.getOptionValue(oDown));
                    wc.askForCoolDown(value);
                }
            }

        } catch (ParseException ex) {
            System.err.println(ex.getLocalizedMessage());
        }
    }
    
    public void showErrorOverheated() {
        System.out.println("Error, has hervido el agua a mas de 100º.");
    }
    
    public void showErrorSubCooled() {
        System.out.println("Error, has congelado el agua.");
    }
    
    public void showTemperature(int temperature){
        System.out.println("La temperatura final del agua es " + temperature + "º.");
    }
    
    public void showInitialTemperature(int temperature) {
        System.out.println("La temperatura inicial del agua es " + temperature + "º.");
    }
}
