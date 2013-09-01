package org.anajo.accountbook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * DB �ڵ鸵
 * 
 * @author jodoyoung
 * @date 2013-08-31
 */
public class DatabaseHelper extends SQLiteOpenHelper {

	/** Singleton Instance */
	private volatile static DatabaseHelper instance;

	private DatabaseHelper(Context context) {
		super(context, Environment.DATABASE_NAME, null,
				Environment.DATABASE_VERSION);
	}

	public static DatabaseHelper getInstance(Context context) {
		if (instance == null) {
			synchronized (DatabaseHelper.class) {
				if (instance == null) {
					instance = new DatabaseHelper(context);
				}
			}
		}
		return instance;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(Environment.QUERY_CREATE_TABLE_ACCOUNTING);
		db.execSQL(Environment.QUERY_CREATE_TABLE_TAG);
		db.execSQL(Environment.QUERY_CREATE_TABLE_ACCOUNTING_TAG);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.w("DB >>> ", "Upgrading database from version " + oldVersion
				+ " to " + newVersion + ", which will destroy all old data");
	}

}
