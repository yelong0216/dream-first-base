/**
 * 
 */
package dream.first.base.queryinfo.filter.impl.oracle;

import java.util.HashMap;
import java.util.Map;

import org.yelong.support.database.oracle.OracleConditionOperator;

import dream.first.base.queryinfo.DFQueryOperator;

/**
 * QueryOperator与Oracle条件运算符的映射
 * 
 * @since 2.1
 */
public class DFQueryOperatorMapperOracleOperator {

	public static final Map<DFQueryOperator, OracleConditionOperator> MAPPER = new HashMap<DFQueryOperator, OracleConditionOperator>();

	static {
		MAPPER.put(DFQueryOperator.ENDWITH, OracleConditionOperator.LESS_THAN_OR_EQUAL);
		MAPPER.put(DFQueryOperator.EQ, OracleConditionOperator.EQUAL);
		MAPPER.put(DFQueryOperator.IS, OracleConditionOperator.IS_NULL);
		MAPPER.put(DFQueryOperator.ISN, OracleConditionOperator.IS_NOT_NULL);
		MAPPER.put(DFQueryOperator.LIKE, OracleConditionOperator.LIKE);
		MAPPER.put(DFQueryOperator.NEQ, OracleConditionOperator.NOT_EQUAL);
		MAPPER.put(DFQueryOperator.NLIKE, OracleConditionOperator.NOT_LIKE);
		MAPPER.put(DFQueryOperator.STARTWITH, OracleConditionOperator.GREATER_THAN_OR_EQUAL);
		MAPPER.put(DFQueryOperator.GTE, OracleConditionOperator.GREATER_THAN_OR_EQUAL);
		MAPPER.put(DFQueryOperator.LTE, OracleConditionOperator.LESS_THAN_OR_EQUAL);
		MAPPER.put(DFQueryOperator.BETWEEN, OracleConditionOperator.BETWEEN);
		MAPPER.put(DFQueryOperator.IN, OracleConditionOperator.IN);
		MAPPER.put(DFQueryOperator.NIN, OracleConditionOperator.NOT_IN);
	}

	/**
	 * 获取查询条件映射的oracle条件运算符
	 * 
	 * @param queryOperator 查询运算符
	 * @return oracle运算符
	 */
	public static final OracleConditionOperator mapperOracleConditionOperator(DFQueryOperator queryOperator) {
		return MAPPER.get(queryOperator);
	}

}
