package com.tsmc.ecp.controller;

import com.tsmc.ecp.preq.service.KpiAgentService;
import com.tsmc.ecp.preq.vo.ExecuteStatus;
import com.tsmc.ecp.preq.vo.PreBatchCaseObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@RestController
public class KpiAgent {

    private static final Logger logger = LogManager.getLogger(KpiAgent.class);
    
    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World")String _name) {
        String response = "Welcome to join us, %s";
        return String.format(response, _name);
    }

    @GetMapping("/kpiCheck")
    public String kpiCheck(@RequestParam(value = "caseIds", defaultValue = "World") List<String> _caseIds) {
        String response = "Welcome to join us, %s";
        logger.info(response);

        PreBatchCaseObject caseObject = new PreBatchCaseObject();

        ExecuteStatus execStatus;
        execStatus = KpiAgentService.doKpiCheck(caseObject);
        logger.info(String.format("exec-result:", execStatus.getStatus()));
        return String.format(response, _caseIds);
    }

}
