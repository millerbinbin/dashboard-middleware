package com.jd.logistics.cloud.data.commons.validation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/27 22:05
 */
public class Errors {
    private static class Error {
        private String msg;
        private String field;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }
    }

    private List<Error> errors = new ArrayList();

    public Errors() {
    }

    public List<Error> getErrors() {
        return this.errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public static class Builder {
        private String msg;
        private List<Error> errors = new ArrayList();

        public Builder() {
        }

        public Errors.Builder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public Errors.Builder addFieldError(String field, String msg) {
            Error error = new Error();
            error.setField(field);
            error.setMsg(msg);
            this.errors.add(error);
            return this;
        }

        public Errors build() {
            Errors errors = new Errors();
            errors.getErrors().addAll(this.errors);
            return errors;
        }
    }
}