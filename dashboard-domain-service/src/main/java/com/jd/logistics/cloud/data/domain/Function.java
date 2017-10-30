package com.jd.logistics.cloud.data.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by GIN on 2017/10/30.
 */
@Data
public class Function implements Serializable{
    public enum FuncType {
        BOX(0), CHART(1), FREE(2);
        private int index;
        FuncType(int index) {
            this.index = index;
        }
        public static FuncType getFuncType(int index) {
            switch (index) {
                case 0:
                    return FuncType.BOX;
                case 1:
                    return FuncType.CHART;
                case 2:
                    return FuncType.FREE;
            }
            return FuncType.BOX;
        }
    }
    private String funcName;
    private FuncType funcType;

    public Function(String funcName, FuncType funcType) {
        this.funcName = funcName;
        this.funcType = funcType;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public FuncType getFuncType() {
        return funcType;
    }

    public void setFuncType(FuncType funcType) {
        this.funcType = funcType;
    }
}
