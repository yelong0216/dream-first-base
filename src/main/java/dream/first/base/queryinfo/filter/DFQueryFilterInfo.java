/**
 * 
 */
package dream.first.base.queryinfo.filter;

import java.util.Arrays;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @since 2.1
 */
public class DFQueryFilterInfo {

	protected String fieldName;

	protected String operator;

	protected Object fieldValue;

	protected String groupName;

	protected Class<?> fieldType;

	protected String fieldTypeStr;

	protected String connectOperator;

	public DFQueryFilterInfo() {

	}

	public DFQueryFilterInfo(String fieldName, String operator) {
		this.fieldName = fieldName;
		this.operator = operator;
	}

	public DFQueryFilterInfo(String fieldName, String operator, Object value) {
		this.fieldName = fieldName;
		this.operator = operator;
		this.fieldValue = value;
	}

	public DFQueryFilterInfo(String fieldName, String operator, Object value, Object secondValue) {
		this.fieldName = fieldName;
		this.operator = operator;
		this.fieldValue = Arrays.asList(value, secondValue);
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}

	public String getGroupName() {
		return groupName;
	}

	public DFQueryFilterInfo setGroupName(String groupName) {
		this.groupName = groupName;
		return this;
	}

	public Class<?> getFieldType() {
		if (fieldType != null) {
			return fieldType;
		}
		if (StringUtils.isNotBlank(fieldTypeStr)) {
			try {
				return ClassUtils.getClass(fieldTypeStr);
			} catch (ClassNotFoundException e) {
				return null;
			}
		}
		return fieldType;
	}

	public void setFieldType(Class<?> fieldType) {
		this.fieldType = fieldType;
	}

	public String getConnectOperator() {
		return connectOperator;
	}

	public DFQueryFilterInfo setConnectOperator(String connectOperator) {
		this.connectOperator = connectOperator;
		return this;
	}

	public String getFieldTypeStr() {
		return fieldTypeStr;
	}

	public void setFieldTypeStr(String fieldTypeStr) {
		this.fieldTypeStr = fieldTypeStr;
	}

}
