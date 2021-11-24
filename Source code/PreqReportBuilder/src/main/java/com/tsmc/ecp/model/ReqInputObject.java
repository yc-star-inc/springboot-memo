package com.tsmc.ecp.model;

import java.util.List;

public class ReqInputObject {

    String processName = "";
    String processKey = "";

    List<Element> params = null;

    public ReqInputObject(String procName, String procKey) {
        this.processName = procName;
        this.processKey = procKey;
    }

    public List<Element> getParams() {
        return params;
    }

    public void setParams(List<Element> params) {
        this.params = params;
    }

    public ReqInputObject() {}

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getProcessKey() {
        return processKey;
    }

    public void setProcessKey(String processKey) {
        this.processKey = processKey;
    }


    public static class Element {

        String id = "";
        String name = "";
        String height = "";

        public Element(String name, String id, String height) {
            this.id = id;
            this.name = name;
            this.height = height;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }
    }

}
