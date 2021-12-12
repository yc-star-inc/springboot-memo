package com.tsmc.ecp.preq.strategy;

public class DataPackageContext
{
    IDataPackageStrategy dpStrategy;

    public DataPackageContext(String dataSubj, String pkgType) {

        if("SPC".equals(dataSubj)) {
            if("BySmartPkg".equals(pkgType)) {
                dpStrategy = new SpcFromIcci();
            } else {
                dpStrategy = new SpcBySetting();
            }
        }

        if("Defect".equals(dataSubj)) {
            if("BySmartPkg".equals(pkgType)) {
                dpStrategy = new SpcFromIcci();
            } else {
                dpStrategy = new DefectBySetting();
            }
        }

        if("FAC".equals(dataSubj)) {
            dpStrategy = new FacBySetting();
        }
    }

    public void getConfiguration(String name)
    {
        dpStrategy.getConfiguration(name);
    }

    public void collectData(String name)
    {
        dpStrategy.collectData(name);
    }

    public void genReport(String name)
    {
        dpStrategy.genReport(name);
    }

}