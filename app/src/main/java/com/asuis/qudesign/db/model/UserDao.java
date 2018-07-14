package com.asuis.qudesign.db.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER".
*/
public class UserDao extends AbstractDao<User, String> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Username = new Property(0, String.class, "username", true, "USERNAME");
        public final static Property Password = new Property(1, String.class, "password", false, "PASSWORD");
    }


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER\" (" + //
                "\"USERNAME\" TEXT PRIMARY KEY NOT NULL ," + // 0: username
                "\"PASSWORD\" TEXT);"); // 1: password
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, User entity) {
        stmt.clearBindings();
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(1, username);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(2, password);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(1, username);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(2, password);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // username
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // password
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setUsername(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setPassword(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final String updateKeyAfterInsert(User entity, long rowId) {
        return entity.getUsername();
    }
    
    @Override
    public String getKey(User entity) {
        if(entity != null) {
            return entity.getUsername();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(User entity) {
        return entity.getUsername() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
