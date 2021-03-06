package dream.first.base.platform.role.model;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;

import dream.first.base.model.DreamFirstBaseModel;

@Table(value = "CO_ROLE", alias = "role", desc = "角色")
public class BaseRole<M extends BaseRole<M>> extends DreamFirstBaseModel<M> {

	private static final long serialVersionUID = 4236803973459115666L;

	@Column(columnName = "角色名称")
	private String roleName;

	@Column(columnName = "角色类型")
	private String roleType;

	@Column(columnName = "角色描述")
	private String roleDesc;

	@Column(columnName = "角色属性")
	private String roleProperty;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getRoleProperty() {
		return roleProperty;
	}

	public void setRoleProperty(String roleProperty) {
		this.roleProperty = roleProperty;
	}

}
