package org.anajo.accountbook.accounting;

import org.anajo.accountbook.accounting.model.Accounting;

import android.database.Cursor;

/**
 * 지출/수입 서비스
 * 
 * @author jodoyoung
 * @date 2013-08-31
 */
public interface AccountingService {

	/**
	 * 지출/수입 저장
	 * 
	 * @param accounting
	 */
	void createAccounting(Accounting accounting);

	/**
	 * 지출/수입 삭제
	 * 
	 * @param accoungingId
	 */
	void deleteAccounting(String accoungingId);

	/**
	 * 지출/수입 전체내역 조회
	 * 
	 * @return
	 */
	Cursor getAccoungtingList();

	Accounting getExpenseList();

	Accounting getIncomeList();
}
