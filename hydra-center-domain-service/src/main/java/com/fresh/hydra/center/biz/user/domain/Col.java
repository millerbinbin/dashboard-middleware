package com.fresh.hydra.center.biz.user.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/23 16:16
 */
@Data
public class Col implements Serializable {
    private static final long serialVersionUID = 6155650348427219235L;
    private String title;
    private String key;

    public Col(String key, String title) {
        this.title = title;
        this.key = key;
    }
}
