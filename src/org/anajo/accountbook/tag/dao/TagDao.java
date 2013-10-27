package org.anajo.accountbook.tag.dao;

import java.util.ArrayList;
import java.util.List;

import org.anajo.accountbook.DatabaseHelper;
import org.anajo.accountbook.tag.model.Tag;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Tag 데이터 처리
 * 
 * @author jodoyoung
 * @date 2013-09-08
 */
public class TagDao {

	private volatile static TagDao instance;

	/** SQLite */
	private DatabaseHelper databaseHelper;

	private TagDao(Context context) {
		databaseHelper = DatabaseHelper.getInstance(context);
	}

	public static TagDao getInstance(Context context) {
		if (instance == null) {
			synchronized (TagDao.class) {
				if (instance == null) {
					instance = new TagDao(context);
				}
			}
		}
		return instance;
	}

	/**
	 * Tag 저장
	 * 
	 * @param tag
	 */
	public void createTag(Tag tag) {
		SQLiteDatabase db = databaseHelper.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put("_id", tag.getId());
		values.put("name", tag.getName());

		db.insert("tag", null, values);
		db.close();
	}

	/**
	 * Tag 조회 (name)
	 * 
	 * @param tagName
	 * @return
	 */
	public Tag findTagByName(String tagName) {
		SQLiteDatabase db = databaseHelper.getReadableDatabase();

		Cursor cursor = db.query("tag", new String[] { "_id", "name" },
				"name=?", new String[] { tagName }, null, null, null, null);

		if (cursor != null) {
			cursor.moveToFirst();
		}

		Tag tag = null;

		if (cursor.moveToNext()) {
			tag = new Tag();
			tag.setId(cursor.getString(0));
			tag.setName(cursor.getString(1));
		}

		cursor.close();
		db.close();

		return tag;
	}

	/**
	 * Tag 삭제
	 * 
	 * @param tagId
	 */
	public void deleteTag(String tagId) {
		SQLiteDatabase db = databaseHelper.getWritableDatabase();
		db.delete("tag", "id=" + tagId, null);
		db.close();
	}

	/**
	 * 전체 Tag 조회
	 * 
	 * @return
	 */
	public List<Tag> getAllTag() {
		SQLiteDatabase db = databaseHelper.getReadableDatabase();

		Cursor cursor = db.query("tag", new String[] { "_id", "name" }, null,
				null, null, null, null);

		if (cursor != null) {
			cursor.moveToFirst();
		}

		List<Tag> list = new ArrayList<Tag>();
		Tag tag = null;

		while (cursor.moveToNext()) {
			tag = new Tag();
			tag.setId(cursor.getString(0));
			tag.setName(cursor.getString(1));
			list.add(tag);
		}

		return list;
	}
}
