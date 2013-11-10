package org.anajo.accountbook;

import java.util.Date;
import java.util.List;

import org.anajo.accountbook.accounting.AccountingService;
import org.anajo.accountbook.accounting.AccountingServiceImpl;
import org.anajo.accountbook.accounting.model.Accounting;
import org.anajo.accountbook.accounting.model.Expense;
import org.anajo.accountbook.tag.TagService;
import org.anajo.accountbook.tag.TagServiceImpl;
import org.anajo.accountbook.tag.model.Tag;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * 지출 등록 화면
 * 
 * @author jodoyoung
 * @date 2013-08-31
 */
public class ExpenseActivity extends Activity {

	/** 지출 금액 입력란 */
	EditText txtAmount;

	/** TAG 입력란 */
	EditText txtTag;

	/** 지출 등록 버튼 */
	Button btnCreateExpense;

	/** 뒤로 가기 버튼 */
	Button btnGoBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expense);

		txtAmount = (EditText) findViewById(R.id.txtAmount);
		txtTag = (EditText) findViewById(R.id.txtTag);

		Spinner tagSpinner = (Spinner) findViewById(R.id.tag_spinner);

		TagService tagService = TagServiceImpl.getInstnace(this);
		final List<Tag> tagList = tagService.getAllTag();

		final String[] tags = new String[tagList.size() + 1];
		tags[0] = "직접입력";

		for (int i = 0; i < tagList.size(); i++) {
			tags[i + 1] = tagList.get(i).getName();
		}

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, tags);

		tagSpinner.setAdapter(adapter);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

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

				Toast.makeText(ExpenseActivity.this, "지출이 등록되었습니다.",
						Toast.LENGTH_SHORT).show();
			}
		});

		btnGoBack = (Button) findViewById(R.id.btnGoBack);
		btnGoBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});

		tagSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long id) {
				if (position == 0)
					return;

				String tagText = "";
				String existingText = txtTag.getText().toString();

				if (existingText.trim().length() > 0)
					tagText += ",";

				tagText += tagList.get(position - 1).getName();

				txtTag.getText().append(tagText);

				// Toast.makeText(ExpenseActivity.this,
				// "Spinner1: position=" + position + " id=" + id,
				// Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
	}
}
