package com.asuis.qudesign.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 15988440973 on 2018/1/12.
 * desciption:
 */

@Entity
public class ScheduleItem {

    private String time;
    private String desc;
    @Generated(hash = 275212296)
    public ScheduleItem(String time, String desc) {
        this.time = time;
        this.desc = desc;
    }
    @Generated(hash = 620347724)
    public ScheduleItem() {
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
