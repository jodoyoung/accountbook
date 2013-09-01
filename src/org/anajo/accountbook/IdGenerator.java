package org.anajo.accountbook;

import java.util.UUID;

/**
 * ID 积己扁
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
	 * UUID 积己(32磊府 巩磊)
	 * 
	 * @return
	 */
	public String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
