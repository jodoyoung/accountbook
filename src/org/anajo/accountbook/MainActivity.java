package org.anajo.accountbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
		
		// Splash(로딩화면) 띄우기
		startActivity(new Intent(this, SplashActivity.class));

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
				Intent intent = new Intent(MainActivity.this,
						AccountingListActivity.class);
				intent.putExtra("type", "지출");

				startActivity(intent);
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
