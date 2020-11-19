/**
 * 
 */
package dream.first.base.queryinfo.sort;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.yelong.core.jdbc.sql.sort.support.Sort;

/**
 * 排序工具类
 * 
 * @since 2.1
 */
public final class DFQuerySortInfos {

	private DFQuerySortInfos() {
	}

	/**
	 * @param querySortInfo 查询排序信息
	 * @return 排序信息
	 */
	public static Sort toSort(DFQuerySortInfo querySortInfo) {
		return new Sort(querySortInfo.getSortField(), querySortInfo.getDirection());
	}

	/**
	 * @param querySortInfo 查询排序信息集合
	 * @return 排序信息集合
	 */
	public static List<Sort> toSort(Collection<? extends DFQuerySortInfo> querySortInfos) {
		return querySortInfos.stream().map(x -> toSort(x)).collect(Collectors.toList());
	}

}
