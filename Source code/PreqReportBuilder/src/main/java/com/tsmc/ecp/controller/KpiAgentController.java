package com.tsmc.ecp.controller;

import com.tsmc.ecp.preq.strategy.DataPackageContext;

//https://howtodoinjava.com/design-patterns/behavioral/strategy-design-pattern/
public class KpiAgentController {

    public static void main(String[] args) {

        String dataSubject = "SPC";
        String pkgType = "BySetting";

        // Creating social Media Connect Object for connecting with friend by
        // any social media strategy.
        DataPackageContext context = new DataPackageContext(dataSubject, pkgType);

        // Setting Facebook strategy.
        context.getConfiguration("Lokesh");
        context.collectData("Lokesh");

        System.out.println("====================");

        // Setting Twitter strategy.
        dataSubject = "Defect";
        context = new DataPackageContext(dataSubject, pkgType);

        // Setting Facebook strategy.
        context.getConfiguration("Lokesh");
        context.collectData("Lokesh");

        System.out.println("====================");

        dataSubject = "FAC";
        context = new DataPackageContext(dataSubject, pkgType);

        // Setting Facebook strategy.
        context.getConfiguration("Lokesh");
        context.collectData("Lokesh");

    }
}
