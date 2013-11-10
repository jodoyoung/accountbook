package org.anajo.accountbook;

/**
 * 환경 설정
 * 
 * @author jodoyoung
 * @date 2013-08-31
 */
public interface Environment {

	/** Database Name */
	String DATABASE_NAME = "account_book";

	/** Database Version */
	int DATABASE_VERSION = 1;

	/** 지출/수입 내역 Table */
	String QUERY_CREATE_TABLE_ACCOUNTING = "CREATE TABLE accounting (_id TEXT PRIMARY KEY, type TEXT NOT NULL, amount INTEGER NOT NULL, deal_date TEXT NOT NULL);";

	/** Tag Table */
	String QUERY_CREATE_TABLE_TAG = "CREATE TABLE tag (_id TEXT PRIMARY KEY, name TEXT NOT NULL);";

	/** Accounting-Tag Mapping Table */
	String QUERY_CREATE_TABLE_ACCOUNTING_TAG = "CREATE TABLE accounting_tag (_id TEXT PRIMARY KEY, accounting_id TEXT NOT NULL, tag_id TEXT NOT NULL);";

	/** Domain - Date Format */
	String DOMAIN_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
}
