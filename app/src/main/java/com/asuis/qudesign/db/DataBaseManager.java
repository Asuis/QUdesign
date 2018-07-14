package com.asuis.qudesign.db;

/**
 * Created by 15988440973 on 2017/11/30.
 * desciption:
 */

public class DataBaseManager {

    private static final DataBaseManager ourInstance = new DataBaseManager();

    public static DataBaseManager getInstance() {
        return ourInstance;
    }

    private DataBaseManager() {
    }
}
