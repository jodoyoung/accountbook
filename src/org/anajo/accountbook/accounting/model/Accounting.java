package org.anajo.accountbook.accounting.model;

import java.util.Date;

/**
 * ����/���� �߻� ��ü
 * 
 * @author jodoyoung
 * @date 2013-08-31
 */
public abstract class Accounting {

	/** ID */
	private String id;

	/** �ݾ� */
	private Double amount;

	/** Tag */
	private String tag;

	/** �ŷ��Ͻ� */
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
