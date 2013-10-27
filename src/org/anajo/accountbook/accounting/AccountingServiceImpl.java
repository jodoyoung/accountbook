package org.anajo.accountbook.accounting;

import org.anajo.accountbook.accounting.dao.AccountingDao;
import org.anajo.accountbook.accounting.model.Accounting;
import org.anajo.accountbook.tag.TagService;
import org.anajo.accountbook.tag.TagServiceImpl;

import android.content.Context;
import android.database.Cursor;

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
	public Cursor getAccoungtingList() {
		return accountingDao.getAccountingList();
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
