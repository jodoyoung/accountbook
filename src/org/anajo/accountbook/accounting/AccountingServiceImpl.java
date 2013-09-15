package org.anajo.accountbook.accounting;

import org.anajo.accountbook.accounting.dao.AccountingDao;
import org.anajo.accountbook.accounting.model.Accounting;

import android.content.Context;
import android.database.Cursor;

public class AccountingServiceImpl implements AccountingService {

	private volatile static AccountingServiceImpl instance;

	private AccountingDao accountingDao;

	private AccountingServiceImpl(Context context) {
		accountingDao = AccountingDao.getInstance(context);
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

	public AccountingDao getAccountingDao() {
		return accountingDao;
	}

	public void setAccountingDao(AccountingDao accountingDao) {
		this.accountingDao = accountingDao;
	}

	@Override
	public void createAccounting(Accounting accounting) {
		String tagText = accounting.getTag();
		String[] tags = tagText.split(",");
		
		for(String tag : tags) {
			
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
