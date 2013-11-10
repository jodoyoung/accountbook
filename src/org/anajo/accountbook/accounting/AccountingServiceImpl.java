package org.anajo.accountbook.accounting;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.anajo.accountbook.Environment;
import org.anajo.accountbook.accounting.dao.AccountingDao;
import org.anajo.accountbook.accounting.model.Accounting;
import org.anajo.accountbook.accounting.model.Expense;
import org.anajo.accountbook.tag.TagService;
import org.anajo.accountbook.tag.TagServiceImpl;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

public class AccountingServiceImpl implements AccountingService {

	private volatile static AccountingServiceImpl instance;

	private AccountingDao accountingDao;

	private TagService tagService;

	private AccountingServiceImpl(Context context) {
		accountingDao = AccountingDao.getInstance(context);
		tagService = TagServiceImpl.getInstnace(context);
	}

	public static AccountingService getInstance(Context context) {
		if (instance == null) {
			synchronized (AccountingServiceImpl.class) {
				if (instance == null) {
					instance = new AccountingServiceImpl(context);
				}
			}
		}
		return instance;
	}

	@Override
	public void createAccounting(Accounting accounting) {
		String tagText = accounting.getTag();
		String[] tags = tagText.split(",");

		for (String tagName : tags) {
			tagService.createTag(tagName);
		}

		accountingDao.createAccounting(accounting);
	}

	@Override
	public void deleteAccounting(String accoungingId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Cursor getAccoungtingCursor() {
		return accountingDao.getAccountingList();
	}

	@Override
	public List<Accounting> getAccountingList() {
		Cursor cursor = accountingDao.getAccountingList();

		if (cursor != null) {
			cursor.moveToFirst();
		}

		List<Accounting> list = new ArrayList<Accounting>();
		Accounting accounting = null;

		SimpleDateFormat sdf = new SimpleDateFormat(
				Environment.DOMAIN_DATE_FORMAT, Locale.KOREAN);

		while (cursor.moveToNext()) {
			accounting = new Expense();
			accounting.setId(cursor.getString(0));
			accounting.setAmount(cursor.getDouble(2));
			try {
				accounting.setDealDate(sdf.parse(cursor.getString(3)));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			list.add(accounting);
		}

		return list;
	}

	@Override
	public Accounting getExpenseList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Accounting getIncomeList() {
		// TODO Auto-generated method stub
		return null;
	}

}
