/**
 * 
 */
package dream.first.base.controller;

import org.yelong.support.spring.mvc.controller.AbstractSpringMvcController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dream.first.base.gson.DreamFirstGsonSupplier;

/**
 * 基础的 controller
 * 
 * 提供默认的JSON转换，获取当前登陆人等公共且常用的方法
 * 
 * @since 1.0.0
 */
public abstract class DreamFirstBaseCoreController extends AbstractSpringMvcController {

	/**
	 * 使用默认的Gson将对象转换转换为JSON
	 * 
	 * @param obj 对象
	 * @return JSON格式的字符串
	 * @see #getGson()
	 */
	protected String toJson(Object obj) {
		Gson gson = getGson();
		return gson.toJson(obj);
	}

	/**
	 * @return 默认的Gson
	 * @see DreamFirstGsonSupplier#getDefaultGson()
	 */
	protected Gson getGson() {
		return DreamFirstGsonSupplier.getDefaultGson();
	}

	/**
	 * @return 默认Gson构建器
	 * @see DreamFirstGsonSupplier#createGsonBuilder()
	 */
	protected GsonBuilder createDefaultGsonBuilder() {
		return DreamFirstGsonSupplier.createGsonBuilder();
	}

}
