package org.anajo.accountbook.tag;

import java.util.List;

import org.anajo.accountbook.tag.model.Tag;

/**
 * Tag 제어
 * 
 * @author jodoyoung
 * @date 2013-09-08
 */
public interface TagService {

	/**
	 * Tag 추가
	 * 
	 * @param tag
	 */
	void createTag(Tag tag);

	/**
	 * Tag 삭제
	 * 
	 * @param tag
	 */
	void deleteTag(Tag tag);

	/**
	 * 전체 Tag 조회
	 * 
	 * @return
	 */
	List<Tag> getAllTag();
}
