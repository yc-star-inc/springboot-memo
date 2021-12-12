package com.tsmc.ecp.preq.strategy;

public interface IDataPackageStrategy
{
    void getConfiguration(String friendName);

    void collectData(String friendName);

    void genReport(String friendName);
}