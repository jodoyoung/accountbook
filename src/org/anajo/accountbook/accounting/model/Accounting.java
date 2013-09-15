package org.anajo.accountbook.accounting.model;

import java.util.Date;

/**
 * 지출/수입 추상 객체
 * 
 * @author jodoyoung
 * @date 2013-08-31
 */
public abstract class Accounting {

	/** ID */
	private String id;

	/** 금액 */
	private Double amount;

	/** Tag */
	private String tag;

	/** 거래일시 */
	private Date dealDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Date getDealDate() {
		return dealDate;
	}

	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}

	public abstract String getTypeStr();
}
