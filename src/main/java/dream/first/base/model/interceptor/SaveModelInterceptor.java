/**
 * 
 */
package dream.first.base.model.interceptor;

import java.util.Date;

import org.yelong.commons.util.Dates;
import org.yelong.core.interceptor.Intercepts;
import org.yelong.core.interceptor.Invocation;
import org.yelong.core.interceptor.Signature;
import org.yelong.core.model.Modelable;
import org.yelong.core.model.service.ModelService;
import org.yelong.core.model.service.ModelServiceInterceptor;

import dream.first.base.model.DreamFirstBaseModelable;
import dream.first.base.platform.constants.DreamFirstBaseModelState;
import dream.first.base.userauth.CurrentAuthUserInfo;
import dream.first.base.userauth.CurrentAuthUserInfoHolder;
import dream.first.base.utils.DreamFirstBaseModelIDGenerator;

/**
 * 模型保存拦截器。模型保存时默认修改模型的创建人、创建时间等数据。
 * 
 * @since 2.1
 */
@Intercepts({ @Signature(type = ModelService.class, method = "save", args = Modelable.class),
		@Signature(type = ModelService.class, method = "saveSelective", args = Modelable.class) })
public class SaveModelInterceptor implements ModelServiceInterceptor {

	public static final String SYSTEM_ADMIN_USER_NAME = "system";

	/** 是否强制设置ID */
	private boolean forceSetID;

	public SaveModelInterceptor() {
		this(true);
	}

	public SaveModelInterceptor(boolean forceSetID) {
		this.forceSetID = forceSetID;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object[] args = invocation.getArgs();
		Object model = args[0];
		// 只有是符合基础模型的对象才支持设置基础数据
		if (!(model instanceof DreamFirstBaseModelable)) {
			return invocation.proceed();
		}
		DreamFirstBaseModelable baseModel = (DreamFirstBaseModelable) model;
		if (forceSetID) {
			baseModel.setId(DreamFirstBaseModelIDGenerator.getUUID());
		} else {
			String id = baseModel.getId();
			if (null == id) {
				baseModel.setId(DreamFirstBaseModelIDGenerator.getUUID());
			}
		}
		Date nowDate = Dates.nowDate();
		if (null != baseModel.getCreateTime()) {
			baseModel.setCreateTime(nowDate);
		}
		if (null != baseModel.getUpdateTime()) {
			baseModel.setUpdateTime(nowDate);
		}
		if (null != baseModel.getState()) {
			baseModel.setState(DreamFirstBaseModelState.YES.getCode());
		}
		String userName = SYSTEM_ADMIN_USER_NAME;
		CurrentAuthUserInfo currentAuthUserInfo = CurrentAuthUserInfoHolder.currentLoginUserInfo();
		if (null != currentAuthUserInfo) {
			if (null != currentAuthUserInfo.getUser()) {
				userName = currentAuthUserInfo.getUser().getUsername();
			}
		}
		if (null != baseModel.getCreator()) {
			baseModel.setCreator(userName);
		}
		if (null != baseModel.getUpdator()) {
			baseModel.setUpdator(userName);
		}
		return invocation.proceed();
	}

}
