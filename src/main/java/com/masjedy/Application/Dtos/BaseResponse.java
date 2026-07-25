package com.masjedy.Application.Dtos;

import org.springframework.http.HttpStatus;

public class BaseResponse {
    private HttpStatus status = HttpStatus.ACCEPTED;
    private String message;
    private Object Data;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus httpStatus) {
        this.status = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }

    public  static BaseResponse Success(Object data) {
        BaseResponse response = new BaseResponse();
        response.Data = data;

        return response;
    }

    public static BaseResponse Fail(String message) {
        BaseResponse response = new BaseResponse();

        response.status = HttpStatus.BAD_REQUEST;
        response.message = message;

        return response;
    }
}
