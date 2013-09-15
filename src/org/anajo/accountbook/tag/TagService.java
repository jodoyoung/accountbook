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
	 * @param tag
	 */
	void createTag(Tag tag);

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
