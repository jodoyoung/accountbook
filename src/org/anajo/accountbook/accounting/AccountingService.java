package org.anajo.accountbook.accounting;

import java.util.List;

import org.anajo.accountbook.accounting.model.Accounting;

import android.database.Cursor;

/**
 * ����/���� ����
 * 
 * @author jodoyoung
 * @date 2013-08-31
 */
public interface AccountingService {

	/**
	 * ����/���� ����
	 * 
	 * @param accounting
	 */
	void createAccounting(Accounting accounting);

	/**
	 * ����/���� ����
	 * 
	 * @param accoungingId
	 */
	void deleteAccounting(String accoungingId);

	/**
	 * ����/���� ��ü���� ��ȸ
	 * 
	 * @return
	 */
	List<Accounting> getAccountingList();

	/**
	 * ����/���� ��ü���� ��ȸ(Cursor)
	 * 
	 * @return
	 */
	Cursor getAccoungtingCursor();

	Accounting getExpenseList();

	Accounting getIncomeList();
}
