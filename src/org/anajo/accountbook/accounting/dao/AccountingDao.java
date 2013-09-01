package org.anajo.accountbook.accounting.dao;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.anajo.accountbook.DatabaseHelper;
import org.anajo.accountbook.accounting.model.Accounting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * 지출/수입 데이터 처리
 * 
 * @author jodoyoung
 * @date 2013-09-01
 */
public class AccountingDao {

	private volatile static AccountingDao instance;

	/** SQLite */
	private DatabaseHelper databaseHelper;

	private AccountingDao(Context context) {
		databaseHelper = DatabaseHelper.getInstance(context);
	}

	public static AccountingDao getInstance(Context context) {
		if (instance == null) {
			synchronized (AccountingDao.class) {
				if (instance == null) {
					instance = new AccountingDao(context);
				}
			}
		}
		return instance;
	}

	/**
	 * 지출/수입 저장
	 * 
	 * @param accounting
	 */
	public void createAccounting(Accounting accounting) {
		SQLiteDatabase db = databaseHelper.getWritableDatabase();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
				Locale.KOREA);

		ContentValues values = new ContentValues();
		values.put("id", accounting.getId());
		values.put("type", accounting.getTypeStr());
		values.put("amount", accounting.getAmount());
		values.put("deal_date", sdf.format(accounting.getDealDate()));

		db.insert("accounting", null, values);
		db.close();
	}

	public void deleteAccounting(String accoungingId) {
		SQLiteDatabase db = databaseHelper.getWritableDatabase();
		db.close();
	}

	/**
	 * 지출/수입 전체내역 조회
	 * 
	 * @return
	 */
	public Cursor getAccountingList() {
		SQLiteDatabase db = databaseHelper.getReadableDatabase();

		Cursor cursor = db.query("accounting", new String[] { "id", "type",
				"amount", "deal_date" }, null, null, null, null, null);

		if (cursor != null) {
			cursor.moveToFirst();
		}

		db.close();

		return cursor;
	}

	public Accounting getExpenseList() {
		SQLiteDatabase db = databaseHelper.getReadableDatabase();
		db.close();
		return null;
	}

	public Accounting getIncomeList() {
		SQLiteDatabase db = databaseHelper.getReadableDatabase();
		db.close();
		return null;
	}
}
