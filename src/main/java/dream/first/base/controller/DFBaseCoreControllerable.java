package dream.first.base.controller;

import org.yelong.core.annotation.Nullable;
import org.yelong.support.servlet.mvc.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dream.first.base.gson.DreamFirstGsonSupplier;
import dream.first.base.platform.org.model.BaseOrg;
import dream.first.base.platform.user.model.BaseUser;
import dream.first.base.userauth.CurrentAuthUserInfo;
import dream.first.base.userauth.CurrentAuthUserInfoHolder;

/**
 * @since 2.1
 */
public interface DFBaseCoreControllerable extends Controller {

	/**
	 * 使用默认的Gson将对象转换转换为JSON
	 * 
	 * @param obj 对象
	 * @return JSON格式的字符串
	 * @see #getGson()
	 */
	default String toJson(Object obj) {
		Gson gson = getGson();
		return gson.toJson(obj);
	}

	/**
	 * @return 默认的Gson
	 * @see DreamFirstGsonSupplier#getDefaultGson()
	 */
	default Gson getGson() {
		return DreamFirstGsonSupplier.getDefaultGson();
	}

	/**
	 * @return 默认Gson构建器
	 * @see DreamFirstGsonSupplier#createGsonBuilder()
	 */
	default GsonBuilder createDefaultGsonBuilder() {
		return DreamFirstGsonSupplier.createGsonBuilder();
	}

	// ==================================================authUserInfo==================================================

	/**
	 * @return 当前登录/请求人的相关信息
	 * @see CurrentAuthUserInfoHolder#currentLoginUserInfo()
	 */
	@Nullable
	default CurrentAuthUserInfo<?, ?> getCurrentLoginUserInfo() {
		return CurrentAuthUserInfoHolder.currentLoginUserInfo();
	}

	/**
	 * @return 当前登录/请求人用户信息
	 * @see CurrentAuthUserInfoHolder#getCurrentLoginUser()
	 */
	@Nullable
	default BaseUser<?> getCurrentLoginUser() {
		return CurrentAuthUserInfoHolder.getCurrentLoginUser();
	}

	/**
	 * @return 当前登录/请求人用户信息
	 * @see CurrentAuthUserInfoHolder#getCurrentLoginUserId()
	 */
	@Nullable
	default String getCurrentLoginUserId() {
		return CurrentAuthUserInfoHolder.getCurrentLoginUserId();
	}

	/**
	 * @return 当前登录/请求人的用户名称(账号)
	 * @see CurrentAuthUserInfoHolder#getCurrentLoginUsername()
	 */
	@Nullable
	default String getCurrentLoginUsername() {
		return CurrentAuthUserInfoHolder.getCurrentLoginUsername();
	}

	/**
	 * @return 当前登录/请求人的用户真实名称
	 * @see CurrentAuthUserInfoHolder#getCurrentLoginUserRealName()
	 */
	@Nullable
	default String getCurrentLoginUserRealName() {
		return CurrentAuthUserInfoHolder.getCurrentLoginUserRealName();
	}

	/**
	 * @return 当前登录/请求人的用户所在部门
	 * @see CurrentAuthUserInfoHolder#getCurrentLoginUserOrg()
	 */
	@Nullable
	default BaseOrg<?> getCurrentLoginUserOrg() {
		return CurrentAuthUserInfoHolder.getCurrentLoginUserOrg();
	}

	/**
	 * @return 当前登录/请求人的用户所有在部门的ID
	 * @see CurrentAuthUserInfoHolder#getCurrentLoginUserOrgId()
	 */
	@Nullable
	default String getCurrentLoginUserOrgId() {
		return CurrentAuthUserInfoHolder.getCurrentLoginUserOrgId();
	}

	/**
	 * @return 当前登录/请求人的用户所在部门的编号
	 * @see CurrentAuthUserInfoHolder#getCurrentLoginUserOrgNo()
	 */
	@Nullable
	default String getCurrentLoginUserOrgNo() {
		return CurrentAuthUserInfoHolder.getCurrentLoginUserOrgNo();
	}

}
