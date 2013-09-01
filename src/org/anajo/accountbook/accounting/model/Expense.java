package org.anajo.accountbook.accounting.model;

/**
 * 지출
 * 
 * @author jodoyoung
 * @date 2013-08-31
 */
public class Expense extends Accounting {

	@Override
	public String getTypeStr() {
		return "지출";
	}

}
