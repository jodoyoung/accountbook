package org.anajo.accountbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Main ȭ��
 * 
 * @author jodoyoung
 * @date 2013-08-31
 */
public class MainActivity extends Activity {

	/** ���� ��� ��ư */
	private Button btnCreateExpense;

	/** ���� ��� ��ư */
	private Button btnCreateIncome;

	/** ���� ���� ��ư */
	private Button btnExpenseList;

	/** ���� ���� ��ư */
	private Button btnIncomeList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Splash(�ε�ȭ��) ����
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
				intent.putExtra("type", "����");

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
