package com.quantimodo.tools.models;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;

import com.quantimodo.tools.models.Variable;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "VARIABLE".
*/
public class VariableDao extends AbstractDao<Variable, Long> {

    public static final String TABLENAME = "VARIABLE";

    /**
     * Properties of entity Variable.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "ID");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property OriginalName = new Property(2, String.class, "originalName", false, "ORIGINAL_NAME");
        public final static Property ParentVariable = new Property(3, Long.class, "parentVariable", false, "PARENT_VARIABLE");
        public final static Property UnitId = new Property(4, Long.class, "unitId", false, "UNIT_ID");
        public final static Property CategoryId = new Property(5, Long.class, "categoryId", false, "CATEGORY_ID");
        public final static Property CombOperation = new Property(6, short.class, "combOperation", false, "COMB_OPERATION");
        public final static Property Updated = new Property(7, java.util.Date.class, "updated", false, "UPDATED");
        public final static Property LatestMeasurementTime = new Property(8, java.util.Date.class, "latestMeasurementTime", false, "LATEST_MEASUREMENT_TIME");
    };

    private DaoSession daoSession;


    public VariableDao(DaoConfig config) {
        super(config);
    }
    
    public VariableDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"VARIABLE\" (" + //
                "\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"NAME\" TEXT NOT NULL ," + // 1: name
                "\"ORIGINAL_NAME\" TEXT," + // 2: originalName
                "\"PARENT_VARIABLE\" INTEGER," + // 3: parentVariable
                "\"UNIT_ID\" INTEGER," + // 4: unitId
                "\"CATEGORY_ID\" INTEGER," + // 5: categoryId
                "\"COMB_OPERATION\" INTEGER NOT NULL ," + // 6: combOperation
                "\"UPDATED\" INTEGER," + // 7: updated
                "\"LATEST_MEASUREMENT_TIME\" INTEGER);"); // 8: latestMeasurementTime
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"VARIABLE\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Variable entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
 
        String originalName = entity.getOriginalName();
        if (originalName != null) {
            stmt.bindString(3, originalName);
        }
 
        Long parentVariable = entity.getParentVariable();
        if (parentVariable != null) {
            stmt.bindLong(4, parentVariable);
        }
 
        Long unitId = entity.getUnitId();
        if (unitId != null) {
            stmt.bindLong(5, unitId);
        }
 
        Long categoryId = entity.getCategoryId();
        if (categoryId != null) {
            stmt.bindLong(6, categoryId);
        }
        stmt.bindLong(7, entity.getCombOperation());
 
        java.util.Date updated = entity.getUpdated();
        if (updated != null) {
            stmt.bindLong(8, updated.getTime());
        }
 
        java.util.Date latestMeasurementTime = entity.getLatestMeasurementTime();
        if (latestMeasurementTime != null) {
            stmt.bindLong(9, latestMeasurementTime.getTime());
        }
    }

    @Override
    protected void attachEntity(Variable entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Variable readEntity(Cursor cursor, int offset) {
        Variable entity = new Variable( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // originalName
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // parentVariable
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // unitId
            cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5), // categoryId
            cursor.getShort(offset + 6), // combOperation
            cursor.isNull(offset + 7) ? null : new java.util.Date(cursor.getLong(offset + 7)), // updated
            cursor.isNull(offset + 8) ? null : new java.util.Date(cursor.getLong(offset + 8)) // latestMeasurementTime
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Variable entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setOriginalName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setParentVariable(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setUnitId(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setCategoryId(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
        entity.setCombOperation(cursor.getShort(offset + 6));
        entity.setUpdated(cursor.isNull(offset + 7) ? null : new java.util.Date(cursor.getLong(offset + 7)));
        entity.setLatestMeasurementTime(cursor.isNull(offset + 8) ? null : new java.util.Date(cursor.getLong(offset + 8)));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Variable entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Variable entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getVariableDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getUnitDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T2", daoSession.getCategoryDao().getAllColumns());
            builder.append(" FROM VARIABLE T");
            builder.append(" LEFT JOIN VARIABLE T0 ON T.\"PARENT_VARIABLE\"=T0.\"ID\"");
            builder.append(" LEFT JOIN UNIT T1 ON T.\"UNIT_ID\"=T1.\"ID\"");
            builder.append(" LEFT JOIN CATEGORY T2 ON T.\"CATEGORY_ID\"=T2.\"ID\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Variable loadCurrentDeep(Cursor cursor, boolean lock) {
        Variable entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Variable parent = loadCurrentOther(daoSession.getVariableDao(), cursor, offset);
        entity.setParent(parent);
        offset += daoSession.getVariableDao().getAllColumns().length;

        Unit unit = loadCurrentOther(daoSession.getUnitDao(), cursor, offset);
        entity.setUnit(unit);
        offset += daoSession.getUnitDao().getAllColumns().length;

        Category category = loadCurrentOther(daoSession.getCategoryDao(), cursor, offset);
        entity.setCategory(category);

        return entity;    
    }

    public Variable loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Variable> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Variable> list = new ArrayList<Variable>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Variable> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Variable> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}