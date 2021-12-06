package com.tsmc.ecp.preq.vo;

public class PreBatchCaseObject {

    public int caseId;
    public String matNo;
    public String caseStatus;
    public String caseStatusDefect;
    public String caseStatusFac;

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getCaseStatusDefect() {
        return caseStatusDefect;
    }

    public void setCaseStatusDefect(String caseStatusDefect) {
        this.caseStatusDefect = caseStatusDefect;
    }

    public String getCaseStatusFac() {
        return caseStatusFac;
    }

    public void setCaseStatusFac(String caseStatusFac) {
        this.caseStatusFac = caseStatusFac;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getMatNo() {
        return matNo;
    }

    public void setMatNo(String matNo) {
        this.matNo = matNo;
    }

    public PreqConfigObject getConfigObject() {
    }
}
