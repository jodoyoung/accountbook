package org.anajo.accountbook;

import org.anajo.accountbook.accounting.AccountingService;
import org.anajo.accountbook.accounting.AccountingServiceImpl;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * 지출 등록 화면
 * 
 * @author jodoyoung
 * @date 2013-08-31
 */
public class AccountingListActivity extends Activity {

	/** 지출/수입 목록 */
	ListView viewAccountingList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accounting_list);

		viewAccountingList = (ListView) findViewById(R.id.listView1);

		Intent intent = getIntent();
		String accountingType = intent.getStringExtra("type");

		AccountingService accountingService = AccountingServiceImpl
				.getInstance(AccountingListActivity.this);
		Cursor cursor = accountingService.getAccoungtingList();

		cursor.moveToFirst();

		String[] columnName = new String[] { "_id", "amount", "deal_date" };
		int[] labelName = new int[] { R.id.textView3, R.id.textView1,
				R.id.textView2 };

		@SuppressWarnings("deprecation")
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
				R.layout.accounting_list_item, cursor, columnName, labelName);

		viewAccountingList.setAdapter(adapter);

		// while (!cursor.isAfterLast()) {
		// Log.d("Database Result >>> ",
		// cursor.getString(0) + " / " + cursor.getString(1) + " / "
		// + cursor.getInt(2) + " / " + cursor.getString(3));
		// cursor.moveToNext();
		// }

		// cursor.close();
	}
}
