package com.ksn.ddi_01;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Ddi_01 {

    public static void main(String[] args) {
        
        //Definition Stage
        Options options = new Options();
        options.addOption("w", "hello-world",false, "Muestra por pantalla hola mundo");
        options.addOption("h", "help", false, "Muestra la ayuda");
        options.addOption("y", "years", true, "Muestra el numero de años indicado");
        OptionGroup group = new OptionGroup();
        group.addOption(new Option("n", "nice", false, "Muestra por pantalla que el mundo es bonito."));
        group.addOption(new Option("c", "cruel", false, "Muestra por pantalla que el mundo es cruel."));
        options.addOptionGroup(group);
        
        //Parsing Stage
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;
                
        try {
            cmd = parser.parse(options, args);
            
            //Interrogation Stage
            if(cmd.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("ant", options);
            }
            else {
                if(cmd.hasOption("w")){
                    System.out.print("Hola mundo");
                    if(cmd.hasOption("n"))
                        System.out.println(" bonito");
                    if(cmd.hasOption("c"))
                        System.out.print(" cruel");
                }
                if(cmd.hasOption("y")) {
                    System.out.println("Tras " + cmd.getOptionValue("y") + " años de vida");
                }
            }
        } catch (ParseException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
