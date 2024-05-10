package com.amaap.poker.controller.dto;

import java.util.Objects;

public class Response {
    private final HttpStatus httpStatus;
    private final String response;

    public Response(HttpStatus status, String response) {
        this.response = response;
        this.httpStatus = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response1 = (Response) o;
        return httpStatus == response1.httpStatus && Objects.equals(response, response1.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(httpStatus, response);
    }


    @Override
    public String toString() {
        return "Response{" + "httpStatus=" + httpStatus + ", response='" + response + '\'' + '}';
    }
}
