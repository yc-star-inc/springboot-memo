package com.tsmc.ecp.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsmc.ecp.preq.strategy.SpcBySetting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

class ReqInputObjectTest {

    private static Logger logger;
    static {
        logger = LoggerFactory.getLogger(SpcBySetting.class);
    }

    //@Test
    public void test() throws JsonProcessingException {
        ReqInputObject.Element user1
                = new ReqInputObject.Element("Andy", "12208", "173");

        ReqInputObject.Element user2
                = new ReqInputObject.Element("Liu", "12209", "173");

        ReqInputObject reqObj = new ReqInputObject("AutoCW", "AutoCW");

        List<ReqInputObject.Element> params = new ArrayList<ReqInputObject.Element>();
        params.add(user1);
        params.add(user2);

        reqObj.setParams(params);

        ObjectMapper mapper = new ObjectMapper();
        String fRslt = mapper.writeValueAsString(reqObj);

        logger.info(String.format("Result: %s", fRslt));

    }

}