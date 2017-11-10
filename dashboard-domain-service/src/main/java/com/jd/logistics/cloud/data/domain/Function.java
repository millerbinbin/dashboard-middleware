package com.jd.logistics.cloud.data.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by GIN on 2017/10/30.
 */
@Data
public class Function implements Serializable {
    private static final long serialVersionUID = -3908221732001318230L;
    //    public enum FuncType {
//        BOX(0), CHART(1), FREE(2);
//        private int index;
//        FuncType(int index) {
//            this.index = index;
//        }
//        public static FuncType getFuncType(int index) {
//            switch (index) {
//                case 0:
//                    return FuncType.BOX;
//                case 1:
//                    return FuncType.CHART;
//                case 2:
//                    return FuncType.FREE;
//            }
//            return FuncType.BOX;
//        }
//    }
    private String id;
    private String funcName;
    private int funcType; // BOX(0), CHART(1), FREE(2);
    private int seq;

    public String getId() {
        return id;
    }

    public String getFuncName() {
        return funcName;
    }

    public int getFuncType() {
        return funcType;
    }

    public int getSeq() {
        return seq;
    }

}
