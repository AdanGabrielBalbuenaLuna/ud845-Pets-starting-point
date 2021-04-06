package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.pets.data.PetContract.PetEntry;


public class PetDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "shelter.db";
    public static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link PetDbHelper}.
     *
     * @param context of the app
     */
    public PetDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String SQL_CREATE_PETS_TABLE = " CREATE TABLE " + PetContract.PetEntry.TABLE_NAME + " (" +
                PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL, " +
                PetEntry.COLUMN_PET_BREED + " TEXT, " +
                PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL, " +
                PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0 );";
        sqLiteDatabase.execSQL(SQL_CREATE_PETS_TABLE);
    }

    /*private static final String TEXT_TYPE = "TEXT";
    private static final String COMMA_SEP = ",";
    private static final String INT_TYPE = "INTEGER";
    private static final String NOT_NULL = "INTEGER";
    private static final String DEFALUT_0 = "DEFAULT 0";
    private static final String SQL_CREATE_PETS_TABLE =
            "CREATE TABLE " + PetEntry.TABLE_NAME + "(" +
                    PetEntry._ID + "INTEGER PRIMARY KEY," +
                    PetEntry.COLUMN_PET_NAME + TEXT_TYPE + COMMA_SEP +
                    PetEntry.COLUMN_PET_BREED + TEXT_TYPE + COMMA_SEP +
                    PetEntry.COLUMN_PET_GENDER + "INTEGER NOT NULL" + COMMA_SEP +
                    PetEntry.COLUMN_PET_WEIGHT + "INEGER NOT NULL DEFAULT 0" +
                    ");";*/

    /**
     * This is called when the database needs to be upgraded.
     */
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // The database is still at version 1, so there's nothing to do be done here.
    }

    /*
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //This database is only a cache for online data, so its upgrade policy is
        //to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PetEntry.TABLE_NAME;*/
}
