package org.anajo.accountbook;

import org.anajo.accountbook.accounting.AccountingService;
import org.anajo.accountbook.accounting.AccountingServiceImpl;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Main 화면
 * 
 * @author jodoyoung
 * @date 2013-08-31
 */
public class MainActivity extends Activity {

	/** 지출 등록 버튼 */
	private Button btnCreateExpense;

	/** 수입 등록 버튼 */
	private Button btnCreateIncome;

	/** 지출 내역 버튼 */
	private Button btnExpenseList;

	/** 수입 내역 버튼 */
	private Button btnIncomeList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnCreateExpense = (Button) findViewById(R.id.btnCreateExpense);
		btnCreateExpense.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						ExpenseActivity.class);
				startActivity(intent);
			}
		});

		btnCreateIncome = (Button) findViewById(R.id.btnCreateIncome);
		btnCreateIncome.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			}
		});

		btnExpenseList = (Button) findViewById(R.id.btnExpenseList);
		btnExpenseList.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				AccountingService accountingService = AccountingServiceImpl
						.getInstance(MainActivity.this);
				Cursor cursor = accountingService.getAccoungtingList();

				cursor.moveToFirst();
				while (!cursor.isAfterLast()) {
					Log.d("Database Result >>> ", cursor.getString(0) + " / "
							+ cursor.getString(1) + " / " + cursor.getInt(2)
							+ " / " + cursor.getString(3));
					cursor.moveToNext();
				}

				cursor.close();
			}
		});

		btnIncomeList = (Button) findViewById(R.id.btnIncomeList);
		btnIncomeList.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			}
		});
	}

}
