package com.tsmc.ecp.preq.service;

import com.tsmc.ecp.preq.utils.Definition;
import com.tsmc.ecp.preq.vo.ExecuteStatus;
import com.tsmc.ecp.preq.vo.ExecuteStatusEnum;
import com.tsmc.ecp.preq.vo.PreBatchCaseObject;
import com.tsmc.ecp.preq.vo.PreqConfigObject;

public class KpiAgentService {

    public static ExecuteStatus doKpiCheck(PreBatchCaseObject caseObject) {

        ExecuteStatus execResult = new ExecuteStatus();
        PreqConfigObject configObject = caseObject.getConfigObject();

        if(Definition.LABEL_Y.equals(configObject.getEnableSpc())) {

        }

        caseObject.getCaseStatus();
        caseObject.getCaseStatusDefect();
        caseObject.getCaseStatusFac();

        execResult.setStatus(ExecuteStatusEnum.success);
        return execResult;
    }
}
