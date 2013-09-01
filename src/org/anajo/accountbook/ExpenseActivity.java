package org.anajo.accountbook;

import java.util.Date;

import org.anajo.accountbook.accounting.AccountingService;
import org.anajo.accountbook.accounting.AccountingServiceImpl;
import org.anajo.accountbook.accounting.model.Accounting;
import org.anajo.accountbook.accounting.model.Expense;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * ���� ��� ȭ��
 * 
 * @author jodoyoung
 * @date 2013-08-31
 */
public class ExpenseActivity extends Activity {

	/** ���� �ݾ� �Է¶� */
	EditText txtAmount;

	/** TAG �Է¶� */
	EditText txtTag;

	/** ���� ��� ��ư */
	Button btnCreateExpense;

	/** �ڷ� ���� ��ư */
	Button btnGoBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expense);

		txtAmount = (EditText) findViewById(R.id.txtAmount);
		txtTag = (EditText) findViewById(R.id.txtTag);

		btnCreateExpense = (Button) findViewById(R.id.btnCreateExpense);
		btnCreateExpense.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Double amount = Double.parseDouble(txtAmount.getText()
						.toString());

				Accounting accounting = new Expense();
				accounting.setId(IdGenerator.getInstance().getUUID());
				accounting.setAmount(amount);
				accounting.setTag(txtTag.getText().toString());
				accounting.setDealDate(new Date());

				AccountingService accountingService = AccountingServiceImpl
						.getInstance(ExpenseActivity.this);
				accountingService.createAccounting(accounting);
			}
		});

		btnGoBack = (Button) findViewById(R.id.btnGoBack);
		btnGoBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}
}
