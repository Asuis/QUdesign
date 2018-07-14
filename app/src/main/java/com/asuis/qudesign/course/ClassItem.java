package com.asuis.qudesign.course;

/**
 * Created by 15988440973 on 2018/1/8.
 * desciption:
 */

public class ClassItem {
    private String data;
    private int row;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public ClassItem(String data, int row) {
        this.data = data;
        this.row = row;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
