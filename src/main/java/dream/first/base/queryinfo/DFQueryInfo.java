/**
 * 
 */
package dream.first.base.queryinfo;

import java.util.ArrayList;
import java.util.List;

import dream.first.base.queryinfo.filter.DFQueryFilterInfo;
import dream.first.base.queryinfo.sort.DFQuerySortInfo;

/**
 * 查询信息 与前端交互的一个POJO
 * 
 * @since 2.1
 */
public class DFQueryInfo {

	protected Integer pageNum;

	protected Integer pageSize;

	protected List<DFQueryFilterInfo> filters = new ArrayList<>();

	protected List<DFQuerySortInfo> sorters = new ArrayList<>();

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<? extends DFQueryFilterInfo> getFilters() {
		return filters;
	}

	@SuppressWarnings("unchecked")
	public void setFilters(List<? extends DFQueryFilterInfo> filters) {
		this.filters = (List<DFQueryFilterInfo>) filters;
	}

	public List<? extends DFQuerySortInfo> getSorters() {
		return sorters;
	}

	/**
	 * 是否存在条件
	 * 
	 * @return <tt>true</tt> 存在条件
	 */
	public boolean isFilter() {
		return null != filters && !filters.isEmpty();
	}

	/**
	 * 设置排序信息。这会覆盖原有的排序信息
	 * 
	 * @param sorters 排序集合
	 */
	@SuppressWarnings("unchecked")
	public void setSorters(List<? extends DFQuerySortInfo> sorters) {
		this.sorters = (List<DFQuerySortInfo>) sorters;
	}

	/**
	 * 是否存在排序
	 * 
	 * @return <tt>true</tt>存在排序
	 */
	public boolean isSort() {
		return null != sorters && !sorters.isEmpty();
	}

	/**
	 * 添加一个排序
	 * 
	 * @param querySortInfo 排序信息
	 */
	public void addSort(DFQuerySortInfo querySortInfo) {
		this.sorters.add(querySortInfo);
	}

	/**
	 * 添加一个排序
	 * 
	 * @param sortField 排序字段
	 * @param direction 排序方向
	 */
	public void addSort(String sortField, String direction) {
		this.sorters.add(new DFQuerySortInfo(sortField, direction));
	}

	/**
	 * 添加一个排序条件
	 * 
	 * @param queryFilterInfo 条件信息
	 */
	public void addFilter(DFQueryFilterInfo queryFilterInfo) {
		this.filters.add(queryFilterInfo);
	}
}
