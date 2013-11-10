package org.anajo.accountbook.tag;

import java.util.List;

import org.anajo.accountbook.IdGenerator;
import org.anajo.accountbook.tag.dao.TagDao;
import org.anajo.accountbook.tag.model.Tag;

import android.content.Context;

public class TagServiceImpl implements TagService {

	private volatile static TagServiceImpl instance;

	private TagDao tagDao;

	private TagServiceImpl(Context context) {
		tagDao = TagDao.getInstance(context);
	}

	public static TagService getInstnace(Context context) {
		if (instance == null) {
			synchronized (TagServiceImpl.class) {
				if (instance == null) {
					instance = new TagServiceImpl(context);
				}
			}
		}

		return instance;
	}

	@Override
	public void createTag(String tagName) {
		Tag tag = tagDao.findTagByName(tagName);

		if (tag == null) {
			Tag newTag = new Tag();
			newTag.setId(IdGenerator.getInstance().getUUID());
			newTag.setName(tagName);
			tagDao.createTag(newTag);
		}
	}

	@Override
	public void deleteTag(Tag tag) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Tag> getAllTag() {
		return tagDao.getAllTag();
	}

}
