package dream.first.base.utils;

import java.util.UUID;

public final class DreamFirstBaseModelIDGenerator {

	private DreamFirstBaseModelIDGenerator() {
	}
	
	/**
	 * 获取32位字符的随机串
	 * 
	 * @return 32位字符的随机串
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

}
