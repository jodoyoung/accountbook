package org.anajo.accountbook.tag;

import java.util.List;

import org.anajo.accountbook.tag.model.Tag;

/**
 * Tag ����
 * 
 * @author jodoyoung
 * @date 2013-09-08
 */
public interface TagService {

	/**
	 * Tag �߰�
	 * 
	 * @param tagName
	 */
	void createTag(String tagName);

	/**
	 * Tag ����
	 * 
	 * @param tag
	 */
	void deleteTag(Tag tag);

	/**
	 * ��ü Tag ��ȸ
	 * 
	 * @return
	 */
	List<Tag> getAllTag();
}
