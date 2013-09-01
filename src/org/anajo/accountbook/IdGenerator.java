package org.anajo.accountbook;

import java.util.UUID;

/**
 * ID ������
 * 
 * @author jodoyoung
 * @date 2013-09-01
 */
public class IdGenerator {

	private static class IdGeneratorHolder {
		static final IdGenerator instance = new IdGenerator();
	}

	private IdGenerator() {
	}

	public static IdGenerator getInstance() {
		return IdGeneratorHolder.instance;
	}

	/**
	 * UUID ����(32�ڸ� ����)
	 * 
	 * @return
	 */
	public String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
