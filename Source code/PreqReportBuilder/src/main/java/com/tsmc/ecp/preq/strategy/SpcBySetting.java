package com.tsmc.ecp.preq.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpcBySetting implements IDataPackageStrategy{

    private static Logger logger;
    static {
        logger = LoggerFactory.getLogger(SpcBySetting.class);
    }

    @Override
    public void connectTo(String friendName) {

    }
}
