package org.anajo.accountbook.accounting.adapter;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import org.anajo.accountbook.Environment;
import org.anajo.accountbook.R;
import org.anajo.accountbook.accounting.model.Accounting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 지출/수입 목록 Data Adapter
 * 
 * @author jodoyoung
 * @date 2013-11-10
 */
public class AccountingListAdapter extends BaseAdapter {

	private Context context = null;
	private LayoutInflater inflater = null;
	private ViewHolder viewHolder = null;
	private List<Accounting> accountingList = null;

	public AccountingListAdapter(Context c, List<Accounting> accountingList) {
		this.context = c;
		this.inflater = LayoutInflater.from(c);
		this.accountingList = accountingList;
	}

	@Override
	public int getCount() {
		return this.accountingList.size();
	}

	@Override
	public Accounting getItem(int arg0) {
		return this.accountingList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		View v = arg1;

		if (v == null) {
			this.viewHolder = new ViewHolder();
			v = inflater.inflate(R.layout.accounting_list_item, null);
			this.viewHolder.amount = (TextView) v.findViewById(R.id.textView1);
			this.viewHolder.date = (TextView) v.findViewById(R.id.textView2);
			this.viewHolder.tag = (TextView) v.findViewById(R.id.textView3);

			v.setTag(viewHolder);
		} else {
			this.viewHolder = (ViewHolder) v.getTag();
		}

		this.viewHolder.amount.setText(this.getItem(arg0).getAmount()
				.toString());
		this.viewHolder.tag.setText("test tag");

		SimpleDateFormat sdf = new SimpleDateFormat(
				Environment.DOMAIN_DATE_FORMAT, Locale.KOREAN);
		this.viewHolder.date.setText(sdf.format(this.getItem(arg0)
				.getDealDate()));

		return v;
	}

	public List<Accounting> getAccountingList() {
		return accountingList;
	}

	public void setAccountingList(List<Accounting> accountingList) {
		this.accountingList = accountingList;
	}

	class ViewHolder {
		public TextView amount = null;
		public TextView date = null;
		public TextView tag = null;
	}

	@Override
	protected void finalize() throws Throwable {
		free();
		super.finalize();
	}

	private void free() {
		inflater = null;
		accountingList = null;
		viewHolder = null;
		context = null;
	}

}
