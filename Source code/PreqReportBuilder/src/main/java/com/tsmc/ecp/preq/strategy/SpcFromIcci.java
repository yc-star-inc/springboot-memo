package com.tsmc.ecp.preq.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpcFromIcci implements IDataPackageStrategy{

    private static Logger logger;
    static {
        logger = LoggerFactory.getLogger(SpcFromIcci.class);
    }

    @Override
    public void getConfiguration(String friendName) {

    }

    @Override
    public void collectData(String friendName) {

    }

    @Override
    public void genReport(String friendName) {

    }
}
