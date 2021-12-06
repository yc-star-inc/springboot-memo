package com.tsmc.ecp.preq.vo;

public class ExecuteStatus {

    private ExecuteStatusEnum status;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ExecuteStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ExecuteStatusEnum status) {
        this.status = status;
    }
}
