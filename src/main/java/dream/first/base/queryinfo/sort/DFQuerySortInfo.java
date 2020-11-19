/**
 * 
 */
package dream.first.base.queryinfo.sort;

/**
 * 排序信息
 * 
 * @since 2.1
 */
public class DFQuerySortInfo {

	private String sortField;

	private String direction;

	public DFQuerySortInfo() {

	}

	/**
	 * @param sortField 排序字段
	 * @param direction 排序方向
	 */
	public DFQuerySortInfo(String sortField, String direction) {
		this.sortField = sortField;
		this.direction = direction;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

}
