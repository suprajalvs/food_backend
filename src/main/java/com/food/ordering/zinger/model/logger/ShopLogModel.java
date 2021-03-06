package com.food.ordering.zinger.model.logger;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.food.ordering.zinger.enums.Priority;
import com.food.ordering.zinger.utils.Response;

import java.sql.Timestamp;

public class ShopLogModel {
    private Integer id;
    private Integer errorCode;
    private String mobile;
    private String message;
    private String updatedValue;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "Asia/Kolkata")
    private Timestamp date;

    private Priority priority;

    public ShopLogModel() {
    }

    public ShopLogModel(Response response, String mobile, Integer id, String updatedValue, Priority priority) {
        this.id = id;
        this.errorCode = response.getCode();
        this.mobile = mobile;
        this.message = response.getMessage();
        this.updatedValue = updatedValue;
        this.priority = priority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUpdatedValue() {
        return updatedValue;
    }

    public void setUpdatedValue(String updatedValue) {
        this.updatedValue = updatedValue;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "ShopLogModel{" +
                "id=" + id +
                ", errorCode=" + errorCode +
                ", mobile='" + mobile + '\'' +
                ", message='" + message + '\'' +
                ", updatedValue='" + updatedValue + '\'' +
                ", date=" + date +
                ", priority='" + priority + '\'' +
                '}';
    }
}
