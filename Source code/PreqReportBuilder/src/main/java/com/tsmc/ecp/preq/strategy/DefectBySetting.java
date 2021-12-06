package com.tsmc.ecp.preq.strategy;

import com.tsmc.ecp.preq.utils.Definition;
import com.tsmc.ecp.preq.vo.ExecuteStatus;
import com.tsmc.ecp.preq.vo.ExecuteStatusEnum;
import com.tsmc.ecp.preq.vo.PreBatchCaseObject;
import com.tsmc.ecp.preq.vo.PreqConfigObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefectBySetting implements IDataPackageStrategy{

    private static Logger logger;
    static {
        logger = LoggerFactory.getLogger(DefectBySetting.class);
    }

    @Override
    public void connectTo(String friendName) {

    }
}
