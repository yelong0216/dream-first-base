/**
 * 
 */
package dream.first.base.userauth;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.yelong.core.annotation.Nullable;

import dream.first.base.platform.org.model.BaseOrg;
import dream.first.base.platform.user.model.BaseUser;

/**
 * 当前登录（发送请求）的用户信息
 * 
 * @since 2.1
 */
public class CurrentAuthUserInfo<U extends BaseUser<U>, O extends BaseOrg<O>> implements Serializable {

	private static final long serialVersionUID = -4109346450125322854L;

	private final Map<String, Object> attributes = new HashMap<String, Object>();

	/**
	 * 用户信息
	 */
	@Nullable
	private U user;

	/**
	 * 用户所在组织信息
	 */
	@Nullable
	private O org;

	/**
	 * 用户所拥有的权限
	 */
	@Nullable
	private List<String> opRights;

	public U getUser() {
		return user;
	}

	public void setUser(U user) {
		this.user = user;
	}

	public O getOrg() {
		return org;
	}

	public void setOrg(O org) {
		this.org = org;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public List<String> getOpRights() {
		return opRights == null ? Collections.emptyList() : opRights;
	}

	public void setOpRights(List<String> opRights) {
		this.opRights = opRights;
	}

	public Object getAttribute(String name) {
		return this.attributes.get(name);
	}

	@SuppressWarnings("unchecked")
	public <T> T getAttribute(String name, T defaultValue) {
		return (T) this.attributes.getOrDefault(name, defaultValue);
	}

	public void setAttribute(String name, Object value) {
		this.attributes.put(name, value);
	}

}
