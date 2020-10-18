/**
 * 
 */
package dream.first.base.userauth;

import org.yelong.core.annotation.Nullable;

import dream.first.base.platform.org.model.BaseOrg;
import dream.first.base.platform.user.model.BaseUser;

/**
 * 当前登录（请求）用户{@link CurrentAuthUserInfo}的持有者
 * 
 * @since 2.1
 */
@SuppressWarnings("rawtypes")
public final class CurrentAuthUserInfoHolder {

	private CurrentAuthUserInfoHolder() {
	}

	private static final ThreadLocal<CurrentAuthUserInfo> CURRENT_LOGIN_USER_INFO = new ThreadLocal<>();

	/**
	 * 设置当前登录（请求）用户的信息
	 * 
	 * @param currentLoginUserInfo 当前登录（请求）用户的信息
	 */
	public static void setCurrentLoginUserInfo(CurrentAuthUserInfo currentLoginUserInfo) {
		CURRENT_LOGIN_USER_INFO.set(currentLoginUserInfo);
	}

	/**
	 * @return 当前登录（请求）用户的信息
	 */
	@Nullable
	public static CurrentAuthUserInfo currentLoginUserInfo() {
		return CURRENT_LOGIN_USER_INFO.get();
	}

	/**
	 * @return 当前登录/请求人的相关信息
	 * @see #currentLoginUserInfo()
	 */
	@Nullable
	public static CurrentAuthUserInfo getCurrentLoginUserInfo() {
		return currentLoginUserInfo();
	}

	/**
	 * @return 当前登录/请求人用户信息
	 */
	@Nullable
	public static BaseUser<?> getCurrentLoginUser() {
		CurrentAuthUserInfo currentLoginUserInfo = getCurrentLoginUserInfo();
		return null == currentLoginUserInfo ? null : currentLoginUserInfo.getUser();
	}

	/**
	 * @return 当前登录/请求人的用户名称(账号)
	 */
	@Nullable
	public static String getCurrentLoginUsername() {
		BaseUser<?> user = getCurrentLoginUser();
		return null == user ? null : user.getUsername();
	}

	/**
	 * @return 当前登录/请求人的用户真实名称
	 */
	@Nullable
	public static String getCurrentLoginUserRealName() {
		BaseUser<?> user = getCurrentLoginUser();
		return null == user ? null : user.getRealName();
	}

	/**
	 * @return 当前登录/请求人的用户所在部门
	 */
	@Nullable
	public static BaseOrg<?> getCurrentLoginUserOrg() {
		CurrentAuthUserInfo currentLoginUserInfo = getCurrentLoginUserInfo();
		return null == currentLoginUserInfo ? null : currentLoginUserInfo.getOrg();
	}

	/**
	 * @return 当前登录/请求人的用户所有在部门的ID
	 */
	@Nullable
	public static String getCurrentLoginUserOrgId() {
		BaseOrg<?> org = getCurrentLoginUserOrg();
		return null == org ? null : org.getId();
	}

	/**
	 * @return 当前登录/请求人的用户所在部门的编号
	 */
	@Nullable
	public static String getCurrentLoginUserOrgNo() {
		BaseOrg<?> org = getCurrentLoginUserOrg();
		return null == org ? null : org.getOrgNo();
	}

}
