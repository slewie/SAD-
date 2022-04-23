package com.slewie.recommender;


import com.slewie.recommender.service.ApplicationFacade;

public class Main {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Specify the file with all the places.");
            System.exit(1);
        }

        String filename = args[0];
        var application = new ApplicationFacade(filename);
        application.doRun();

    }

}
