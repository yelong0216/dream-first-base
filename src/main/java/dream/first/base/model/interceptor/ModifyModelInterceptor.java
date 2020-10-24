/**
 * 
 */
package dream.first.base.model.interceptor;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.yelong.commons.util.Dates;
import org.yelong.core.interceptor.Intercepts;
import org.yelong.core.interceptor.Invocation;
import org.yelong.core.interceptor.Signature;
import org.yelong.core.jdbc.sql.condition.ConditionSqlFragment;
import org.yelong.core.model.Modelable;
import org.yelong.core.model.service.ModelService;
import org.yelong.core.model.service.ModelServiceInterceptor;
import org.yelong.core.model.service.SqlModelService;
import org.yelong.core.model.service.SqlModelServiceAdapter;
import org.yelong.core.model.sql.SqlModel;

import dream.first.base.model.DreamFirstBaseModelable;
import dream.first.base.userauth.CurrentAuthUserInfo;
import dream.first.base.userauth.CurrentAuthUserInfoHolder;

/**
 * 修改模型拦截器。模型修改时统一修改模型的修改时间和修改人信息。修改人为当前登录人，修改时间为当前的时间。如果当前没有登录人信息，则为 system
 * 
 * @see CurrentAuthUserInfoHolder
 * @since 2.0.1
 */
@Intercepts({
		@Signature(type = ModelService.class, method = "modifyBySqlFragment", args = { Modelable.class,
				ConditionSqlFragment.class }),
		@Signature(type = ModelService.class, method = "modifySelectiveBySqlFragment", args = { Modelable.class,
				ConditionSqlFragment.class }),
		@Signature(type = SqlModelService.class, method = "modifyBySqlModel", args = { Modelable.class,
				SqlModel.class }),
		@Signature(type = SqlModelService.class, method = "modifySelectiveBySqlModel", args = { Modelable.class,
				SqlModel.class }),
		@Signature(type = SqlModelServiceAdapter.class, method = "modifyById", args = { Modelable.class }),
		@Signature(type = SqlModelServiceAdapter.class, method = "modifyByOnlyPrimaryKey", args = { Modelable.class }),
		@Signature(type = SqlModelServiceAdapter.class, method = "modifySelectiveById", args = { Modelable.class }),
		@Signature(type = SqlModelServiceAdapter.class, method = "modifySelectiveByOnlyPrimaryKey", args = {
				Modelable.class }),
		@Signature(type = SqlModelServiceAdapter.class, method = "modifyByCondition", args = { Modelable.class,
				ConditionSqlFragment.class }),
		@Signature(type = SqlModelServiceAdapter.class, method = "modifySelectiveByCondition", args = { Modelable.class,
				ConditionSqlFragment.class }), })
public class ModifyModelInterceptor implements ModelServiceInterceptor {

	public static final String SYSTEM_ADMIN_USER_NAME = "system";

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
		Date nowDate = Dates.nowDate();
		String userName = SYSTEM_ADMIN_USER_NAME;
		CurrentAuthUserInfo currentAuthUserInfo = CurrentAuthUserInfoHolder.currentLoginUserInfo();
		if (null != currentAuthUserInfo) {
			if (null != currentAuthUserInfo.getUser()) {
				userName = currentAuthUserInfo.getUser().getUsername();
			}
		}
		if (null == baseModel.getUpdateTime()) {
			baseModel.setUpdateTime(nowDate);
		}
		if (StringUtils.isBlank(baseModel.getUpdator())) {
			baseModel.setUpdator(userName);
		}
		return invocation.proceed();
	}

}
