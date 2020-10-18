/**
 * 
 */
package dream.first.base.model;

import org.yelong.core.model.Modelable;
import org.yelong.core.model.sql.SqlModel;

/**
 * 一个SqlModel和模型之间的适配器
 *
 * @param <M> model type
 * @since 2.1
 */
public abstract class DreamFirstBaseSqlModel<M extends Modelable> extends SqlModel<M> implements Modelable {

	private static final long serialVersionUID = 3813146467899989274L;

	@SuppressWarnings("unchecked")
	@Override
	public M getModel() {
		return (M) this;
	}

	@Override
	public Class<? extends Modelable> getModelClass() {
		return getClass();
	}

}
