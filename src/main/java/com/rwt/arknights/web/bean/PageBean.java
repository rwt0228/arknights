package com.rwt.arknights.web.bean;

import lombok.Data;

import java.util.List;

@Data
public class PageBean {

    private List rows;

    public PageBean() {
    }

    public PageBean(List rows) {
        this.rows = rows;
    }
}
