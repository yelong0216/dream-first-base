package dream.first.base.cache;

import java.util.function.Function;

import org.yelong.core.annotation.Nullable;
import org.yelong.core.cache.CacheManager;

/**
 * 抽象的缓存支持的代码管理器
 * 
 * @since 2.0
 */
public abstract class AbstractDreamFirstCacheableManager {

	@Nullable
	protected abstract CacheManager getCacheManager();

	protected <T> T putCacheObjIfAbsentAndSupportCache(String key, Function<String, T> cacheValueFactory) {
		CacheManager cacheManager = getCacheManager();
		if (null == cacheManager) {
			return cacheValueFactory.apply(key);
		}
		return DreamFirstCacheManagerUtils.putCacheObjIfAbsent(cacheManager, key, cacheValueFactory);
	}

}
