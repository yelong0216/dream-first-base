/**
 * 
 */
package dream.first.base.queryinfo.filter.impl.oracle;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.yelong.core.jdbc.sql.condition.ConditionConnectWay;
import org.yelong.core.jdbc.sql.condition.support.Condition;
import org.yelong.support.database.oracle.OracleConditionOperator;

import dream.first.base.queryinfo.DFQueryOperator;
import dream.first.base.queryinfo.filter.DFQueryFilterInfo;
import dream.first.base.queryinfo.filter.DFQueryFilterInfoResolveException;
import dream.first.base.queryinfo.filter.DFQueryFilterInfoResolver;

/**
 * oracle 查询过滤信息解析器
 * 
 * @since 2.1
 */
public class DFOracleQueryFilterInfoResolver implements DFQueryFilterInfoResolver {

	public static final DFOracleQueryFilterInfoResolver INSTANCE = new DFOracleQueryFilterInfoResolver();
	
	@SuppressWarnings("unchecked")
	@Override
	public Condition resolve(DFQueryFilterInfo queryFilterInfo) throws DFQueryFilterInfoResolveException {
		Objects.requireNonNull(queryFilterInfo);
		String fieldName = queryFilterInfo.getFieldName();
		String operator = queryFilterInfo.getOperator();
		Object value = queryFilterInfo.getFieldValue();
		DFQueryOperator queryOperator = DFQueryOperator.parse(operator);
		// 解析为oracle的运算符
		OracleConditionOperator oracleConditionOperator = DFQueryOperatorMapperOracleOperator
				.mapperOracleConditionOperator(queryOperator);
		if (null == oracleConditionOperator) {
			throw new DFQueryFilterInfoResolveException("非法的运算符：" + operator);
		}
		operator = oracleConditionOperator.getOperator();

		Integer needValueNum = oracleConditionOperator.getNeedValueNum();
		Condition condition = null;
		if (needValueNum == 0) {
			condition = new Condition(fieldName, operator);
		} else if (needValueNum == 2) {
			if (!value.getClass().isArray() && !(value instanceof List)) {// 如果value不是数组也不是集合
				throw new DFQueryFilterInfoResolveException("当前运算符（" + operator + "）需要集合或者数组类型的参数。但是value=" + value);
			}
			List<Object> valueList = null;
			if (value.getClass().isArray()) {
				valueList = Arrays.asList(value);
			} else {
				valueList = (List<Object>) value;
			}
			condition = new Condition(fieldName, operator, valueList.get(0), valueList.get(1));
		} else {
			if (value instanceof CharSequence) {
				String valueStr = value.toString();
				if (queryOperator == DFQueryOperator.LIKE || queryOperator == DFQueryOperator.NLIKE) {
					if (valueStr.startsWith("%") || valueStr.endsWith("%")) {

					} else {
						if (!valueStr.startsWith("%")) {
							valueStr = "%" + valueStr;
						}
						if (!valueStr.endsWith("%")) {
							valueStr = valueStr + "%";
						}
					}
				}
				value = valueStr;
			}
			condition = new Condition(fieldName, operator, value);
		}
		condition.setGroupName(queryFilterInfo.getGroupName());
		if (StringUtils.isNotEmpty(queryFilterInfo.getConnectOperator())) {
			condition.setConnectWay(ConditionConnectWay.valueOf(queryFilterInfo.getConnectOperator().toUpperCase()));
		}
		return condition;
	}

}
